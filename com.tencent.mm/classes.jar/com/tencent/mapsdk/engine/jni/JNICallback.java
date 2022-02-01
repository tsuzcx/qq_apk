package com.tencent.mapsdk.engine.jni;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Typeface;
import com.tencent.map.lib.JNIInterfaceCallback;
import com.tencent.map.lib.models.DataSource;
import com.tencent.map.lib.models.DownloadPriority;
import com.tencent.map.lib.models.MapTileID;
import com.tencent.mapsdk.engine.jni.models.IconImageInfo;
import com.tencent.mapsdk.engine.jni.models.TextBitmapInfo;
import com.tencent.mapsdk.internal.bp;
import com.tencent.mapsdk.internal.gz;
import com.tencent.mapsdk.internal.kh;
import com.tencent.mapsdk.internal.kl;
import com.tencent.mapsdk.internal.lb;
import com.tencent.mapsdk.internal.mg;
import com.tencent.mapsdk.internal.nr;
import com.tencent.mapsdk.internal.nv;
import com.tencent.mapsdk.internal.nw;
import com.tencent.mapsdk.internal.oa;
import com.tencent.mapsdk.internal.ob;
import com.tencent.mapsdk.internal.oc;
import com.tencent.mapsdk.internal.od;
import com.tencent.mapsdk.internal.oe;
import com.tencent.mapsdk.internal.of;
import com.tencent.mapsdk.internal.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Hashtable;

