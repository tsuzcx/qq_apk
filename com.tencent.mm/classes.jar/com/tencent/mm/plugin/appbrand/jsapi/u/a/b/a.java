package com.tencent.mm.plugin.appbrand.jsapi.u.a.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.PlaybackParams;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends b
{
  boolean gHF;
  int gHY;
  MediaPlayer gHZ = new j();
  private MediaPlayer.OnPreparedListener gIa = new MediaPlayer.OnPreparedListener()
  {
    public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
    {
      a.this.mCurrentState = 2;
      if (a.this.gIk != null) {
        a.this.gIk.onPrepared(a.this.gHZ);
      }
      int i = a.this.gHY;
      if (i != 0)
      {
        a.this.seekTo(i);
        a.this.gHY = 0;
      }
      if (a.this.gHF) {
        a.this.start();
      }
    }
  };
  private MediaPlayer.OnVideoSizeChangedListener gIb = new a.2(this);
  private MediaPlayer.OnCompletionListener gIc = new a.3(this);
  private MediaPlayer.OnInfoListener gId = new a.4(this);
  private MediaPlayer.OnSeekCompleteListener gIe = new a.5(this);
  private MediaPlayer.OnErrorListener gIf = new a.6(this);
  private MediaPlayer.OnBufferingUpdateListener gIg = new a.7(this);
  
  private boolean alw()
  {
    return this.gHZ != null;
  }
  
  private void alx()
  {
    if (this.gHZ == null) {
      return;
    }
    this.gHZ.setOnInfoListener(null);
    this.gHZ.setOnErrorListener(null);
    this.gHZ.setOnPreparedListener(null);
    this.gHZ.setOnCompletionListener(null);
    this.gHZ.setOnSeekCompleteListener(null);
    this.gHZ.setOnBufferingUpdateListener(null);
    this.gHZ.setOnVideoSizeChangedListener(null);
  }
  
  private void lN(int paramInt)
  {
    if (this.gIf != null) {
      this.gIf.onError(this.gHZ, -1024, paramInt);
    }
  }
  
  private void setVolume(float paramFloat1, float paramFloat2)
  {
    try
    {
      if (alw()) {
        this.gHZ.setVolume(paramFloat1, paramFloat2);
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s setVolume fail", new Object[] { Integer.valueOf(hashCode()), localException });
      lN(-13);
    }
  }
  
  public final boolean ak(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return false;
    }
    try
    {
      if ((alw()) && (Build.VERSION.SDK_INT >= 23))
      {
        PlaybackParams localPlaybackParams = this.gHZ.getPlaybackParams();
        localPlaybackParams.setSpeed(paramFloat);
        this.gHZ.setPlaybackParams(localPlaybackParams);
        return true;
      }
      y.w("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s setSpeed, current system(%d) not support play speed setting", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(Build.VERSION.SDK_INT) });
      return false;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s setSpeed fail", new Object[] { Integer.valueOf(hashCode()), localException });
      lN(-14);
    }
    return false;
  }
  
  public final void dv(boolean paramBoolean)
  {
    this.gHF = paramBoolean;
  }
  
  public final int getCurrentPosition()
  {
    int j = 0;
    int i = j;
    try
    {
      if (alw()) {
        if ((this.mCurrentState != 2) && (this.mCurrentState != 3) && (this.mCurrentState != 4))
        {
          i = j;
          if (this.mCurrentState != 6) {}
        }
        else
        {
          i = this.gHZ.getCurrentPosition();
        }
      }
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s getCurrentPosition fail", new Object[] { Integer.valueOf(hashCode()), localException });
      lN(-15);
    }
    return 0;
  }
  
  public final int getDuration()
  {
    int j = 0;
    int i = j;
    try
    {
      if (alw())
      {
        i = j;
        if (this.mCurrentState != -1)
        {
          i = j;
          if (this.mCurrentState != 1)
          {
            i = j;
            if (this.mCurrentState != 0) {
              i = this.gHZ.getDuration();
            }
          }
        }
      }
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s getDuration fail", new Object[] { Integer.valueOf(hashCode()), localException });
      lN(-16);
    }
    return 0;
  }
  
  public final int getVideoHeight()
  {
    int i = 0;
    try
    {
      if (alw()) {
        i = this.gHZ.getVideoHeight();
      }
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s getVideoHeight fail", new Object[] { Integer.valueOf(hashCode()), localException });
      lN(-18);
    }
    return 0;
  }
  
  public final int getVideoWidth()
  {
    int i = 0;
    try
    {
      if (alw()) {
        i = this.gHZ.getVideoWidth();
      }
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s getVideoWidth fail", new Object[] { Integer.valueOf(hashCode()), localException });
      lN(-17);
    }
    return 0;
  }
  
  public final boolean isPlaying()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (alw())
      {
        bool1 = bool2;
        if (this.mCurrentState != -1) {
          bool1 = this.gHZ.isPlaying();
        }
      }
      return bool1;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s isPlaying fail", new Object[] { Integer.valueOf(hashCode()), localException });
      lN(-9);
    }
    return false;
  }
  
  public final void lM(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    this.gHY = paramInt;
  }
  
  public final void pause()
  {
    try
    {
      if (alw())
      {
        this.gHZ.pause();
        this.mCurrentState = 4;
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s pause fail", new Object[] { Integer.valueOf(hashCode()), localException });
      lN(-2);
    }
  }
  
  public final void prepare()
  {
    try
    {
      if (alw())
      {
        this.gHZ.prepare();
        this.mCurrentState = 2;
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s prepare fail", new Object[] { Integer.valueOf(hashCode()), localException });
      lN(-5);
    }
  }
  
  public final void prepareAsync()
  {
    try
    {
      if (alw()) {
        this.gHZ.prepareAsync();
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s prepareAsync fail", new Object[] { Integer.valueOf(hashCode()), localException });
      lN(-6);
    }
  }
  
  public final void release()
  {
    try
    {
      if (alw())
      {
        alx();
        this.gHZ.release();
        this.mCurrentState = -2;
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s release fail", new Object[] { Integer.valueOf(hashCode()), localException });
      lN(-8);
    }
  }
  
  public final void seekTo(int paramInt)
  {
    try
    {
      if ((alw()) && ((this.mCurrentState == 2) || (this.mCurrentState == 3) || (this.mCurrentState == 4) || (this.mCurrentState == 6))) {
        this.gHZ.seekTo(paramInt);
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s seekTo fail", new Object[] { Integer.valueOf(hashCode()), localException });
      lN(-3);
    }
  }
  
  /* Error */
  public final void setDataSource(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gHZ	Landroid/media/MediaPlayer;
    //   4: ifnonnull +128 -> 132
    //   7: aload_0
    //   8: new 67	com/tencent/mm/compatible/b/j
    //   11: dup
    //   12: invokespecial 68	com/tencent/mm/compatible/b/j:<init>	()V
    //   15: putfield 70	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gHZ	Landroid/media/MediaPlayer;
    //   18: aload_0
    //   19: getfield 70	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gHZ	Landroid/media/MediaPlayer;
    //   22: iconst_1
    //   23: invokevirtual 239	android/media/MediaPlayer:setScreenOnWhilePlaying	(Z)V
    //   26: aload_0
    //   27: getfield 70	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gHZ	Landroid/media/MediaPlayer;
    //   30: iconst_3
    //   31: invokevirtual 242	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   34: aload_0
    //   35: getfield 70	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gHZ	Landroid/media/MediaPlayer;
    //   38: aload_0
    //   39: getfield 50	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gId	Landroid/media/MediaPlayer$OnInfoListener;
    //   42: invokevirtual 80	android/media/MediaPlayer:setOnInfoListener	(Landroid/media/MediaPlayer$OnInfoListener;)V
    //   45: aload_0
    //   46: getfield 70	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gHZ	Landroid/media/MediaPlayer;
    //   49: aload_0
    //   50: getfield 60	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gIf	Landroid/media/MediaPlayer$OnErrorListener;
    //   53: invokevirtual 84	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   56: aload_0
    //   57: getfield 70	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gHZ	Landroid/media/MediaPlayer;
    //   60: aload_0
    //   61: getfield 35	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gIa	Landroid/media/MediaPlayer$OnPreparedListener;
    //   64: invokevirtual 88	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   67: aload_0
    //   68: getfield 70	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gHZ	Landroid/media/MediaPlayer;
    //   71: aload_0
    //   72: getfield 45	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gIc	Landroid/media/MediaPlayer$OnCompletionListener;
    //   75: invokevirtual 92	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   78: aload_0
    //   79: getfield 70	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gHZ	Landroid/media/MediaPlayer;
    //   82: aload_0
    //   83: getfield 55	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gIe	Landroid/media/MediaPlayer$OnSeekCompleteListener;
    //   86: invokevirtual 96	android/media/MediaPlayer:setOnSeekCompleteListener	(Landroid/media/MediaPlayer$OnSeekCompleteListener;)V
    //   89: aload_0
    //   90: getfield 70	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gHZ	Landroid/media/MediaPlayer;
    //   93: aload_0
    //   94: getfield 40	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gIb	Landroid/media/MediaPlayer$OnVideoSizeChangedListener;
    //   97: invokevirtual 104	android/media/MediaPlayer:setOnVideoSizeChangedListener	(Landroid/media/MediaPlayer$OnVideoSizeChangedListener;)V
    //   100: aload_0
    //   101: getfield 70	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gHZ	Landroid/media/MediaPlayer;
    //   104: aload_0
    //   105: getfield 65	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gIg	Landroid/media/MediaPlayer$OnBufferingUpdateListener;
    //   108: invokevirtual 100	android/media/MediaPlayer:setOnBufferingUpdateListener	(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V
    //   111: aload_0
    //   112: invokespecial 118	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:alw	()Z
    //   115: ifeq +115 -> 230
    //   118: aload_0
    //   119: getfield 70	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gHZ	Landroid/media/MediaPlayer;
    //   122: aload_1
    //   123: invokevirtual 244	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   126: aload_0
    //   127: iconst_1
    //   128: putfield 180	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/b:mCurrentState	I
    //   131: return
    //   132: aload_0
    //   133: invokevirtual 247	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:stop	()V
    //   136: aload_0
    //   137: invokespecial 118	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:alw	()Z
    //   140: ifeq +15 -> 155
    //   143: aload_0
    //   144: getfield 70	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:gHZ	Landroid/media/MediaPlayer;
    //   147: invokevirtual 250	android/media/MediaPlayer:reset	()V
    //   150: aload_0
    //   151: iconst_0
    //   152: putfield 180	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/b:mCurrentState	I
    //   155: aload_0
    //   156: invokespecial 225	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:alx	()V
    //   159: goto -141 -> 18
    //   162: astore_1
    //   163: ldc 122
    //   165: ldc 252
    //   167: iconst_2
    //   168: anewarray 126	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload_0
    //   174: invokevirtual 130	java/lang/Object:hashCode	()I
    //   177: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: aastore
    //   181: dup
    //   182: iconst_1
    //   183: aload_1
    //   184: aastore
    //   185: invokestatic 142	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload_0
    //   189: bipush 245
    //   191: invokespecial 144	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:lN	(I)V
    //   194: return
    //   195: astore_2
    //   196: ldc 122
    //   198: ldc 254
    //   200: iconst_2
    //   201: anewarray 126	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: aload_0
    //   207: invokevirtual 130	java/lang/Object:hashCode	()I
    //   210: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   213: aastore
    //   214: dup
    //   215: iconst_1
    //   216: aload_2
    //   217: aastore
    //   218: invokestatic 142	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   221: aload_0
    //   222: bipush 249
    //   224: invokespecial 144	com/tencent/mm/plugin/appbrand/jsapi/u/a/b/a:lN	(I)V
    //   227: goto -72 -> 155
    //   230: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	a
    //   0	231	1	paramString	java.lang.String
    //   195	22	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	18	162	java/lang/Exception
    //   18	131	162	java/lang/Exception
    //   132	136	162	java/lang/Exception
    //   155	159	162	java/lang/Exception
    //   196	227	162	java/lang/Exception
    //   136	155	195	java/lang/Exception
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    try
    {
      if (alw()) {
        this.gHZ.setLooping(paramBoolean);
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s setLooping fail", new Object[] { Integer.valueOf(hashCode()), localException });
      lN(-10);
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    if (alw())
    {
      if (paramBoolean) {
        setVolume(0.0F, 0.0F);
      }
    }
    else {
      return;
    }
    setVolume(1.0F, 1.0F);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    try
    {
      if (alw()) {
        this.gHZ.setSurface(paramSurface);
      }
      return;
    }
    catch (Exception paramSurface)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s setSurface fail", new Object[] { Integer.valueOf(hashCode()), paramSurface });
      lN(-12);
    }
  }
  
  public final void start()
  {
    try
    {
      if ((alw()) && ((this.mCurrentState == 2) || (this.mCurrentState == 4) || (this.mCurrentState == 6)))
      {
        this.gHZ.start();
        this.mCurrentState = 3;
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s start fail", new Object[] { Integer.valueOf(hashCode()), localException });
      lN(-1);
    }
  }
  
  public final void stop()
  {
    try
    {
      if ((alw()) && ((this.mCurrentState == 2) || (this.mCurrentState == 3) || (this.mCurrentState == 4) || (this.mCurrentState == 6)))
      {
        this.gHZ.stop();
        this.mCurrentState = 5;
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s stop fail", new Object[] { Integer.valueOf(hashCode()), localException });
      lN(-4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.b.a
 * JD-Core Version:    0.7.0.1
 */