package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.media.AudioManager;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.luggage.c.a.a.c;
import com.tencent.luggage.c.a.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.3;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.4;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.5;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandVideoView
  extends RelativeLayout
{
  private static AppBrandVideoView.b gDh;
  private int Sv = -1;
  private com.tencent.mm.plugin.appbrand.jsapi.c gDA;
  private boolean gDB;
  j gDC;
  private boolean gDD;
  private k gDE;
  private AppBrandVideoView.a gDF;
  private boolean gDG;
  private boolean gDH;
  private int gDI;
  private String gDJ;
  private boolean gDK;
  private boolean gDL;
  private boolean gDM;
  private boolean gDN;
  private int gDO;
  private String gDP;
  private boolean gDQ;
  private boolean gDR;
  private RelativeLayout gDi;
  c gDj;
  private TextView gDk;
  private DanmuView gDl;
  c.a gDm;
  private View gDn;
  private View gDo;
  private TextView gDp;
  private LinearLayout gDq;
  private AppBrandDotPercentIndicator gDr;
  private TextView gDs;
  private ImageView gDt;
  private ImageView gDu;
  private ImageView gDv;
  private ImageView gDw;
  private FrameLayout gDx;
  private String gDy;
  private int gDz;
  private int grZ;
  private String mAppId;
  private boolean mAutoPlay;
  private int mDuration;
  private boolean mIsMute;
  
  public AppBrandVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public AppBrandVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  public <T extends View,  extends c> AppBrandVideoView(Context paramContext, T paramT)
  {
    super(paramContext);
    this.gDj = ((c)paramT);
    init(paramContext);
    this.gDi.addView(paramT);
  }
  
  public static AppBrandVideoView.b akc()
  {
    return gDh;
  }
  
  private void akd()
  {
    this.gDm.akd();
  }
  
  private void akf()
  {
    this.gDl = ((DanmuView)findViewById(a.c.danmaku_view));
    this.gDl.setDanmuViewCallBack(new AppBrandVideoView.12(this));
    DanmuView localDanmuView = this.gDl;
    localDanmuView.gFv = 0.0F;
    localDanmuView.gFw = 0.8F;
    this.gDl.setMaxRunningPerRow(5);
    this.gDl.setPickItemInterval(200);
    this.gDl.hide();
    if ((this.gDj != null) && (((View)this.gDj).getHeight() > 0))
    {
      float f = this.gDl.getYOffset();
      int i = (int)(((View)this.gDj).getHeight() * f);
      f = com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b.co(getContext());
      this.gDl.setMaxRow((int)(i / f));
    }
  }
  
  private boolean akg()
  {
    return (this.gDL) && (!this.gDj.isLive()) && (!aki());
  }
  
  private boolean akh()
  {
    return ((this.gDD) || (ake())) && (!aki());
  }
  
  private boolean aki()
  {
    return this.gDn.getVisibility() == 0;
  }
  
  private void init(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(a.d.app_brand_video_container, this);
    this.gDi = ((RelativeLayout)findViewById(a.c.video_view));
    this.gDk = ((TextView)findViewById(a.c.progress));
    this.gDn = findViewById(a.c.cover_area);
    this.gDo = findViewById(a.c.cover_play_btn_area);
    this.gDp = ((TextView)findViewById(a.c.cover_total_time));
    this.gDq = ((LinearLayout)findViewById(a.c.adjust_info_layout));
    this.gDr = ((AppBrandDotPercentIndicator)findViewById(a.c.adjust_percent_indicator));
    this.gDs = ((TextView)findViewById(a.c.adjust_content));
    this.gDt = ((ImageView)findViewById(a.c.adjust_icon));
    this.gDu = ((ImageView)findViewById(a.c.cover));
    this.gDv = ((ImageView)findViewById(a.c.player_bottom_progress_bar_front));
    this.gDw = ((ImageView)findViewById(a.c.player_bottom_progress_bar_background));
    this.gDx = ((FrameLayout)findViewById(a.c.player_bottom_progress_root));
    this.gDr.setDotsNum(8);
    ((ImageView)findViewById(a.c.cover_play_btn)).setOnClickListener(new AppBrandVideoView.1(this));
    this.gDE = new k(getContext(), this, new AppBrandVideoView.10(this));
    this.gDj.setIMMVideoViewCallback(new AppBrandVideoView.11(this));
  }
  
  private boolean isLive()
  {
    boolean bool = false;
    y.i("MicroMsg.AppBrandVideoView", "isLive %b %b", new Object[] { Boolean.valueOf(this.gDG), Boolean.valueOf(this.gDj.isLive()) });
    if ((this.gDG) || (this.gDj.isLive())) {
      bool = true;
    }
    return bool;
  }
  
  private static String lB(int paramInt)
  {
    return lC(paramInt / 60) + ":" + lC(paramInt % 60);
  }
  
  private static String lC(int paramInt)
  {
    if (paramInt < 10) {
      return "0" + paramInt;
    }
    return String.valueOf(paramInt);
  }
  
  private void setCover(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    if (!bk.bl(this.gDJ))
    {
      y.i("MicroMsg.AppBrandVideoView", "setCover mCoverUrl not null");
      return;
    }
    n.DS().O(new AppBrandVideoView.8(this, paramString));
  }
  
  public static void setProxy(AppBrandVideoView.b paramb)
  {
    gDh = paramb;
  }
  
  public final void D(int paramInt, boolean paramBoolean)
  {
    int i = this.gDj.getCurrPosSec();
    y.i("MicroMsg.AppBrandVideoView", "seek to position=%d current=%d isLive=%b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(this.gDG) });
    if (isLive()) {}
    for (;;)
    {
      return;
      this.gDn.setVisibility(8);
      if (paramBoolean) {
        this.gDj.y(paramInt, paramBoolean);
      }
      while ((this.gDl != null) && (i > paramInt))
      {
        DanmuView localDanmuView = this.gDl;
        y.i("MicroMsg.DanmuView", "seekToPlayTime playTime=%d", new Object[] { Integer.valueOf(paramInt) });
        localDanmuView.ald();
        localDanmuView.alf();
        localDanmuView.prepare();
        com.tencent.mm.sdk.f.e.post(new DanmuView.5(localDanmuView, paramInt), "DanmuView-seekToPlayTime");
        return;
        this.gDj.lF(paramInt);
      }
    }
  }
  
  public final boolean ake()
  {
    if (this.gDF == null)
    {
      y.w("MicroMsg.AppBrandVideoView", "isInFullScreen mFullScreenDelegate null");
      return false;
    }
    return this.gDF.isFullScreen();
  }
  
  public final boolean bG(String arg1, String paramString2)
  {
    if (this.gDl == null)
    {
      y.w("MicroMsg.AppBrandVideoView", " addDanmaku mDanmakuView null");
      akf();
    }
    int j = h.wE(paramString2);
    int i = j;
    if (j == 0) {
      i = -1;
    }
    paramString2 = new a(getContext(), new SpannableString(???), i, this.gDj.getCurrPosSec());
    DanmuView localDanmuView = this.gDl;
    synchronized (localDanmuView.gFB)
    {
      localDanmuView.gFB.offerFirst(paramString2);
      com.tencent.mm.sdk.f.e.post(new DanmuView.3(localDanmuView, paramString2), "DanmuView-addItemToWaitingHead");
      return true;
    }
  }
  
  public final void clean()
  {
    y.i("MicroMsg.AppBrandVideoView", "clean");
    stop();
    this.gDj.akT();
    if (this.gDl != null)
    {
      DanmuView localDanmuView = this.gDl;
      localDanmuView.status = 3;
      localDanmuView.alf();
      localDanmuView.gFC.clear();
      localDanmuView.invalidate();
    }
    this.gDm.onDestroy();
  }
  
  public final void ds(boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandVideoView", "enableProgressGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gDL = paramBoolean;
  }
  
  final void dt(boolean paramBoolean)
  {
    if (this.gDC == null) {
      return;
    }
    j localj = this.gDC;
    int i = this.gDz;
    int j = this.grZ;
    try
    {
      y.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%d", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean), Integer.valueOf(j) });
      JSONObject localJSONObject = localj.akU();
      localJSONObject.put("fullScreen", paramBoolean);
      localJSONObject.put("videoPlayerId", i);
      localJSONObject.put("direction", j);
      localj.a(new j.e((byte)0), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      y.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { localJSONException });
    }
  }
  
  public final void e(String paramString, boolean paramBoolean, int paramInt)
  {
    String str = paramString;
    if (this.gDA.Zl().bs(paramString))
    {
      paramString = this.gDA.Zl().rx(paramString);
      if (paramString != null) {
        break label87;
      }
    }
    label87:
    for (paramString = null;; paramString = "file://" + paramString.getAbsolutePath())
    {
      str = paramString;
      y.i("MicroMsg.AppBrandVideoView", "setVideoPath path=%s isLive=%s", new Object[] { str, Boolean.valueOf(paramBoolean) });
      if (!bk.bl(str)) {
        break;
      }
      y.v("MicroMsg.AppBrandVideoView", "setVideoPath videoPath empty");
      return;
    }
    stop();
    this.gDG = paramBoolean;
    this.gDP = str;
    this.gDj.setVideoSource(this.gDO);
    this.gDj.c(paramBoolean, str, paramInt);
    if (this.gDI > 0) {
      this.gDj.y(this.gDI, this.mAutoPlay);
    }
    Object localObject;
    if (this.gDO == 1)
    {
      localObject = ((d)com.tencent.luggage.b.e.i(d.class)).uH(this.gDP);
      if (localObject != null)
      {
        y.i("MicroMsg.AppBrandVideoView", "setVideoPath localVideoPath");
        paramString = this.gDP;
        y.i("MicroMsg.AppBrandVideoView", "leonlad setPreLoadVidePath videoPath=%s", new Object[] { localObject });
        if ((!this.gDj.isPlaying()) && (this.gDP.equalsIgnoreCase(paramString)))
        {
          this.gDP = paramString;
          this.gDj.c(this.gDG, (String)localObject, 0);
          if (this.mAutoPlay)
          {
            y.i("MicroMsg.AppBrandVideoView", "setPreLoadVidePath autoPlay");
            start();
          }
        }
        if (this.gDC != null) {
          localObject = this.gDC;
        }
      }
    }
    try
    {
      JSONObject localJSONObject = ((j)localObject).akU();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      localJSONObject.put("url", paramString);
      ((j)localObject).a(new j.a((byte)0), localJSONObject);
      if (this.mAutoPlay)
      {
        y.i("MicroMsg.AppBrandVideoView", "setVideoPath autoPlay");
        start();
      }
      setCover(str);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.JsApiVideoCallback", "onVideoCanPlay e=%s", new Object[] { paramString });
      }
    }
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    y.i("MicroMsg.AppBrandVideoView", "operateFullScreen toFullScreen:%b direction:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.gDF == null)
    {
      y.w("MicroMsg.AppBrandVideoView", "operateFullScreen mFullScreenDelegate null");
      return;
    }
    if (paramBoolean == ake())
    {
      y.i("MicroMsg.AppBrandVideoView", "operateFullScreen current same");
      return;
    }
    if (paramInt == -1) {
      if (this.Sv == -1)
      {
        paramInt = 90;
        y.i("MicroMsg.AppBrandVideoView", "operateFullScreen target direction:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        this.grZ = paramInt;
        this.gDF.lu(paramInt);
        this.gDm.akJ();
        dt(true);
        return;
        paramInt = this.Sv;
        break;
      }
      this.gDF.aiZ();
      this.gDm.aiZ();
      return;
    }
  }
  
  public int getCacheTimeSec()
  {
    if (this.gDj != null) {
      return this.gDj.getCacheTimeSec();
    }
    return 0;
  }
  
  public j getCallback()
  {
    return this.gDC;
  }
  
  public String getCookieData()
  {
    return this.gDy;
  }
  
  public int getCurrPosMs()
  {
    return this.gDj.getCurrPosMs();
  }
  
  public int getCurrPosSec()
  {
    return this.gDj.getCurrPosSec();
  }
  
  public int getDuration()
  {
    if (this.mDuration > 0) {
      return this.mDuration;
    }
    return this.gDj.getVideoDurationSec();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.gDR) || (akg()) || (akh()))
    {
      k localk;
      if (this.gDE != null)
      {
        localk = this.gDE;
        int i = paramMotionEvent.getActionMasked();
        if (i == 0)
        {
          localk.gEW = paramMotionEvent.getRawX();
          localk.Cv = ((AudioManager)localk.mContext.getSystemService("audio")).getStreamVolume(3);
          localk.gCn = l.cn(localk.mContext);
        }
        localk.gEU.onTouchEvent(paramMotionEvent);
        if ((i == 1) || (i == 3))
        {
          if (localk.gET != k.a.gFe) {
            break label157;
          }
          localk.gEV.g(localk.gEY, paramMotionEvent.getRawX() - localk.gEW);
          localk.gEX = -1;
          localk.gEY = 0;
          localk.gEW = 0.0F;
        }
      }
      for (;;)
      {
        localk.gET = k.a.gFb;
        return true;
        label157:
        if (localk.gET == k.a.gFc)
        {
          ((AudioManager)localk.mContext.getSystemService("audio")).getStreamMaxVolume(3);
          localk.gEV.ako();
        }
        else if (localk.gET == k.a.gFd)
        {
          localk.gEV.akp();
        }
      }
    }
    if ((paramMotionEvent.getAction() == 0) && (this.gDB) && (this.gDn.getVisibility() != 0))
    {
      this.gDm.akI();
      if (this.gDQ) {
        akd();
      }
    }
    if (this.gDK) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public final void pause()
  {
    y.i("MicroMsg.AppBrandVideoView", "pause");
    if (!this.gDj.isPlaying()) {}
    do
    {
      return;
      this.gDj.pause();
    } while ((this.gDl == null) || (!this.gDm.akD()));
    this.gDl.pause();
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandVideoView", "setAutoPlay =%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mAutoPlay = paramBoolean;
  }
  
  public void setCallback(j paramj)
  {
    this.gDC = paramj;
  }
  
  public void setComponent(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    this.gDA = paramc;
    this.mAppId = paramc.getAppId();
  }
  
  public void setConsumeTouchEvent(boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandVideoView", "setConsumeTouchEvent game=%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gDK = paramBoolean;
  }
  
  public void setCookieData(String paramString)
  {
    this.gDy = paramString;
  }
  
  public final void setCover$16da05f7(String paramString)
  {
    y.i("MicroMsg.AppBrandVideoView", "setCover coverUrl=%s", new Object[] { paramString });
    if (bk.bl(paramString)) {
      return;
    }
    this.gDJ = paramString;
    com.tencent.mm.modelappbrand.a.b.JD().a(this.gDu, paramString, null, null);
  }
  
  public void setDanmakuEnable(boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandVideoView", "setDanmakuEnable isEnable=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gDm.setDanmakuBtnOpen(paramBoolean);
  }
  
  public void setDanmakuItemList(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    int i;
    ArrayList localArrayList;
    if (paramJSONArray != null)
    {
      i = paramJSONArray.length();
      y.i("MicroMsg.AppBrandVideoView", "setDanmakuItemList length=%d", new Object[] { Integer.valueOf(i) });
      if (this.gDl == null)
      {
        y.w("MicroMsg.AppBrandVideoView", " setDanmakuItemList mDanmakuView null");
        akf();
      }
      localArrayList = new ArrayList();
      i = 0;
      label63:
      if (i >= paramJSONArray.length()) {
        break label191;
      }
      localObject = paramJSONArray.optJSONObject(i);
      if (localObject != null) {
        break label113;
      }
    }
    label113:
    int m;
    String str;
    int j;
    for (Object localObject = null;; localObject = new a(getContext(), new SpannableString(str), j, m))
    {
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      i += 1;
      break label63;
      i = 0;
      break;
      m = ((JSONObject)localObject).optInt("time", 0);
      str = ((JSONObject)localObject).optString("text", "");
      int k = h.wE(((JSONObject)localObject).optString("color", ""));
      j = k;
      if (k == 0) {
        j = -1;
      }
    }
    label191:
    paramJSONArray = this.gDl;
    paramJSONArray.ald();
    paramJSONArray.alf();
    paramJSONArray.gFC.clear();
    paramJSONArray.prepare();
    if (localArrayList.isEmpty())
    {
      paramJSONArray.ale();
      return;
    }
    new DanmuView.4(paramJSONArray, localArrayList).start();
    paramJSONArray.ale();
  }
  
  public void setDuration(int paramInt)
  {
    if (paramInt <= 0)
    {
      y.i("MicroMsg.AppBrandVideoView", "setDuration error duration=%d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    this.gDp.setText(lB(paramInt));
    this.mDuration = paramInt;
  }
  
  public void setEnablePlayGesture(boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandVideoView", "setEnablePlayGesture: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gDR = paramBoolean;
  }
  
  public void setFullScreenDelegate(AppBrandVideoView.a parama)
  {
    this.gDF = parama;
  }
  
  public void setFullScreenDirection(int paramInt)
  {
    y.i("MicroMsg.AppBrandVideoView", "setFullScreenDirection %d", new Object[] { Integer.valueOf(paramInt) });
    this.Sv = paramInt;
  }
  
  public void setInitialTime(int paramInt)
  {
    y.i("MicroMsg.AppBrandVideoView", "setInitialTime initialTime=%d", new Object[] { Integer.valueOf(paramInt) });
    this.gDI = paramInt;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandVideoView", "setIsShowBasicControls isShowBasicControls=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gDB = paramBoolean;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandVideoView", "setLoop loop=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gDH = paramBoolean;
  }
  
  public void setMute(boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandVideoView", "setMute isMute=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    this.gDj.setMute(paramBoolean);
    this.gDm.setMuteBtnState(paramBoolean);
  }
  
  public void setObjectFit(String paramString)
  {
    y.i("MicroMsg.AppBrandVideoView", "setObjectFit objectFit=%s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.gDj.setScaleType(c.g.gEE);
      this.gDu.setScaleType(ImageView.ScaleType.FIT_XY);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.gDj.setScaleType(c.g.gEG);
      this.gDu.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
    this.gDj.setScaleType(c.g.gEF);
    this.gDu.setScaleType(ImageView.ScaleType.FIT_CENTER);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandVideoView", "setPageGesture pageGesture=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gDD = paramBoolean;
  }
  
  public void setPlayBtnPosition(String paramString)
  {
    y.i("MicroMsg.AppBrandVideoView", "setPlayBtnPosition: %s", new Object[] { paramString });
    if ((!bk.bl(paramString)) && (paramString.equalsIgnoreCase("center")))
    {
      this.gDm.setPlayBtnInCenterPosition(true);
      return;
    }
    this.gDm.setPlayBtnInCenterPosition(false);
  }
  
  public void setShowCenterPlayBtn(boolean paramBoolean)
  {
    int i = 0;
    y.i("MicroMsg.AppBrandVideoView", "setPlayBtnInCenterPosition %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gDN = paramBoolean;
    View localView = this.gDo;
    if (paramBoolean) {}
    for (;;)
    {
      localView.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    boolean bool = true;
    y.i("MicroMsg.AppBrandVideoView", "setShowControlProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    c.a locala = this.gDm;
    if ((paramBoolean) && (!isLive())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      locala.setShowControlProgress(paramBoolean);
      return;
    }
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandVideoView", "setShowDanmakuBtn showDanmakuBtn=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (this.gDl == null) {
        akf();
      }
      this.gDm.setDanmakuBtnOnClickListener(new AppBrandVideoView.9(this));
    }
    this.gDm.setShowDanmakuBtn(paramBoolean);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandVideoView", "setShowFullScreenBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gDm.setShowFullScreenBtn(paramBoolean);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandVideoView", "showMuteBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gDm.setShowMuteBtn(paramBoolean);
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandVideoView", "setShowPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gDm.setShowPlayBtn(paramBoolean);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    boolean bool = true;
    y.i("MicroMsg.AppBrandVideoView", "setShowProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gDM = paramBoolean;
    c.a locala = this.gDm;
    if ((paramBoolean) && (!isLive())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      locala.setShowProgress(paramBoolean);
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    y.i("MicroMsg.AppBrandVideoView", "setTitle %s", new Object[] { paramString });
    this.gDm.setTitle(paramString);
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.gDz = paramInt;
  }
  
  public void setVideoSource(int paramInt)
  {
    y.i("MicroMsg.AppBrandVideoView", "setVideoSource =%d", new Object[] { Integer.valueOf(paramInt) });
    this.gDO = paramInt;
  }
  
  public final void start()
  {
    y.i("MicroMsg.AppBrandVideoView", "start");
    if (this.gDj.isPlaying()) {
      return;
    }
    if (this.gDB) {
      this.gDm.akM();
    }
    this.gDn.setVisibility(8);
    this.gDj.start();
    if ((this.gDl != null) && (this.gDm.akD())) {
      this.gDl.show();
    }
    ((d)com.tencent.luggage.b.e.i(d.class)).report(this.gDP);
  }
  
  public final void stop()
  {
    y.i("MicroMsg.AppBrandVideoView", "stop");
    if (!this.gDj.isPlaying()) {}
    do
    {
      return;
      this.gDj.stop();
      this.gDm.akN();
    } while (this.gDl == null);
    this.gDl.hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView
 * JD-Core Version:    0.7.0.1
 */