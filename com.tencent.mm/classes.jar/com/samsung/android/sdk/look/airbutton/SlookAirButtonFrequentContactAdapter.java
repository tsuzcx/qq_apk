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
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private boolean DEBUG;
  private final String EXTRA_CONDITION;
  private final String IS_PRIVATE;
  private Context mContext;
  private int mCount;
  private ArrayList<Bundle> mData;
  private boolean mIsShowing;
  private int mMaxCount;
  private boolean mNeedUpdate;
  private StringBuilder mSelectionSb;
  private Slook mSlook;
  
  public SlookAirButtonFrequentContactAdapter(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(117235);
    this.IS_PRIVATE = "is_private";
    this.EXTRA_CONDITION = "extra_condition";
    this.mData = new ArrayList();
    this.mSlook = new Slook();
    this.mMaxCount = 15;
    this.DEBUG = false;
    this.mIsShowing = false;
    this.mNeedUpdate = true;
    this.mCount = 0;
    if ((paramView == null) && (paramBundle == null))
    {
      paramView = new IllegalArgumentException("You should set the View and Bundle in Param");
      AppMethodBeat.o(117235);
      throw paramView;
    }
    if (!isSupport(1))
    {
      AppMethodBeat.o(117235);
      return;
    }
    if (paramBundle != null)
    {
      String str = paramBundle.getString("MIME_TYPE");
      this.mSelectionSb = new StringBuilder();
      if (str == null) {
        break label308;
      }
      this.mSelectionSb.append("view_data.");
      this.mSelectionSb.append("mimetype");
      this.mSelectionSb.append("='");
      this.mSelectionSb.append(str);
      this.mSelectionSb.append("'");
    }
    label308:
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
      if (paramView != null)
      {
        this.mContext = paramView.getContext();
        setEmptyText(SlookResourceManager.getText(this.mContext, 0));
      }
      AppMethodBeat.o(117235);
      return;
    }
  }
  
  private boolean isSupport(int paramInt)
  {
    AppMethodBeat.i(117241);
    if (this.mSlook.isFeatureEnabled(1))
    {
      AppMethodBeat.o(117241);
      return true;
    }
    AppMethodBeat.o(117241);
    return false;
  }
  
  private void updateData()
  {
    Object localObject4;
    Object localObject3;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(117240);
        if ((!this.mNeedUpdate) || (this.mIsShowing))
        {
          AppMethodBeat.o(117240);
          return;
        }
        this.mNeedUpdate = false;
        this.mData.clear();
        localObject4 = Uri.parse("content://com.android.contacts/contacts/frequent_data");
        ContentResolver localContentResolver = this.mContext.getContentResolver();
        if (this.mSelectionSb != null)
        {
          Object localObject1 = this.mSelectionSb.toString();
          String str = "_id LIMIT " + this.mMaxCount;
          localObject1 = localContentResolver.query((Uri)localObject4, new String[] { "_id", "display_name", "photo_uri", "data15", "lookup", "mimetype", "data1", "is_private" }, (String)localObject1, null, str);
          if (localObject1 != null) {
            break;
          }
          AppMethodBeat.o(117240);
        }
        else
        {
          localObject3 = null;
        }
      }
      finally {}
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          if (localObject3.moveToNext())
          {
            localObject4 = new Bundle();
            ((Bundle)localObject4).putInt("id", localObject3.getInt(0));
            ((Bundle)localObject4).putString("display_name", localObject3.getString(1));
            ((Bundle)localObject4).putString("photo_uri", localObject3.getString(2));
            ((Bundle)localObject4).putByteArray("photo", localObject3.getBlob(3));
            ((Bundle)localObject4).putString("lookup_key", localObject3.getString(4));
            ((Bundle)localObject4).putString("MIME_TYPE", localObject3.getString(5));
            ((Bundle)localObject4).putString("data", localObject3.getString(6));
            if (localObject3.getInt(7) != 1) {
              break label370;
            }
            bool = true;
            ((Bundle)localObject4).putBoolean("is_private", bool);
            this.mData.add(localObject4);
            continue;
          }
          if (localObject3 == null) {
            break label342;
          }
        }
        finally
        {
          if (localObject3 != null) {
            localObject3.close();
          }
          AppMethodBeat.o(117240);
        }
        localObject3.close();
        try
        {
          label342:
          this.mCount = this.mData.size();
          AppMethodBeat.o(117240);
        }
        catch (NoSuchMethodError localNoSuchMethodError)
        {
          AppMethodBeat.o(117240);
        }
      }
      break;
      label370:
      boolean bool = false;
    }
  }
  
  public final int getCount()
  {
    return this.mCount;
  }
  
  public final SlookAirButtonAdapter.AirButtonItem getItem(int paramInt)
  {
    AppMethodBeat.i(117239);
    Bundle localBundle = (Bundle)this.mData.get(paramInt);
    String str1 = localBundle.getString("display_name");
    String str2 = localBundle.getString("data");
    Object localObject = localBundle.getByteArray("photo");
    if (localObject == null) {
      paramInt = SlookResourceManager.getDrawableId(1);
    }
    for (localObject = this.mContext.getResources().getDrawable(paramInt);; localObject = new BitmapDrawable(this.mContext.getResources(), BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length)))
    {
      localObject = new SlookAirButtonAdapter.AirButtonItem((Drawable)localObject, str1, str2, localBundle);
      AppMethodBeat.o(117239);
      return localObject;
    }
  }
  
  public final void onDismiss(View paramView)
  {
    AppMethodBeat.i(117238);
    this.mIsShowing = false;
    this.mNeedUpdate = true;
    this.mData.clear();
    super.onDismiss(paramView);
    AppMethodBeat.o(117238);
  }
  
  public final void onHide(View paramView)
  {
    AppMethodBeat.i(117237);
    this.mIsShowing = false;
    this.mNeedUpdate = true;
    this.mData.clear();
    super.onHide(paramView);
    AppMethodBeat.o(117237);
  }
  
  public final void onShow(View paramView)
  {
    AppMethodBeat.i(117236);
    updateData();
    this.mIsShowing = true;
    super.onShow(paramView);
    AppMethodBeat.o(117236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter
 * JD-Core Version:    0.7.0.1
 */