package com.samsung.android.sdk.look.airbutton;

import android.content.ContentUris;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video.Media;
import android.provider.MediaStore.Video.Thumbnails;
import android.view.View;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.sdk.look.SlookResourceManager;
import java.util.ArrayList;

public final class SlookAirButtonRecentMediaAdapter
  extends SlookAirButtonAdapter
{
  public static final String AUDIO_TYPE = "audio";
  private static final String ID = "id";
  public static final String IMAGE_TYPE = "image";
  private static final String MIME_TYPE = "mime_type";
  private static final String ORIENTATION = "orientation";
  private static final String TAG = "AirButtonRecentMediaAdapter";
  private static final String TITLE = "title";
  public static final String VIDEO_TYPE = "video";
  private static final String VOLUME = "external";
  private boolean DEBUG = false;
  private Context mContext;
  private int mCount = 0;
  private ArrayList<Bundle> mData = new ArrayList();
  private String mFilter;
  private boolean mIsShowing = false;
  private int mMaxCount = 15;
  private boolean mNeedUpdate = true;
  private Slook mSlook = new Slook();
  
  public SlookAirButtonRecentMediaAdapter(View paramView, Bundle paramBundle)
  {
    if ((paramView == null) && (paramBundle == null)) {
      throw new IllegalArgumentException("You should set the View and Bundle in Param");
    }
    if (!isSupport(1)) {}
    do
    {
      return;
      this.mFilter = getFilter(paramBundle);
    } while (paramView == null);
    this.mContext = paramView.getContext();
    this.DEBUG = true;
    this.mMaxCount = SlookResourceManager.getInt(3);
    setEmptyText(SlookResourceManager.getText(this.mContext, 1));
  }
  
  private Drawable getAudioDrawable(String paramString)
  {
    paramString = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramString);
    int i = SlookResourceManager.getDrawableId(2);
    Drawable localDrawable = this.mContext.getResources().getDrawable(i);
    localDrawable.setBounds(new Rect(0, 0, 200, 200));
    localCanvas.drawColor(-2236963, PorterDuff.Mode.SRC);
    localDrawable.draw(localCanvas);
    return new BitmapDrawable(this.mContext.getResources(), paramString);
  }
  
  private String getFilter(Bundle paramBundle)
  {
    int i = 0;
    Object localObject = new StringBuilder();
    if ((paramBundle == null) || (paramBundle.getBoolean("image")))
    {
      ((StringBuilder)localObject).append("media_type = ");
      ((StringBuilder)localObject).append(1);
      i = 1;
    }
    int j;
    if (paramBundle != null)
    {
      j = i;
      if (!paramBundle.getBoolean("video")) {}
    }
    else
    {
      if (i != 0) {
        ((StringBuilder)localObject).append(" or ");
      }
      ((StringBuilder)localObject).append("media_type = ");
      ((StringBuilder)localObject).append(3);
      j = 1;
    }
    if ((paramBundle == null) || (paramBundle.getBoolean("audio")))
    {
      if (j != 0) {
        ((StringBuilder)localObject).append(" or ");
      }
      ((StringBuilder)localObject).append("media_type = ");
      ((StringBuilder)localObject).append(2);
    }
    localObject = ((StringBuilder)localObject).toString();
    if (localObject != null)
    {
      paramBundle = (Bundle)localObject;
      if (((String)localObject).length() > 0) {}
    }
    else
    {
      paramBundle = null;
    }
    return paramBundle;
  }
  
  private Drawable getThumbNail(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    switch (paramInt2)
    {
    default: 
      return null;
    case 1: 
      paramString = new BitmapFactory.Options();
      paramString.inSampleSize = 2;
      paramString = MediaStore.Images.Thumbnails.getThumbnail(this.mContext.getContentResolver(), paramInt1, 1, paramString);
      if (paramString != null)
      {
        if ((paramInt3 == 90) || (paramInt3 == 180) || (paramInt3 == 270))
        {
          Matrix localMatrix = new Matrix();
          localMatrix.postRotate(paramInt3);
          paramString = Bitmap.createBitmap(paramString, 0, 0, paramString.getWidth(), paramString.getHeight(), localMatrix, true);
          return new BitmapDrawable(this.mContext.getResources(), paramString);
        }
        return new BitmapDrawable(this.mContext.getResources(), paramString);
      }
      break;
    case 3: 
      paramString = MediaStore.Video.Thumbnails.getThumbnail(this.mContext.getContentResolver(), paramInt1, 3, null);
      return new BitmapDrawable(this.mContext.getResources(), paramString);
    case 2: 
      return getAudioDrawable(paramString);
    }
    return null;
  }
  
  private Uri getUri(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return null;
    case 1: 
      return ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, paramInt1);
    case 3: 
      return ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, paramInt1);
    }
    return ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, paramInt1);
  }
  
  private boolean isSupport(int paramInt)
  {
    return this.mSlook.isFeatureEnabled(1);
  }
  
  /* Error */
  private void updateData()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mNeedUpdate	Z
    //   6: ifeq +12 -> 18
    //   9: aload_0
    //   10: getfield 68	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mIsShowing	Z
    //   13: istore_1
    //   14: iload_1
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 70	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mNeedUpdate	Z
    //   26: aload_0
    //   27: getfield 59	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mData	Ljava/util/ArrayList;
    //   30: invokevirtual 273	java/util/ArrayList:clear	()V
    //   33: aload_0
    //   34: getfield 97	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mContext	Landroid/content/Context;
    //   37: invokevirtual 219	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   40: astore_2
    //   41: ldc 32
    //   43: invokestatic 279	android/provider/MediaStore$Files:getContentUri	(Ljava/lang/String;)Landroid/net/Uri;
    //   46: astore_3
    //   47: aload_0
    //   48: getfield 89	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mFilter	Ljava/lang/String;
    //   51: astore 4
    //   53: new 179	java/lang/StringBuilder
    //   56: dup
    //   57: ldc_w 281
    //   60: invokespecial 282	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload_0
    //   64: getfield 54	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mMaxCount	I
    //   67: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: astore 5
    //   75: aload_2
    //   76: aload_3
    //   77: iconst_4
    //   78: anewarray 203	java/lang/String
    //   81: dup
    //   82: iconst_0
    //   83: ldc_w 284
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: ldc_w 286
    //   92: aastore
    //   93: dup
    //   94: iconst_2
    //   95: ldc 26
    //   97: aastore
    //   98: dup
    //   99: iconst_3
    //   100: ldc 20
    //   102: aastore
    //   103: aload 4
    //   105: aconst_null
    //   106: aload 5
    //   108: invokevirtual 292	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   111: astore_2
    //   112: aload_2
    //   113: ifnonnull +21 -> 134
    //   116: aload_2
    //   117: ifnull -99 -> 18
    //   120: aload_2
    //   121: invokeinterface 297 1 0
    //   126: goto -108 -> 18
    //   129: astore_2
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_2
    //   133: athrow
    //   134: aload_2
    //   135: invokeinterface 301 1 0
    //   140: ifeq +81 -> 221
    //   143: new 182	android/os/Bundle
    //   146: dup
    //   147: invokespecial 302	android/os/Bundle:<init>	()V
    //   150: astore_3
    //   151: aload_3
    //   152: ldc 11
    //   154: aload_2
    //   155: iconst_0
    //   156: invokeinterface 303 2 0
    //   161: invokevirtual 307	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   164: aload_3
    //   165: ldc 17
    //   167: aload_2
    //   168: iconst_1
    //   169: invokeinterface 303 2 0
    //   174: invokevirtual 307	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   177: aload_3
    //   178: ldc 20
    //   180: aload_2
    //   181: iconst_3
    //   182: invokeinterface 303 2 0
    //   187: invokevirtual 307	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   190: aload_0
    //   191: getfield 59	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mData	Ljava/util/ArrayList;
    //   194: aload_3
    //   195: invokevirtual 311	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   198: pop
    //   199: goto -65 -> 134
    //   202: astore 4
    //   204: aload_2
    //   205: astore_3
    //   206: aload 4
    //   208: astore_2
    //   209: aload_3
    //   210: ifnull +9 -> 219
    //   213: aload_3
    //   214: invokeinterface 297 1 0
    //   219: aload_2
    //   220: athrow
    //   221: aload_2
    //   222: ifnull +9 -> 231
    //   225: aload_2
    //   226: invokeinterface 297 1 0
    //   231: aload_0
    //   232: aload_0
    //   233: getfield 59	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mData	Ljava/util/ArrayList;
    //   236: invokevirtual 314	java/util/ArrayList:size	()I
    //   239: putfield 72	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mCount	I
    //   242: goto -224 -> 18
    //   245: astore_2
    //   246: aconst_null
    //   247: astore_3
    //   248: goto -39 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	SlookAirButtonRecentMediaAdapter
    //   13	2	1	bool	boolean
    //   40	81	2	localObject1	Object
    //   129	76	2	localObject2	Object
    //   208	18	2	localObject3	Object
    //   245	1	2	localObject4	Object
    //   46	202	3	localObject5	Object
    //   51	53	4	str1	String
    //   202	5	4	localObject6	Object
    //   73	34	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	14	129	finally
    //   21	33	129	finally
    //   120	126	129	finally
    //   213	219	129	finally
    //   219	221	129	finally
    //   225	231	129	finally
    //   231	242	129	finally
    //   134	199	202	finally
    //   33	112	245	finally
  }
  
  public final int getCount()
  {
    return this.mCount;
  }
  
  public final SlookAirButtonAdapter.AirButtonItem getItem(int paramInt)
  {
    Bundle localBundle = (Bundle)this.mData.get(paramInt);
    paramInt = localBundle.getInt("id");
    int i = localBundle.getInt("mime_type");
    return new SlookAirButtonAdapter.AirButtonItem(getThumbNail(paramInt, i, localBundle.getString("title"), localBundle.getInt("orientation")), null, getUri(paramInt, i));
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
 * Qualified Name:     com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter
 * JD-Core Version:    0.7.0.1
 */