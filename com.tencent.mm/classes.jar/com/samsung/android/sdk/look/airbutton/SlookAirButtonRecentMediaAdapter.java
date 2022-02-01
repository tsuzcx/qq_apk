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
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private boolean DEBUG;
  private Context mContext;
  private int mCount;
  private ArrayList<Bundle> mData;
  private String mFilter;
  private boolean mIsShowing;
  private int mMaxCount;
  private boolean mNeedUpdate;
  private Slook mSlook;
  
  public SlookAirButtonRecentMediaAdapter(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(76263);
    this.mMaxCount = 15;
    this.mData = new ArrayList();
    this.mSlook = new Slook();
    this.DEBUG = false;
    this.mIsShowing = false;
    this.mNeedUpdate = true;
    this.mCount = 0;
    if ((paramView == null) && (paramBundle == null))
    {
      paramView = new IllegalArgumentException("You should set the View and Bundle in Param");
      AppMethodBeat.o(76263);
      throw paramView;
    }
    if (!isSupport(1))
    {
      AppMethodBeat.o(76263);
      return;
    }
    this.mFilter = getFilter(paramBundle);
    if (paramView != null)
    {
      this.mContext = paramView.getContext();
      this.DEBUG = true;
      this.mMaxCount = SlookResourceManager.getInt(3);
      setEmptyText(SlookResourceManager.getText(this.mContext, 1));
    }
    AppMethodBeat.o(76263);
  }
  
  private Drawable getAudioDrawable(String paramString)
  {
    AppMethodBeat.i(76266);
    paramString = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramString);
    int i = SlookResourceManager.getDrawableId(2);
    Drawable localDrawable = this.mContext.getResources().getDrawable(i);
    localDrawable.setBounds(new Rect(0, 0, 200, 200));
    localCanvas.drawColor(-2236963, PorterDuff.Mode.SRC);
    localDrawable.draw(localCanvas);
    paramString = new BitmapDrawable(this.mContext.getResources(), paramString);
    AppMethodBeat.o(76266);
    return paramString;
  }
  
  private String getFilter(Bundle paramBundle)
  {
    AppMethodBeat.i(76268);
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramBundle == null) || (paramBundle.getBoolean("image")))
    {
      localStringBuilder.append("media_type = ");
      localStringBuilder.append(1);
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
        localStringBuilder.append(" or ");
      }
      localStringBuilder.append("media_type = ");
      localStringBuilder.append(3);
      j = 1;
    }
    if ((paramBundle == null) || (paramBundle.getBoolean("audio")))
    {
      if (j != 0) {
        localStringBuilder.append(" or ");
      }
      localStringBuilder.append("media_type = ");
      localStringBuilder.append(2);
    }
    paramBundle = localStringBuilder.toString();
    if ((paramBundle == null) || (paramBundle.length() <= 0))
    {
      AppMethodBeat.o(76268);
      return null;
    }
    AppMethodBeat.o(76268);
    return paramBundle;
  }
  
  private Drawable getThumbNail(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(76265);
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(76265);
      return null;
    case 1: 
      paramString = new BitmapFactory.Options();
      paramString.inSampleSize = 2;
      paramString = MediaStore.Images.Thumbnails.getThumbnail(this.mContext.getContentResolver(), paramInt1, 1, paramString);
      if (paramString != null) {
        if ((paramInt3 == 90) || (paramInt3 == 180) || (paramInt3 == 270))
        {
          Matrix localMatrix = new Matrix();
          localMatrix.postRotate(paramInt3);
          paramString = Bitmap.createBitmap(paramString, 0, 0, paramString.getWidth(), paramString.getHeight(), localMatrix, true);
          paramString = new BitmapDrawable(this.mContext.getResources(), paramString);
        }
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(76265);
      return paramString;
      paramString = new BitmapDrawable(this.mContext.getResources(), paramString);
      continue;
      paramString = MediaStore.Video.Thumbnails.getThumbnail(this.mContext.getContentResolver(), paramInt1, 3, null);
      paramString = new BitmapDrawable(this.mContext.getResources(), paramString);
      AppMethodBeat.o(76265);
      return paramString;
      paramString = getAudioDrawable(paramString);
      AppMethodBeat.o(76265);
      return paramString;
      paramString = null;
    }
  }
  
  private Uri getUri(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76267);
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(76267);
      return null;
    case 1: 
      localUri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, paramInt1);
      AppMethodBeat.o(76267);
      return localUri;
    case 3: 
      localUri = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, paramInt1);
      AppMethodBeat.o(76267);
      return localUri;
    }
    Uri localUri = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, paramInt1);
    AppMethodBeat.o(76267);
    return localUri;
  }
  
  private boolean isSupport(int paramInt)
  {
    AppMethodBeat.i(76273);
    if (this.mSlook.isFeatureEnabled(1))
    {
      AppMethodBeat.o(76273);
      return true;
    }
    AppMethodBeat.o(76273);
    return false;
  }
  
  /* Error */
  private void updateData()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 286
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 77	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mNeedUpdate	Z
    //   12: ifeq +10 -> 22
    //   15: aload_0
    //   16: getfield 75	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mIsShowing	Z
    //   19: ifeq +12 -> 31
    //   22: ldc_w 286
    //   25: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 77	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mNeedUpdate	Z
    //   36: aload_0
    //   37: getfield 66	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mData	Ljava/util/ArrayList;
    //   40: invokevirtual 289	java/util/ArrayList:clear	()V
    //   43: aload_0
    //   44: getfield 107	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mContext	Landroid/content/Context;
    //   47: invokevirtual 232	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   50: astore_1
    //   51: ldc 32
    //   53: invokestatic 295	android/provider/MediaStore$Files:getContentUri	(Ljava/lang/String;)Landroid/net/Uri;
    //   56: astore_2
    //   57: aload_0
    //   58: getfield 99	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mFilter	Ljava/lang/String;
    //   61: astore_3
    //   62: new 191	java/lang/StringBuilder
    //   65: dup
    //   66: ldc_w 297
    //   69: invokespecial 298	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: aload_0
    //   73: getfield 61	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mMaxCount	I
    //   76: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   79: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore 4
    //   84: aload_1
    //   85: aload_2
    //   86: iconst_4
    //   87: anewarray 215	java/lang/String
    //   90: dup
    //   91: iconst_0
    //   92: ldc_w 300
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: ldc_w 302
    //   101: aastore
    //   102: dup
    //   103: iconst_2
    //   104: ldc 26
    //   106: aastore
    //   107: dup
    //   108: iconst_3
    //   109: ldc 20
    //   111: aastore
    //   112: aload_3
    //   113: aconst_null
    //   114: aload 4
    //   116: invokevirtual 308	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   119: astore_1
    //   120: aload_1
    //   121: ifnonnull +27 -> 148
    //   124: aload_1
    //   125: ifnull +9 -> 134
    //   128: aload_1
    //   129: invokeinterface 313 1 0
    //   134: ldc_w 286
    //   137: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: goto -112 -> 28
    //   143: astore_1
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_1
    //   147: athrow
    //   148: aload_1
    //   149: invokeinterface 317 1 0
    //   154: ifeq +85 -> 239
    //   157: new 194	android/os/Bundle
    //   160: dup
    //   161: invokespecial 318	android/os/Bundle:<init>	()V
    //   164: astore_2
    //   165: aload_2
    //   166: ldc 11
    //   168: aload_1
    //   169: iconst_0
    //   170: invokeinterface 319 2 0
    //   175: invokevirtual 323	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   178: aload_2
    //   179: ldc 17
    //   181: aload_1
    //   182: iconst_1
    //   183: invokeinterface 319 2 0
    //   188: invokevirtual 323	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   191: aload_2
    //   192: ldc 20
    //   194: aload_1
    //   195: iconst_3
    //   196: invokeinterface 319 2 0
    //   201: invokevirtual 323	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   204: aload_0
    //   205: getfield 66	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mData	Ljava/util/ArrayList;
    //   208: aload_2
    //   209: invokevirtual 327	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   212: pop
    //   213: goto -65 -> 148
    //   216: astore_3
    //   217: aload_1
    //   218: astore_2
    //   219: aload_3
    //   220: astore_1
    //   221: aload_2
    //   222: ifnull +9 -> 231
    //   225: aload_2
    //   226: invokeinterface 313 1 0
    //   231: ldc_w 286
    //   234: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload_1
    //   238: athrow
    //   239: aload_1
    //   240: ifnull +9 -> 249
    //   243: aload_1
    //   244: invokeinterface 313 1 0
    //   249: aload_0
    //   250: aload_0
    //   251: getfield 66	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mData	Ljava/util/ArrayList;
    //   254: invokevirtual 330	java/util/ArrayList:size	()I
    //   257: putfield 79	com/samsung/android/sdk/look/airbutton/SlookAirButtonRecentMediaAdapter:mCount	I
    //   260: ldc_w 286
    //   263: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: goto -238 -> 28
    //   269: astore_1
    //   270: aconst_null
    //   271: astore_2
    //   272: goto -51 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	SlookAirButtonRecentMediaAdapter
    //   50	79	1	localObject1	Object
    //   143	75	1	localObject2	Object
    //   220	24	1	localObject3	Object
    //   269	1	1	localObject4	Object
    //   56	216	2	localObject5	Object
    //   61	52	3	str1	String
    //   216	4	3	localObject6	Object
    //   82	33	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	22	143	finally
    //   22	28	143	finally
    //   31	43	143	finally
    //   128	134	143	finally
    //   134	140	143	finally
    //   225	231	143	finally
    //   231	239	143	finally
    //   243	249	143	finally
    //   249	266	143	finally
    //   148	213	216	finally
    //   43	120	269	finally
  }
  
  public final int getCount()
  {
    return this.mCount;
  }
  
  public final SlookAirButtonAdapter.AirButtonItem getItem(int paramInt)
  {
    AppMethodBeat.i(76264);
    Object localObject = (Bundle)this.mData.get(paramInt);
    paramInt = ((Bundle)localObject).getInt("id");
    int i = ((Bundle)localObject).getInt("mime_type");
    localObject = new SlookAirButtonAdapter.AirButtonItem(getThumbNail(paramInt, i, ((Bundle)localObject).getString("title"), ((Bundle)localObject).getInt("orientation")), null, getUri(paramInt, i));
    AppMethodBeat.o(76264);
    return localObject;
  }
  
  public final void onDismiss(View paramView)
  {
    AppMethodBeat.i(76271);
    this.mIsShowing = false;
    this.mNeedUpdate = true;
    this.mData.clear();
    super.onDismiss(paramView);
    AppMethodBeat.o(76271);
  }
  
  public final void onHide(View paramView)
  {
    AppMethodBeat.i(76270);
    this.mIsShowing = false;
    this.mNeedUpdate = true;
    this.mData.clear();
    super.onHide(paramView);
    AppMethodBeat.o(76270);
  }
  
  public final void onShow(View paramView)
  {
    AppMethodBeat.i(76269);
    updateData();
    this.mIsShowing = true;
    super.onShow(paramView);
    AppMethodBeat.o(76269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter
 * JD-Core Version:    0.7.0.1
 */