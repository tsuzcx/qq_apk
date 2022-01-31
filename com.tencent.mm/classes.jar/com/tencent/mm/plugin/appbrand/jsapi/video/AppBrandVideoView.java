package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.3;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.4;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.5;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static AppBrandVideoView.b icj;
  private int Td;
  private boolean bGe;
  private boolean bGf;
  private int hNt;
  private String icA;
  private int icB;
  private c icC;
  private boolean icD;
  k icE;
  private boolean icF;
  private boolean icG;
  private l icH;
  private AppBrandVideoView.a icI;
  private boolean icJ;
  private boolean icK;
  private double icL;
  private String icM;
  private boolean icN;
  private boolean icO;
  private boolean icP;
  private boolean icQ;
  private int icR;
  private String icS;
  private boolean icT;
  private boolean icU;
  private boolean icV;
  private boolean icW;
  private RelativeLayout ick;
  d icl;
  private TextView icm;
  private DanmuView icn;
  d.a ico;
  private View icp;
  private View icq;
  private TextView icr;
  private LinearLayout ics;
  private AppBrandDotPercentIndicator ict;
  private TextView icu;
  private ImageView icv;
  private ImageView icw;
  private ImageView icx;
  private ImageView icy;
  private FrameLayout icz;
  private String mAppId;
  private boolean mAutoPlay;
  private int mDuration;
  private boolean mIsMute;
  
  public AppBrandVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(126478);
    this.Td = -1;
    this.icV = false;
    this.icW = true;
    init(paramContext);
    AppMethodBeat.o(126478);
  }
  
  public AppBrandVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(126479);
    this.Td = -1;
    this.icV = false;
    this.icW = true;
    init(paramContext);
    AppMethodBeat.o(126479);
  }
  
  public <T extends View,  extends d> AppBrandVideoView(Context paramContext, T paramT)
  {
    super(paramContext);
    AppMethodBeat.i(126477);
    this.Td = -1;
    this.icV = false;
    this.icW = true;
    this.icl = ((d)paramT);
    init(paramContext);
    this.ick.addView(paramT);
    AppMethodBeat.o(126477);
  }
  
  public static AppBrandVideoView.b aEL()
  {
    return icj;
  }
  
  private void aEN()
  {
    AppMethodBeat.i(126523);
    this.icH = new l(getContext(), this, new AppBrandVideoView.10(this));
    AppMethodBeat.o(126523);
  }
  
  private void aEO()
  {
    AppMethodBeat.i(126524);
    this.ico.aEO();
    AppMethodBeat.o(126524);
  }
  
  private void aEP()
  {
    AppMethodBeat.i(126525);
    this.icl.setIMMVideoViewCallback(new AppBrandVideoView.11(this));
    AppMethodBeat.o(126525);
  }
  
  private void aER()
  {
    AppMethodBeat.i(126529);
    this.icn = ((DanmuView)findViewById(2131821442));
    this.icn.setDanmuViewCallBack(new AppBrandVideoView.12(this));
    this.icn.aFU();
    this.icn.setMaxRunningPerRow(5);
    this.icn.setPickItemInterval(200);
    this.icn.hide();
    if ((this.icl != null) && (((View)this.icl).getHeight() > 0))
    {
      float f = this.icn.getYOffset();
      int i = (int)(((View)this.icl).getHeight() * f);
      f = com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b.cQ(getContext());
      this.icn.setMaxRow((int)(i / f));
    }
    AppMethodBeat.o(126529);
  }
  
  private boolean aES()
  {
    AppMethodBeat.i(126535);
    if ((this.icO) && (!this.icl.isLive()) && (!aEU()))
    {
      AppMethodBeat.o(126535);
      return true;
    }
    AppMethodBeat.o(126535);
    return false;
  }
  
  private boolean aET()
  {
    AppMethodBeat.i(126536);
    if ((!aEU()) && (((!aEQ()) && (this.icF)) || ((aEQ()) && (this.icG))))
    {
      AppMethodBeat.o(126536);
      return true;
    }
    AppMethodBeat.o(126536);
    return false;
  }
  
  private boolean aEU()
  {
    AppMethodBeat.i(126537);
    if (this.icp.getVisibility() == 0)
    {
      AppMethodBeat.o(126537);
      return true;
    }
    AppMethodBeat.o(126537);
    return false;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(126480);
    LayoutInflater.from(paramContext).inflate(2130968747, this);
    this.ick = ((RelativeLayout)findViewById(2131821436));
    this.icm = ((TextView)findViewById(2131821404));
    this.icp = findViewById(2131821437);
    this.icq = findViewById(2131821439);
    this.icr = ((TextView)findViewById(2131821441));
    this.ics = ((LinearLayout)findViewById(2131821443));
    this.ict = ((AppBrandDotPercentIndicator)findViewById(2131821446));
    this.icu = ((TextView)findViewById(2131821445));
    this.icv = ((ImageView)findViewById(2131821444));
    this.icw = ((ImageView)findViewById(2131821438));
    this.icx = ((ImageView)findViewById(2131821449));
    this.icy = ((ImageView)findViewById(2131821448));
    this.icz = ((FrameLayout)findViewById(2131821447));
    this.ict.setDotsNum(8);
    ((ImageView)findViewById(2131821440)).setOnClickListener(new AppBrandVideoView.1(this));
    aEN();
    aEP();
    AppMethodBeat.o(126480);
  }
  
  private boolean isLive()
  {
    AppMethodBeat.i(126534);
    ab.i("MicroMsg.AppBrandVideoView", "isLive %b %b", new Object[] { Boolean.valueOf(this.icJ), Boolean.valueOf(this.icl.isLive()) });
    if ((this.icJ) || (this.icl.isLive()))
    {
      AppMethodBeat.o(126534);
      return true;
    }
    AppMethodBeat.o(126534);
    return false;
  }
  
  private static String ok(int paramInt)
  {
    AppMethodBeat.i(126531);
    String str = ol(paramInt / 60) + ":" + ol(paramInt % 60);
    AppMethodBeat.o(126531);
    return str;
  }
  
  private static String ol(int paramInt)
  {
    AppMethodBeat.i(126532);
    if (paramInt < 10)
    {
      String str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(126532);
      return str;
    }
    AppMethodBeat.o(126532);
    return String.valueOf(paramInt);
  }
  
  private void setCover(String paramString)
  {
    AppMethodBeat.i(126504);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126504);
      return;
    }
    if (!bo.isNullOrNil(this.icM))
    {
      ab.i("MicroMsg.AppBrandVideoView", "setCover mCoverUrl not null");
      AppMethodBeat.o(126504);
      return;
    }
    m.aNS().ac(new AppBrandVideoView.8(this, paramString));
    AppMethodBeat.o(126504);
  }
  
  public static void setProxy(AppBrandVideoView.b paramb)
  {
    icj = paramb;
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(126530);
    this.ico = parama;
    if (((this.ico instanceof View)) && (this.ico != null))
    {
      View localView = (View)this.ico;
      if (localView.getId() != -1) {
        localView.setId(2131820574);
      }
    }
    this.ico.hide();
    this.ico.setFullScreenBtnOnClickListener(new AppBrandVideoView.13(this));
    this.ico.setIplaySeekCallback(new AppBrandVideoView.14(this));
    this.ico.setOnPlayButtonClickListener(new AppBrandVideoView.2(this));
    this.ico.setStatePorter(new AppBrandVideoView.3(this));
    this.ico.setMuteBtnOnClickListener(new AppBrandVideoView.4(this));
    this.ico.setExitFullScreenBtnOnClickListener(new AppBrandVideoView.5(this));
    this.ico.a(new AppBrandVideoView.6(this));
    this.ico.setOnUpdateProgressLenListener(new AppBrandVideoView.7(this));
    this.icl.setControlBar(parama);
    AppMethodBeat.o(126530);
  }
  
  public final void aEM()
  {
    AppMethodBeat.i(126498);
    ab.i("MicroMsg.AppBrandVideoView", "onUIDestroy");
    clean();
    AppMethodBeat.o(126498);
  }
  
  public final boolean aEQ()
  {
    AppMethodBeat.i(126528);
    if (this.icI == null)
    {
      ab.w("MicroMsg.AppBrandVideoView", "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(126528);
      return false;
    }
    boolean bool = this.icI.isFullScreen();
    AppMethodBeat.o(126528);
    return bool;
  }
  
  public final void alp()
  {
    AppMethodBeat.i(126496);
    ab.i("MicroMsg.AppBrandVideoView", "onUIResume");
    if (this.icV)
    {
      ab.i("MicroMsg.AppBrandVideoView", "onUIResume, should skip ui resume");
      this.icV = false;
      AppMethodBeat.o(126496);
      return;
    }
    this.icl.alp();
    AppMethodBeat.o(126496);
  }
  
  public final void clean()
  {
    AppMethodBeat.i(126499);
    ab.i("MicroMsg.AppBrandVideoView", "clean");
    stop();
    this.icl.aEM();
    if (this.icn != null) {
      this.icn.clear();
    }
    this.ico.onDestroy();
    AppMethodBeat.o(126499);
  }
  
  public final boolean cp(String arg1, String paramString2)
  {
    AppMethodBeat.i(126522);
    if (this.icn == null)
    {
      ab.w("MicroMsg.AppBrandVideoView", " addDanmaku mDanmakuView null");
      aER();
    }
    int j = g.Fm(paramString2);
    int i = j;
    if (j == 0) {
      i = -1;
    }
    paramString2 = new a(getContext(), new SpannableString(???), i, this.icl.getCurrPosSec());
    DanmuView localDanmuView = this.icn;
    synchronized (localDanmuView.ieF)
    {
      localDanmuView.ieF.offerFirst(paramString2);
      com.tencent.mm.sdk.g.d.post(new DanmuView.3(localDanmuView, paramString2), "DanmuView-addItemToWaitingHead");
      AppMethodBeat.o(126522);
      return true;
    }
  }
  
  public final void e(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(126501);
    int i = this.icl.getCurrPosSec();
    ab.i("MicroMsg.AppBrandVideoView", "seek to position=%s current=%d isLive=%b", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(i), Boolean.valueOf(this.icJ) });
    if (isLive())
    {
      AppMethodBeat.o(126501);
      return;
    }
    this.icp.setVisibility(8);
    if (paramBoolean) {
      this.icl.d(paramDouble, paramBoolean);
    }
    for (;;)
    {
      if ((this.icn != null) && (i > paramDouble))
      {
        DanmuView localDanmuView = this.icn;
        i = (int)paramDouble;
        ab.i("MicroMsg.DanmuView", "seekToPlayTime playTime=%d", new Object[] { Integer.valueOf(i) });
        localDanmuView.aFP();
        localDanmuView.aFR();
        localDanmuView.prepare();
        com.tencent.mm.sdk.g.d.post(new DanmuView.5(localDanmuView, i), "DanmuView-seekToPlayTime");
      }
      AppMethodBeat.o(126501);
      return;
      this.icl.r(paramDouble);
    }
  }
  
  public final void ex(boolean paramBoolean)
  {
    AppMethodBeat.i(126508);
    ab.i("MicroMsg.AppBrandVideoView", "enableProgressGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icO = paramBoolean;
    AppMethodBeat.o(126508);
  }
  
  final void ey(boolean paramBoolean)
  {
    AppMethodBeat.i(126533);
    if (this.icE == null)
    {
      AppMethodBeat.o(126533);
      return;
    }
    this.icE.c(this.icB, paramBoolean, this.hNt);
    AppMethodBeat.o(126533);
  }
  
  public final void f(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(126500);
    String str = paramString;
    if (this.icC != null)
    {
      str = paramString;
      if (this.icC.wX() != null)
      {
        str = paramString;
        if (this.icC.wX().bL(paramString))
        {
          paramString = this.icC.wX().zg(paramString);
          if (paramString != null) {
            break label124;
          }
        }
      }
    }
    label124:
    for (paramString = null;; paramString = "file://" + paramString.getAbsolutePath())
    {
      str = paramString;
      ab.i("MicroMsg.AppBrandVideoView", "setVideoPath path=%s isLive=%s", new Object[] { str, Boolean.valueOf(paramBoolean) });
      if (!bo.isNullOrNil(str)) {
        break;
      }
      ab.v("MicroMsg.AppBrandVideoView", "setVideoPath videoPath empty");
      AppMethodBeat.o(126500);
      return;
    }
    stop();
    this.icJ = paramBoolean;
    this.icS = str;
    this.icl.setVideoSource(this.icR);
    this.icl.c(paramBoolean, str, paramInt);
    if (this.icL > 0.0D) {
      this.icl.d(this.icL, this.mAutoPlay);
    }
    Object localObject;
    if (this.icR == 1)
    {
      localObject = ((e)com.tencent.luggage.a.e.q(e.class)).CT(this.icS);
      if (localObject != null)
      {
        ab.i("MicroMsg.AppBrandVideoView", "setVideoPath localVideoPath");
        paramString = this.icS;
        ab.i("MicroMsg.AppBrandVideoView", "leonlad setPreLoadVidePath videoPath=%s", new Object[] { localObject });
        if ((!this.icl.isPlaying()) && (this.icS.equalsIgnoreCase(paramString)))
        {
          this.icS = paramString;
          this.icl.c(this.icJ, (String)localObject, 0);
          if (this.mAutoPlay)
          {
            ab.i("MicroMsg.AppBrandVideoView", "setPreLoadVidePath autoPlay");
            start();
          }
        }
        if (this.icE != null) {
          localObject = this.icE;
        }
      }
    }
    try
    {
      JSONObject localJSONObject = ((k)localObject).aFD();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      localJSONObject.put("url", paramString);
      ((k)localObject).a(new k.a((byte)0), localJSONObject);
      if (this.mAutoPlay)
      {
        ab.i("MicroMsg.AppBrandVideoView", "setVideoPath autoPlay");
        start();
      }
      setCover(str);
      AppMethodBeat.o(126500);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiVideoCallback", "onVideoCanPlay e=%s", new Object[] { paramString });
      }
    }
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(126516);
    if (this.icl != null)
    {
      int i = this.icl.getCacheTimeSec();
      AppMethodBeat.o(126516);
      return i;
    }
    AppMethodBeat.o(126516);
    return 0;
  }
  
  public k getCallback()
  {
    return this.icE;
  }
  
  public String getCookieData()
  {
    return this.icA;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(126515);
    int i = this.icl.getCurrPosMs();
    AppMethodBeat.o(126515);
    return i;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(126514);
    int i = this.icl.getCurrPosSec();
    AppMethodBeat.o(126514);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(126491);
    if (this.mDuration > 0)
    {
      i = this.mDuration;
      AppMethodBeat.o(126491);
      return i;
    }
    int i = this.icl.getVideoDurationSec();
    AppMethodBeat.o(126491);
    return i;
  }
  
  public final void l(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(126527);
    ab.i("MicroMsg.AppBrandVideoView", "operateFullScreen toFullScreen:%b direction:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.icI == null)
    {
      ab.w("MicroMsg.AppBrandVideoView", "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(126527);
      return;
    }
    if (paramBoolean == aEQ())
    {
      ab.i("MicroMsg.AppBrandVideoView", "operateFullScreen current same");
      AppMethodBeat.o(126527);
      return;
    }
    if (paramInt == -1) {
      if (this.Td == -1)
      {
        paramInt = 90;
        ab.i("MicroMsg.AppBrandVideoView", "operateFullScreen target direction:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        this.hNt = paramInt;
        this.icI.oc(paramInt);
        this.ico.aFp();
        ey(true);
        AppMethodBeat.o(126527);
        return;
        paramInt = this.Td;
        break;
      }
      this.icI.aDh();
      this.ico.aDh();
      AppMethodBeat.o(126527);
      return;
    }
  }
  
  public final void oj(int paramInt)
  {
    AppMethodBeat.i(126497);
    ab.i("MicroMsg.AppBrandVideoView", "onUIPause, type:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((paramInt == 2) && (!this.bGf)) || ((paramInt == 1) && (!this.bGe)))
    {
      ab.i("MicroMsg.AppBrandVideoView", "onUIPause, should skip ui pause");
      this.icV = true;
      AppMethodBeat.o(126497);
      return;
    }
    this.icl.alo();
    AppMethodBeat.o(126497);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126526);
    if (this.icU) {
      bool = true;
    }
    while (bool)
    {
      if (this.icH != null) {
        this.icH.z(paramMotionEvent);
      }
      AppMethodBeat.o(126526);
      return true;
      bool = aES();
      if (!aET()) {
        bool = false;
      }
    }
    if ((paramMotionEvent.getAction() == 0) && (this.icD) && (this.icp.getVisibility() != 0))
    {
      this.ico.aFo();
      if (this.icT) {
        aEO();
      }
    }
    if (this.icN)
    {
      AppMethodBeat.o(126526);
      return true;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(126526);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(126494);
    ab.i("MicroMsg.AppBrandVideoView", "pause");
    if (!this.icl.isPlaying())
    {
      AppMethodBeat.o(126494);
      return;
    }
    this.icl.pause();
    if ((this.icn != null) && (this.ico.aFj())) {
      this.icn.pause();
    }
    AppMethodBeat.o(126494);
  }
  
  public void setAutoPauseIfNavigate(boolean paramBoolean)
  {
    this.bGe = paramBoolean;
  }
  
  public void setAutoPauseIfOpenNative(boolean paramBoolean)
  {
    this.bGf = paramBoolean;
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(126488);
    ab.i("MicroMsg.AppBrandVideoView", "setAutoPlay =%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mAutoPlay = paramBoolean;
    AppMethodBeat.o(126488);
  }
  
  public void setCallback(k paramk)
  {
    this.icE = paramk;
  }
  
  public void setComponent(c paramc)
  {
    AppMethodBeat.i(126481);
    this.icC = paramc;
    this.mAppId = paramc.getAppId();
    AppMethodBeat.o(126481);
  }
  
  public void setConsumeTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(126482);
    ab.i("MicroMsg.AppBrandVideoView", "setConsumeTouchEvent game=%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icN = paramBoolean;
    AppMethodBeat.o(126482);
  }
  
  public void setCookieData(String paramString)
  {
    this.icA = paramString;
  }
  
  public final void setCover$16da05f7(String paramString)
  {
    AppMethodBeat.i(126503);
    ab.i("MicroMsg.AppBrandVideoView", "setCover coverUrl=%s", new Object[] { paramString });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126503);
      return;
    }
    this.icM = paramString;
    com.tencent.mm.modelappbrand.a.b.acD().a(this.icw, paramString, null, null);
    AppMethodBeat.o(126503);
  }
  
  public void setDanmakuEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(126510);
    ab.i("MicroMsg.AppBrandVideoView", "setDanmakuEnable isEnable=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.ico.setDanmakuBtnOpen(paramBoolean);
    AppMethodBeat.o(126510);
  }
  
  public void setDanmakuItemList(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(126521);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(126521);
      return;
    }
    int i;
    ArrayList localArrayList;
    if (paramJSONArray != null)
    {
      i = paramJSONArray.length();
      ab.i("MicroMsg.AppBrandVideoView", "setDanmakuItemList length=%d", new Object[] { Integer.valueOf(i) });
      if (this.icn == null)
      {
        ab.w("MicroMsg.AppBrandVideoView", " setDanmakuItemList mDanmakuView null");
        aER();
      }
      localArrayList = new ArrayList();
      i = 0;
      label75:
      if (i >= paramJSONArray.length()) {
        break label203;
      }
      localObject = paramJSONArray.optJSONObject(i);
      if (localObject != null) {
        break label125;
      }
    }
    label125:
    int m;
    String str;
    int j;
    for (Object localObject = null;; localObject = new a(getContext(), new SpannableString(str), j, m))
    {
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      i += 1;
      break label75;
      i = 0;
      break;
      m = ((JSONObject)localObject).optInt("time", 0);
      str = ((JSONObject)localObject).optString("text", "");
      int k = g.Fm(((JSONObject)localObject).optString("color", ""));
      j = k;
      if (k == 0) {
        j = -1;
      }
    }
    label203:
    paramJSONArray = this.icn;
    paramJSONArray.aFP();
    paramJSONArray.aFR();
    paramJSONArray.ieG.clear();
    paramJSONArray.prepare();
    if (localArrayList.isEmpty())
    {
      paramJSONArray.aFQ();
      AppMethodBeat.o(126521);
      return;
    }
    new DanmuView.4(paramJSONArray, localArrayList).start();
    paramJSONArray.aFQ();
    AppMethodBeat.o(126521);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(126490);
    if (paramInt <= 0)
    {
      ab.i("MicroMsg.AppBrandVideoView", "setDuration error duration=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126490);
      return;
    }
    this.icr.setText(ok(paramInt));
    this.mDuration = paramInt;
    AppMethodBeat.o(126490);
  }
  
  public void setEnablePlayGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(126487);
    ab.i("MicroMsg.AppBrandVideoView", "setEnablePlayGesture: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icU = paramBoolean;
    AppMethodBeat.o(126487);
  }
  
  public void setFullScreenDelegate(AppBrandVideoView.a parama)
  {
    this.icI = parama;
  }
  
  public void setFullScreenDirection(int paramInt)
  {
    AppMethodBeat.i(126517);
    ab.i("MicroMsg.AppBrandVideoView", "setFullScreenDirection %d", new Object[] { Integer.valueOf(paramInt) });
    this.Td = paramInt;
    AppMethodBeat.o(126517);
  }
  
  public void setInitialTime(double paramDouble)
  {
    AppMethodBeat.i(126520);
    ab.i("MicroMsg.AppBrandVideoView", "setInitialTime initialTime=%s", new Object[] { Double.valueOf(paramDouble) });
    this.icL = paramDouble;
    AppMethodBeat.o(126520);
  }
  
  public void setIsEnableBottomProgressBar(boolean paramBoolean)
  {
    this.icW = paramBoolean;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(126502);
    ab.i("MicroMsg.AppBrandVideoView", "setIsShowBasicControls isShowBasicControls=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icD = paramBoolean;
    if (this.ico != null)
    {
      if (this.icD)
      {
        this.ico.aFm();
        AppMethodBeat.o(126502);
        return;
      }
      this.ico.hide();
    }
    AppMethodBeat.o(126502);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(126492);
    ab.i("MicroMsg.AppBrandVideoView", "setLoop loop=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icK = paramBoolean;
    AppMethodBeat.o(126492);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(126513);
    ab.i("MicroMsg.AppBrandVideoView", "setMute isMute=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    this.icl.setMute(paramBoolean);
    this.ico.setMuteBtnState(paramBoolean);
    AppMethodBeat.o(126513);
  }
  
  public void setObjectFit(String paramString)
  {
    AppMethodBeat.i(126512);
    ab.i("MicroMsg.AppBrandVideoView", "setObjectFit objectFit=%s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.icl.setScaleType(d.g.idI);
      this.icw.setScaleType(ImageView.ScaleType.FIT_XY);
      AppMethodBeat.o(126512);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.icl.setScaleType(d.g.idK);
      this.icw.setScaleType(ImageView.ScaleType.CENTER_CROP);
      AppMethodBeat.o(126512);
      return;
    }
    this.icl.setScaleType(d.g.idJ);
    this.icw.setScaleType(ImageView.ScaleType.FIT_CENTER);
    AppMethodBeat.o(126512);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(126518);
    ab.i("MicroMsg.AppBrandVideoView", "setPageGesture pageGesture=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icF = paramBoolean;
    AppMethodBeat.o(126518);
  }
  
  public void setPageGestureInFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(126519);
    ab.i("MicroMsg.AppBrandVideoView", "setPageGestureInFullscreen pageGestureInFullscreen=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icG = paramBoolean;
    AppMethodBeat.o(126519);
  }
  
  public void setPlayBtnPosition(String paramString)
  {
    AppMethodBeat.i(126486);
    ab.i("MicroMsg.AppBrandVideoView", "setPlayBtnPosition: %s", new Object[] { paramString });
    if ((!bo.isNullOrNil(paramString)) && (paramString.equalsIgnoreCase("center")))
    {
      this.ico.setPlayBtnInCenterPosition(true);
      AppMethodBeat.o(126486);
      return;
    }
    this.ico.setPlayBtnInCenterPosition(false);
    AppMethodBeat.o(126486);
  }
  
  public void setShowCenterPlayBtn(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(126509);
    ab.i("MicroMsg.AppBrandVideoView", "setPlayBtnInCenterPosition %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icQ = paramBoolean;
    View localView = this.icp;
    if (paramBoolean)
    {
      i = 0;
      localView.setVisibility(i);
      localView = this.icq;
      if (!paramBoolean) {
        break label104;
      }
    }
    label104:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      if ((this.icQ) && (this.ico != null)) {
        this.ico.hide();
      }
      AppMethodBeat.o(126509);
      return;
      i = 8;
      break;
    }
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(126485);
    ab.i("MicroMsg.AppBrandVideoView", "setShowControlProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    d.a locala = this.ico;
    if ((paramBoolean) && (!isLive())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      locala.setShowControlProgress(paramBoolean);
      AppMethodBeat.o(126485);
      return;
    }
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(126511);
    ab.i("MicroMsg.AppBrandVideoView", "setShowDanmakuBtn showDanmakuBtn=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (this.icn == null) {
        aER();
      }
      this.ico.setDanmakuBtnOnClickListener(new AppBrandVideoView.9(this));
    }
    this.ico.setShowDanmakuBtn(paramBoolean);
    AppMethodBeat.o(126511);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(126506);
    ab.i("MicroMsg.AppBrandVideoView", "setShowFullScreenBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.ico.setShowFullScreenBtn(paramBoolean);
    AppMethodBeat.o(126506);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(126483);
    ab.i("MicroMsg.AppBrandVideoView", "showMuteBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.ico.setShowMuteBtn(paramBoolean);
    AppMethodBeat.o(126483);
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(126507);
    ab.i("MicroMsg.AppBrandVideoView", "setShowPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.ico.setShowPlayBtn(paramBoolean);
    AppMethodBeat.o(126507);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(126505);
    ab.i("MicroMsg.AppBrandVideoView", "setShowProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icP = paramBoolean;
    d.a locala = this.ico;
    if ((paramBoolean) && (!isLive())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      locala.setShowProgress(paramBoolean);
      AppMethodBeat.o(126505);
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(126484);
    ab.i("MicroMsg.AppBrandVideoView", "setTitle %s", new Object[] { paramString });
    this.ico.setTitle(paramString);
    AppMethodBeat.o(126484);
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.icB = paramInt;
  }
  
  public void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(126489);
    ab.i("MicroMsg.AppBrandVideoView", "setVideoSource =%d", new Object[] { Integer.valueOf(paramInt) });
    this.icR = paramInt;
    AppMethodBeat.o(126489);
  }
  
  public final void start()
  {
    AppMethodBeat.i(126493);
    ab.i("MicroMsg.AppBrandVideoView", "start");
    if (this.icl.isPlaying())
    {
      AppMethodBeat.o(126493);
      return;
    }
    if (this.icD) {
      this.ico.aFv();
    }
    this.icp.setVisibility(8);
    this.icl.start();
    if ((this.icn != null) && (this.ico.aFj())) {
      this.icn.show();
    }
    ((e)com.tencent.luggage.a.e.q(e.class)).report(this.icS);
    AppMethodBeat.o(126493);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(126495);
    ab.i("MicroMsg.AppBrandVideoView", "stop");
    if (!this.icl.isPlaying())
    {
      AppMethodBeat.o(126495);
      return;
    }
    this.icl.stop();
    this.ico.aFw();
    if (this.icn != null) {
      this.icn.hide();
    }
    AppMethodBeat.o(126495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView
 * JD-Core Version:    0.7.0.1
 */