public class JNICallback
  implements JNIInterfaceCallback
{
  private static final int CB_TYPE_CAL_TEXT_SIZE = 2;
  private static final int CB_TYPE_CANCEL_DOWNLOAD = 10;
  private static final int CB_TYPE_DOWNLOAD = 3;
  private static final int CB_TYPE_DRAW_TEXT = 1;
  private static final int CB_TYPE_INDOOR_BUILDING_CHANGED = 8;
  private static final int CB_TYPE_LOAD_RES = 4;
  private static final int CB_TYPE_NOTIFY_SET_CENTER_AND_SCALE_ANIM_FINISHED = 9;
  private static final int CB_TYPE_REPORT_ENGINE_CRASH_INFO = 7;
  private static final int CB_TYPE_UPDATE_MAP_PARAM = 6;
  private static final int CB_TYPE_WRITE_FILE = 5;
  private static final int IMG_TYPE_SAT = 1;
  private nv mCancelDownloadCallback;
  private ob mCbkGetGLContext;
  private nw mDownloadCallback;
  private bp mEngineCrashInfoRecorder;
  private oa mIndoorBuildingChangeCallback;
  private od mMapAnimCallback;
  private oc mMapCameraChangeCallback;
  private oe mMapLoadFinishedCallback;
  private of mMapParamChangeCallback;
  private nr mRender;
  private w mResources;
  private Hashtable<Long, Paint> mTextPaints;
  private Hashtable<Long, PointF> mTextSizeBuffers;
  private Bitmap textCanvas;
  
  public JNICallback(nr paramnr, w paramw, nw paramnw, nv paramnv, oe paramoe, oa paramoa, od paramod, bp parambp, of paramof, oc paramoc)
  {
    AppMethodBeat.i(221096);
    this.mTextPaints = new Hashtable();
    this.mTextSizeBuffers = new Hashtable();
    this.mRender = paramnr;
    this.mResources = paramw;
    this.mDownloadCallback = paramnw;
    this.mCancelDownloadCallback = paramnv;
    this.mMapLoadFinishedCallback = paramoe;
    this.mMapParamChangeCallback = paramof;
    this.mIndoorBuildingChangeCallback = paramoa;
    this.mMapCameraChangeCallback = paramoc;
    this.mMapAnimCallback = paramod;
    this.mEngineCrashInfoRecorder = parambp;
    AppMethodBeat.o(221096);
  }
  
  private void cacheTextPaint(Paint paramPaint)
  {
    AppMethodBeat.i(221108);
    if (this.mTextPaints != null) {
      this.mTextPaints.put(Long.valueOf(Thread.currentThread().getId()), paramPaint);
    }
    AppMethodBeat.o(221108);
  }
  
  private void cacheTextSize(PointF paramPointF)
  {
    AppMethodBeat.i(221120);
    if (this.mTextSizeBuffers != null) {
      this.mTextSizeBuffers.put(Long.valueOf(Thread.currentThread().getId()), paramPointF);
    }
    AppMethodBeat.o(221120);
  }
  
  private PointF calTextSize(String paramString, int paramInt)
  {
    AppMethodBeat.i(221145);
    float f = initTextPaint(paramInt).measureText(paramString);
    PointF localPointF = getTextSize();
    paramString = localPointF;
    if (localPointF == null)
    {
      paramString = new PointF();
      cacheTextSize(paramString);
    }
    paramString.x = (1.0F + f);
    paramString.y = (paramInt + 2);
    AppMethodBeat.o(221145);
    return paramString;
  }
  
  private void cancelDownload(String paramString, lb paramlb)
  {
    AppMethodBeat.i(221169);
    if (this.mCancelDownloadCallback != null)
    {
      kh.a("Engine callback cancel download:".concat(String.valueOf(paramString)));
      this.mCancelDownloadCallback.a(paramString, paramlb);
    }
    AppMethodBeat.o(221169);
  }
  
  private void download(String paramString, lb paramlb)
  {
    AppMethodBeat.i(221160);
    if (this.mDownloadCallback != null)
    {
      kh.a("Engine callback download:" + paramString + ":" + paramlb);
      this.mDownloadCallback.b(paramString, paramlb);
    }
    AppMethodBeat.o(221160);
  }
  
  private Bitmap drawText(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(221137);
    TextBitmapInfo localTextBitmapInfo = new TextBitmapInfo();
    localTextBitmapInfo.fill(paramArrayOfByte);
    if ((localTextBitmapInfo.width == 0) || (localTextBitmapInfo.height == 0))
    {
      AppMethodBeat.o(221137);
      return null;
    }
    if (this.textCanvas == null) {
      this.textCanvas = Bitmap.createBitmap(400, 400, Bitmap.Config.ALPHA_8);
    }
    if (this.textCanvas == null)
    {
      AppMethodBeat.o(221137);
      return null;
    }
    paramArrayOfByte = initTextPaint(paramInt);
    this.textCanvas.eraseColor(0);
    Canvas localCanvas = new Canvas(this.textCanvas);
    float f = (paramArrayOfByte.descent() + paramArrayOfByte.ascent()) / 2.0F;
    paramArrayOfByte.setFakeBoldText(localTextBitmapInfo.bold);
    localCanvas.drawText(paramString, 200.0F, 200.0F - f, paramArrayOfByte);
    paramString = this.textCanvas;
    AppMethodBeat.o(221137);
    return paramString;
  }
  
  private Paint getTextPaint()
  {
    AppMethodBeat.i(221103);
    if (this.mTextPaints == null)
    {
      AppMethodBeat.o(221103);
      return null;
    }
    Paint localPaint = (Paint)this.mTextPaints.get(Long.valueOf(Thread.currentThread().getId()));
    AppMethodBeat.o(221103);
    return localPaint;
  }
  
  private PointF getTextSize()
  {
    AppMethodBeat.i(221114);
    if (this.mTextSizeBuffers == null)
    {
      AppMethodBeat.o(221114);
      return null;
    }
    PointF localPointF = (PointF)this.mTextSizeBuffers.get(Long.valueOf(Thread.currentThread().getId()));
    AppMethodBeat.o(221114);
    return localPointF;
  }
  
  private Paint initTextPaint(int paramInt)
  {
    AppMethodBeat.i(221128);
    Paint localPaint = getTextPaint();
    Object localObject = localPaint;
    if (localPaint == null)
    {
      localObject = new mg(this.mResources.a);
      ((Paint)localObject).setTypeface(Typeface.DEFAULT);
      ((Paint)localObject).setAntiAlias(true);
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      ((Paint)localObject).setTextAlign(Paint.Align.CENTER);
      ((Paint)localObject).setLinearText(true);
      cacheTextPaint((Paint)localObject);
    }
    ((Paint)localObject).setTextAlign(Paint.Align.CENTER);
    ((Paint)localObject).setTextSize(paramInt);
    AppMethodBeat.o(221128);
    return localObject;
  }
  
  private IconImageInfo loadImage(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(221152);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(221152);
      return null;
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte);
      if (paramInt == 1)
      {
        w localw = this.mResources;
        IconImageInfo localIconImageInfo = new IconImageInfo();
        localIconImageInfo.scale = localw.c;
        localIconImageInfo.anchorPointX1 = 0.5F;
        localIconImageInfo.anchorPointY1 = 0.5F;
        localIconImageInfo.bitmap = localw.a(paramArrayOfByte, Bitmap.Config.RGB_565);
        AppMethodBeat.o(221152);
        return localIconImageInfo;
      }
      paramArrayOfByte = this.mResources.a(paramArrayOfByte);
      AppMethodBeat.o(221152);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(221152);
    }
    return null;
  }
  
  private void writeFile(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(221178);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(221178);
      return;
    }
    new JNICallback.a(paramString, paramArrayOfByte).execute(new Void[0]);
    AppMethodBeat.o(221178);
  }
  
  public Object callback(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte, Object paramObject)
  {
    AppMethodBeat.i(221200);
    JNIEvent localJNIEvent = new JNIEvent();
    localJNIEvent.id = paramInt2;
    localJNIEvent.name = paramString;
    localJNIEvent.data = paramArrayOfByte;
    localJNIEvent.extra = paramObject;
    paramString = callback(paramInt1, localJNIEvent);
    AppMethodBeat.o(221200);
    return paramString;
  }
  
  public Object callback(int paramInt, JNIEvent paramJNIEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(221211);
    switch (paramInt)
    {
    }
    for (;;)
    {
      Object localObject1 = null;
      Object localObject2;
      for (;;)
      {
        AppMethodBeat.o(221211);
        return localObject1;
        localObject1 = drawText(paramJNIEvent.id, paramJNIEvent.name, paramJNIEvent.data);
        continue;
        localObject1 = calTextSize(paramJNIEvent.name, paramJNIEvent.id);
        continue;
        if (gz.a(paramJNIEvent.name)) {
          break;
        }
        localObject1 = new lb();
        ((lb)localObject1).a = paramJNIEvent.id;
        if ((paramJNIEvent.extra instanceof MapTileID))
        {
          localObject2 = (MapTileID)paramJNIEvent.extra;
          ((lb)localObject1).b = ((MapTileID)localObject2).getDataSource().getValue();
          ((lb)localObject1).c = ((MapTileID)localObject2).getPriority().getValue();
        }
        ((lb)localObject1).d = paramJNIEvent.extra;
        download(paramJNIEvent.name, (lb)localObject1);
        localObject1 = null;
        continue;
        localObject2 = loadImage(paramJNIEvent.id, paramJNIEvent.data);
        localObject1 = localObject2;
        if (paramJNIEvent.data != null)
        {
          new String(paramJNIEvent.data);
          localObject1 = localObject2;
          continue;
          kh.b("TDZ", "CB_TYPE_WRITE_FILE:" + paramJNIEvent.name);
          writeFile(paramJNIEvent.name, paramJNIEvent.data);
          localObject1 = null;
          continue;
          if (this.mMapParamChangeCallback == null) {
            break;
          }
          this.mMapParamChangeCallback.g();
          localObject1 = null;
          continue;
          if (this.mEngineCrashInfoRecorder == null) {
            break;
          }
          this.mEngineCrashInfoRecorder.a(paramJNIEvent.name);
          localObject1 = null;
          continue;
          if (this.mIndoorBuildingChangeCallback == null) {
            break;
          }
          this.mIndoorBuildingChangeCallback.c();
          localObject1 = null;
        }
      }
      if (this.mMapAnimCallback != null)
      {
        localObject1 = this.mMapAnimCallback;
        if (paramJNIEvent.id > 0) {}
        for (;;)
        {
          ((od)localObject1).a(bool);
          localObject1 = null;
          break;
          bool = false;
        }
        kl.a(new Object[] { "CB_TYPE_CANCEL_DOWNLOAD", paramJNIEvent });
        if (!gz.a(paramJNIEvent.name))
        {
          localObject1 = new lb();
          ((lb)localObject1).a = paramJNIEvent.id;
          if ((paramJNIEvent.extra instanceof MapTileID))
          {
            localObject2 = (MapTileID)paramJNIEvent.extra;
            ((lb)localObject1).b = ((MapTileID)localObject2).getDataSource().getValue();
            ((lb)localObject1).c = ((MapTileID)localObject2).getPriority().getValue();
          }
          ((lb)localObject1).d = paramJNIEvent.extra;
          cancelDownload(paramJNIEvent.name, (lb)localObject1);
        }
      }
    }
  }
  
  public int callbackGetGLContext()
  {
    AppMethodBeat.i(221238);
    if (this.mCbkGetGLContext != null)
    {
      int i = this.mCbkGetGLContext.getEGLContextHash();
      AppMethodBeat.o(221238);
      return i;
    }
    AppMethodBeat.o(221238);
    return 0;
  }
  
  public void destory()
  {
    AppMethodBeat.i(221187);
    if (this.mTextPaints != null)
    {
      this.mTextPaints.clear();
      this.mTextPaints = null;
    }
    if (this.mTextSizeBuffers != null)
    {
      this.mTextSizeBuffers.clear();
      this.mTextSizeBuffers = null;
    }
    this.mResources = null;
    this.mDownloadCallback = null;
    this.mCancelDownloadCallback = null;
    this.mMapParamChangeCallback = null;
    this.mIndoorBuildingChangeCallback = null;
    this.mMapCameraChangeCallback = null;
    this.mRender = null;
    AppMethodBeat.o(221187);
  }
  
  public boolean onJniCallbackRenderMapFrame(int paramInt)
  {
    AppMethodBeat.i(221248);
    boolean bool = false;
    if (this.mRender != null) {
      bool = this.mRender.b(paramInt);
    }
    AppMethodBeat.o(221248);
    return bool;
  }
  
  public void onMapCameraChangeStopped()
  {
    AppMethodBeat.i(221231);
    if (this.mMapCameraChangeCallback != null) {
      this.mMapCameraChangeCallback.i();
    }
    AppMethodBeat.o(221231);
  }
  
  public void onMapCameraChanged()
  {
    AppMethodBeat.i(221224);
    if (this.mMapCameraChangeCallback != null) {
      this.mMapCameraChangeCallback.h();
    }
    AppMethodBeat.o(221224);
  }
  
  public void onMapLoaded()
  {
    AppMethodBeat.i(221218);
    if (this.mMapLoadFinishedCallback != null) {
      this.mMapLoadFinishedCallback.m_();
    }
    AppMethodBeat.o(221218);
  }
  
  public void setMapCallbackGetGLContext(ob paramob)
  {
    this.mCbkGetGLContext = paramob;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.engine.jni.JNICallback
 * JD-Core Version:    0.7.0.1
 */