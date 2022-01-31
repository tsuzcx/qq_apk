package com.samsung.android.sdk.look.airbutton;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.sdk.look.SlookResourceManager;
import java.util.ArrayList;

public final class SlookAirButtonFrequentContactAdapter
  extends SlookAirButtonAdapter
{
  public static final String DATA = "data";
  public static final String DISPLAY_NAME = "display_name";
  private static final String EMAIL = "vnd.android.cursor.item/email_v2";
  private static final String FREQUENT_URI = "content://com.android.contacts/contacts/frequent_data";
  public static final String ID = "id";
  public static final String LOOKUP_KEY = "lookup_key";
  private static final String MIME_TYPE = "MIME_TYPE";
  private static final String PHONE = "vnd.android.cursor.item/phone_v2";
  public static final String PHOTO = "photo";
  public static final String PHOTO_URI = "photo_uri";
  private static final String TAG = "AirButtonFrequentContactAdapter";
  private boolean DEBUG = false;
  private final String EXTRA_CONDITION = "extra_condition";
  private final String IS_PRIVATE = "is_private";
  private Context mContext;
  private int mCount = 0;
  private ArrayList<Bundle> mData = new ArrayList();
  private boolean mIsShowing = false;
  private int mMaxCount = 15;
  private boolean mNeedUpdate = true;
  private StringBuilder mSelectionSb;
  private Slook mSlook = new Slook();
  
  public SlookAirButtonFrequentContactAdapter(View paramView, Bundle paramBundle)
  {
    if ((paramView == null) && (paramBundle == null)) {
      throw new IllegalArgumentException("You should set the View and Bundle in Param");
    }
    if (!isSupport(1)) {
      return;
    }
    if (paramBundle != null)
    {
      String str = paramBundle.getString("MIME_TYPE");
      this.mSelectionSb = new StringBuilder();
      if (str == null) {
        break label286;
      }
      this.mSelectionSb.append("view_data.");
      this.mSelectionSb.append("mimetype");
      this.mSelectionSb.append("='");
      this.mSelectionSb.append(str);
      this.mSelectionSb.append("'");
    }
    label286:
    for (int i = 1;; i = 0)
    {
      boolean bool = paramBundle.getBoolean("PRIVATE", false);
      if (!bool)
      {
        if (i != 0) {
          this.mSelectionSb.append(" and ");
        }
        this.mSelectionSb.append("is_private=0");
      }
      paramBundle = paramBundle.getString("extra_condition");
      if (paramBundle != null)
      {
        if ((i != 0) || (!bool)) {
          this.mSelectionSb.append(" and ");
        }
        this.mSelectionSb.append(paramBundle);
      }
      this.mMaxCount = SlookResourceManager.getInt(2);
      this.DEBUG = true;
      if (paramView == null) {
        break;
      }
      this.mContext = paramView.getContext();
      setEmptyText(SlookResourceManager.getText(this.mContext, 0));
      return;
    }
  }
  
  private boolean isSupport(int paramInt)
  {
    return this.mSlook.isFeatureEnabled(1);
  }
  
  private void updateData()
  {
    for (;;)
    {
      try
      {
        if (this.mNeedUpdate)
        {
          bool = this.mIsShowing;
          if (!bool) {}
        }
        else
        {
          return;
        }
        this.mNeedUpdate = false;
        this.mData.clear();
        Object localObject4 = Uri.parse("content://com.android.contacts/contacts/frequent_data");
        ContentResolver localContentResolver = this.mContext.getContentResolver();
        if (this.mSelectionSb != null)
        {
          Object localObject1 = this.mSelectionSb.toString();
          String str = "_id LIMIT " + this.mMaxCount;
          localObject1 = localContentResolver.query((Uri)localObject4, new String[] { "_id", "display_name", "photo_uri", "data15", "lookup", "mimetype", "data1", "is_private" }, (String)localObject1, null, str);
          if (localObject1 == null) {
            continue;
          }
          try
          {
            if (!((Cursor)localObject1).moveToNext()) {
              break label316;
            }
            localObject4 = new Bundle();
            ((Bundle)localObject4).putInt("id", ((Cursor)localObject1).getInt(0));
            ((Bundle)localObject4).putString("display_name", ((Cursor)localObject1).getString(1));
            ((Bundle)localObject4).putString("photo_uri", ((Cursor)localObject1).getString(2));
            ((Bundle)localObject4).putByteArray("photo", ((Cursor)localObject1).getBlob(3));
            ((Bundle)localObject4).putString("lookup_key", ((Cursor)localObject1).getString(4));
            ((Bundle)localObject4).putString("MIME_TYPE", ((Cursor)localObject1).getString(5));
            ((Bundle)localObject4).putString("data", ((Cursor)localObject1).getString(6));
            if (((Cursor)localObject1).getInt(7) != 1) {
              break label311;
            }
            bool = true;
            ((Bundle)localObject4).putBoolean("is_private", bool);
            this.mData.add(localObject4);
            continue;
            localObject2 = finally;
          }
          finally
          {
            if (localObject1 != null) {
              ((Cursor)localObject1).close();
            }
          }
        }
        localObject3 = null;
      }
      finally {}
      Object localObject3;
      continue;
      label311:
      boolean bool = false;
      continue;
      label316:
      if (localObject3 != null) {
        localObject3.close();
      }
      try
      {
        this.mCount = this.mData.size();
      }
      catch (NoSuchMethodError localNoSuchMethodError) {}
    }
  }
  
  public final int getCount()
  {
    return this.mCount;
  }
  
  public final SlookAirButtonAdapter.AirButtonItem getItem(int paramInt)
  {
    Bundle localBundle = (Bundle)this.mData.get(paramInt);
    String str1 = localBundle.getString("display_name");
    String str2 = localBundle.getString("data");
    Object localObject = localBundle.getByteArray("photo");
    if (localObject == null) {
      paramInt = SlookResourceManager.getDrawableId(1);
    }
    for (localObject = this.mContext.getResources().getDrawable(paramInt);; localObject = new BitmapDrawable(this.mContext.getResources(), BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length))) {
      return new SlookAirButtonAdapter.AirButtonItem((Drawable)localObject, str1, str2, localBundle);
    }
  }
  
  public final void onDismiss(View paramView)
  {
    this.mIsShowing = false;
    this.mNeedUpdate = true;
    this.mData.clear();
    super.onDismiss(paramView);
  }
  
  public final void onHide(View paramView)
  {
    this.mIsShowing = false;
    this.mNeedUpdate = true;
    this.mData.clear();
    super.onHide(paramView);
  }
  
  public final void onShow(View paramView)
  {
    updateData();
    this.mIsShowing = true;
    super.onShow(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter
 * JD-Core Version:    0.7.0.1
 */