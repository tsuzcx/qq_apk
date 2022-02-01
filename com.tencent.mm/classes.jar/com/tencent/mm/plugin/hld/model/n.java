package com.tencent.mm.plugin.hld.model;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.WxHldService;
import com.tencent.mm.plugin.hld.f.f;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.protocal.protobuf.dbq;
import com.tencent.mm.protocal.protobuf.dbu;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.wxhld.WxhldApi;
import com.tencent.wxhld.WxhldApi.WxhldEventListener;
import com.tencent.wxhld.WxhldApi.WxhldLoginStatusListener;
import com.tencent.wxhld.info.Candidate;
import com.tencent.wxhld.info.DictInfo;
import com.tencent.wxhld.info.InitInfo;
import com.tencent.wxhld.info.NetworkInfo;
import com.tencent.wxhld.info.PendingInput;
import com.tencent.wxhld.info.PunctToScreenEvent;
import com.tencent.wxhld.info.SessionConfig;
import com.tencent.wxhld.info.Syllable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/WxEngineMgr;", "Lcom/tencent/wxhld/WxhldApi$WxhldEventListener;", "Lcom/tencent/wxhld/WxhldApi$WxhldLoginStatusListener;", "()V", "TAG", "", "TAG_CANDIDATE", "lastImeKeyParam", "Lcom/tencent/mm/plugin/hld/api/ImeKeyParam;", "mCandidateIterator", "", "mCandidateList", "Ljava/util/ArrayList;", "Lcom/tencent/wxhld/info/Candidate;", "Lkotlin/collections/ArrayList;", "mCandidateType", "", "mContext", "Landroid/content/Context;", "mCurrentKeyboardType", "mHasMoreCandidate", "", "mICandidateDataListeners", "Lcom/tencent/mm/plugin/hld/candidate/ICandidateDataListener;", "mIPendingInputDataListeners", "Lcom/tencent/mm/plugin/hld/candidate/IPendingInputDataListener;", "mISyllableListDataListeners", "Lcom/tencent/mm/plugin/hld/alternative/ISyllableListDataListener;", "mInitializeNetworkSuccess", "mInitializeSuccess", "mInitializeWait", "mPendingInputContent", "", "mPendingInputCurSorIndex", "mSession", "mSyllables", "Lcom/tencent/wxhld/info/Syllable;", "needReInitDict", "needReInitEngine", "OnCandidateListUpdate", "", "session_id", "new_iterator", "type", "OnCandidateSelected", "OnEmitInputToScreen", "text", "OnLoginComplete", "errCode", "OnLogouted", "OnPendingInputUpdate", "pending_input", "OnPendingInputUpdateV2", "pendingInputs", "", "Lcom/tencent/wxhld/info/PendingInput;", "(J[Lcom/tencent/wxhld/info/PendingInput;)V", "OnSessionExpired", "OnSyllableListUpdate", "syllables", "(J[Lcom/tencent/wxhld/info/Syllable;)V", "addICandidateDataListener", "listener", "addIPendingInputDataListener", "addISyllableListDataListener", "candidateGetOnce", "iterator", "clearUserDictPath", "createSession", "destroySession", "doThirdAppSimpleAuth", "dropLastChar", "fetchMoreCandidateList", "finalize1", "getCommonSymbols", "()[Ljava/lang/String;", "getCurrentKeyboardType", "getEngineCommitTime", "getEngineVersion", "getFirstCandidate", "getOriEngineVersion", "getPendingInput", "getPendingInputCursorIndex", "getSecondClassSymbols", "getThirdClassSymbols", "initializeEngine", "context", "initializeEngineImp", "dictInfos", "Lcom/tencent/wxhld/info/DictInfo;", "([Lcom/tencent/wxhld/info/DictInfo;)V", "initializeEngineNetWorkImp", "authCode", "", "sessionType", "initializeEngineNullNetWorkImp", "isCandidateNull", "isInitializeSuccess", "isLoginStatusOk", "isNeedReInitDict", "isNoSession", "isPendingInputNull", "loadContactData", "contacts", "([Ljava/lang/String;)Z", "loadUserDict", "path", "onSelectCandidate", "id", "suffix", "fromCandidateArea", "pressTime", "forceResetInput", "onSelectPinyin", "syllable", "onWindowHidden", "removeICandidateDataListener", "removeIPendingInputDataListener", "removeISyllableListDataListener", "reportNoTransEngineStr", "reset", "resetCursorIndex", "resetInput", "resetNeedReInitDict", "resetNeedReInitEngine", "setCursorIndex", "cursorIndex", "setNeedReInitDict", "reInit", "setNeedReInitEngine", "setSingleWord", "single", "setTextAroundCursor", "transToEngine", "processType", "Lcom/tencent/mm/plugin/hld/model/ImeProcessInputType;", "keyParam", "triggerAssociate", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  implements WxhldApi.WxhldEventListener, WxhldApi.WxhldLoginStatusListener
{
  private static final ArrayList<Syllable> Jno;
  private static boolean Jox;
  private static com.tencent.mm.plugin.hld.a.g JqO;
  public static final n JvW;
  public static long JvX;
  private static final ArrayList<com.tencent.mm.plugin.hld.candidate.a> JvY;
  private static ArrayList<com.tencent.mm.plugin.hld.candidate.b> JvZ;
  private static ArrayList<com.tencent.mm.plugin.hld.alternative.a> Jwa;
  private static CharSequence Jwb;
  private static int Jwc;
  private static final ArrayList<Candidate> Jwd;
  private static long Jwe;
  private static boolean Jwf;
  private static int Jwg;
  private static volatile boolean Jwh;
  private static boolean Jwi;
  private static boolean Jwj;
  public static boolean Jwk;
  private static int Jwl;
  private static Context mContext;
  
  static
  {
    AppMethodBeat.i(312374);
    JvW = new n();
    JvY = new ArrayList();
    JvZ = new ArrayList();
    Jwa = new ArrayList();
    Jwb = (CharSequence)"";
    Jwd = new ArrayList();
    Jwg = 1;
    Jno = new ArrayList();
    AppMethodBeat.o(312374);
  }
  
  private static final void O(long paramLong, String paramString)
  {
    AppMethodBeat.i(312345);
    Object localObject = k.JvH;
    k.aL(paramLong, System.currentTimeMillis() - paramLong);
    localObject = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).fKG();
      if (localObject != null) {
        ((com.tencent.mm.plugin.hld.a.b)localObject).c((CharSequence)paramString, true);
      }
    }
    AppMethodBeat.o(312345);
  }
  
  private static final void X(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(312268);
    s.u(paramArrayOfByte, "$authCode");
    Log.i("WxIme.WxEngineMgr", "initializeEngineNetWorkImp authCode:" + paramArrayOfByte.length + " sessionType:" + paramInt);
    NetworkInfo localNetworkInfo = new NetworkInfo(paramArrayOfByte.length);
    localNetworkInfo.authCode = paramArrayOfByte;
    localNetworkInfo.sessionType = paramInt;
    localNetworkInfo.lkid = com.tencent.mm.plugin.normsg.a.d.MtP.gtL();
    localNetworkInfo.useDefaultDebugIp = false;
    WxhldApi.network_login(localNetworkInfo);
    AppMethodBeat.o(312268);
  }
  
  private static final void a(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(312304);
    s.u(paramString, "$text");
    Object localObject = k.JvH;
    k.aL(paramLong1, System.currentTimeMillis() - paramLong2);
    localObject = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).fKG();
      if (localObject != null) {
        ((com.tencent.mm.plugin.hld.a.b)localObject).c((CharSequence)paramString, true);
      }
    }
    AppMethodBeat.o(312304);
  }
  
  private static final void a(long paramLong1, long paramLong2, String paramString1, boolean paramBoolean, String paramString2, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(312295);
    s.u(paramString1, "$text");
    s.u(paramCharSequence, "$lastPendingInput");
    Object localObject = k.JvH;
    k.aK(paramLong1, System.currentTimeMillis() - paramLong2);
    localObject = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
    StringBuilder localStringBuilder;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).fKG();
      if (localObject != null)
      {
        localStringBuilder = new StringBuilder().append(paramString1);
        if (!paramBoolean) {
          break label145;
        }
      }
    }
    label145:
    for (paramString1 = " ";; paramString1 = "")
    {
      localStringBuilder = localStringBuilder.append(paramString1);
      paramString1 = paramString2;
      if (Util.isNullOrNil(paramString2)) {
        paramString1 = "";
      }
      ((com.tencent.mm.plugin.hld.a.b)localObject).a((CharSequence)paramString1, paramCharSequence);
      AppMethodBeat.o(312295);
      return;
    }
  }
  
  private static final void a(long paramLong1, long paramLong2, ArrayList paramArrayList, int paramInt)
  {
    AppMethodBeat.i(312313);
    s.u(paramArrayList, "$candidates");
    Log.d("WxIme.WxEngineMgr", s.X("OnCandidateListUpdate size:", Integer.valueOf(JvY.size())));
    k localk = k.JvH;
    k.n(paramLong1, System.currentTimeMillis() - paramLong1 - paramLong2, paramLong2);
    Jwd.clear();
    Jwd.addAll((Collection)paramArrayList);
    Jwg = paramInt;
    paramArrayList = JvY.iterator();
    while (paramArrayList.hasNext()) {
      ((com.tencent.mm.plugin.hld.candidate.a)paramArrayList.next()).a(Jwd, Jwg, true, Jwf);
    }
    AppMethodBeat.o(312313);
  }
  
  public static void a(com.tencent.mm.plugin.hld.alternative.a parama)
  {
    AppMethodBeat.i(312118);
    s.u(parama, "listener");
    if (!Jwa.contains(parama))
    {
      Jwa.add(parama);
      parama.aQ(Jno);
    }
    AppMethodBeat.o(312118);
  }
  
  public static void a(com.tencent.mm.plugin.hld.candidate.a parama)
  {
    AppMethodBeat.i(312092);
    s.u(parama, "listener");
    if (!JvY.contains(parama))
    {
      JvY.add(parama);
      parama.a(Jwd, Jwg, true, Jwf);
    }
    AppMethodBeat.o(312092);
  }
  
  public static void a(com.tencent.mm.plugin.hld.candidate.b paramb)
  {
    AppMethodBeat.i(312108);
    s.u(paramb, "listener");
    if (!JvZ.contains(paramb)) {
      JvZ.add(paramb);
    }
    AppMethodBeat.o(312108);
  }
  
  public static void a(h paramh, com.tencent.mm.plugin.hld.a.g paramg)
  {
    Object localObject = null;
    String str = null;
    AppMethodBeat.i(312076);
    s.u(paramh, "processType");
    Log.i("WxIme.WxEngineMgr", s.X("transToEngine ", paramh.value));
    if (paramg == null) {}
    for (paramh = str;; paramh = ah.aiuX)
    {
      if (paramh == null) {
        Log.e("WxIme.WxEngineMgr", "transToEngine keyParam is null");
      }
      AppMethodBeat.o(312076);
      return;
      str = paramg.text;
      if (str != null) {
        break;
      }
      paramh = (h)localObject;
      if (paramh == null) {
        Log.e("WxIme.WxEngineMgr", "transToEngine text is null");
      }
    }
    if (fNa())
    {
      if (paramh == h.Jvz)
      {
        paramh = l.JyV;
        paramh = mContext;
        s.checkNotNull(paramh);
        l.iw(paramh);
      }
      AppMethodBeat.o(312076);
      return;
    }
    if (JqO == null)
    {
      int i = fMP().length();
      if (str.length() + i > 60)
      {
        Log.w("WxIme.WxEngineMgr", "transToEngine exceed limit num");
        AppMethodBeat.o(312076);
        return;
      }
    }
    switch (a.$EnumSwitchMapping$0[paramh.ordinal()])
    {
    }
    for (;;)
    {
      long l = JvX;
      localObject = l.JyV;
      WxhldApi.process_input(l, l.b(paramh, paramg));
      paramh = ah.aiuX;
      break;
      JqO = paramg;
      continue;
      JqO = null;
      continue;
      JqO = null;
      localObject = g.JuL;
      if (g.fMj())
      {
        localObject = l.JyV;
        if ((l.fOH()) && (!fMH())) {
          JvW.fMR();
        }
      }
      localObject = k.JvH;
      k.an(paramg.JnG, paramg.keyType);
    }
  }
  
  private static final void a(DictInfo[] paramArrayOfDictInfo, n paramn)
  {
    AppMethodBeat.i(312260);
    s.u(paramn, "this$0");
    long l2 = System.currentTimeMillis();
    Object localObject = com.tencent.mm.plugin.hld.f.i.JyA;
    boolean bool = com.tencent.mm.plugin.hld.f.i.fOo();
    Log.i("WxIme.WxEngineMgr", "wxIme start initialize(isSafetyMode:" + bool + ')');
    if (paramArrayOfDictInfo != null)
    {
      com.tencent.mm.plugin.hld.model.a.a.JwD.startMonitor();
      WxhldApi.getInstance().init(mContext);
      localObject = com.tencent.mm.plugin.hld.f.e.Jym;
      WxhldApi.set_debug_console_log(com.tencent.mm.plugin.hld.f.e.fNY());
      long l3 = System.currentTimeMillis();
      localObject = l.JyV;
      localObject = s.X(l.fOC(), "/net");
      if (!y.ZC((String)localObject)) {
        y.bDX((String)localObject);
      }
      WxhldApi.init_network((String)localObject);
      long l4 = System.currentTimeMillis();
      long l1 = 0L;
      localObject = f.Jyn;
      Log.i("WxIme.WxEngineMgr", s.X("initializeEngineImp ", f.fOi()));
      long l5 = System.currentTimeMillis();
      localObject = f.Jyn;
      WxhldApi.config_dict(paramArrayOfDictInfo, f.fOi());
      long l6 = System.currentTimeMillis();
      paramArrayOfDictInfo = f.Jyn;
      paramArrayOfDictInfo = f.fOf();
      if (paramArrayOfDictInfo != null)
      {
        l1 = System.currentTimeMillis();
        int j = paramArrayOfDictInfo.length;
        i = 0;
        if (i < j)
        {
          localObject = paramArrayOfDictInfo[i];
          if (localObject != null)
          {
            if (!y.ZC(((DictInfo)localObject).path)) {
              break label245;
            }
            WxhldApi.add_cell_dict(((DictInfo)localObject).path, ((DictInfo)localObject).id);
          }
          for (;;)
          {
            i += 1;
            break;
            label245:
            Log.i("WxIme.WxEngineMgr", "add_cell_dict " + ((DictInfo)localObject).path + ' ' + ((DictInfo)localObject).id + " no exist");
          }
        }
        l1 = System.currentTimeMillis() - l1;
      }
      WxhldApi.getInstance().SetWxhldLoginStatusListener((WxhldApi.WxhldLoginStatusListener)paramn);
      paramArrayOfDictInfo = new InitInfo();
      localObject = l.JyV;
      localObject = s.X(l.fOC(), "/engine");
      if (!y.ZC((String)localObject)) {
        y.bDX((String)localObject);
      }
      paramArrayOfDictInfo.workDir = ((String)localObject);
      paramArrayOfDictInfo.safeMode = bool;
      long l7 = System.currentTimeMillis();
      WxhldApi.initialize(paramArrayOfDictInfo);
      long l8 = System.currentTimeMillis();
      WxhldApi.getInstance().SetWxhldEventListener((WxhldApi.WxhldEventListener)paramn);
      Jox = true;
      Jwk = false;
      paramArrayOfDictInfo = com.tencent.mm.plugin.hld.c.a.JoL;
      com.tencent.mm.plugin.hld.c.a.fKX();
      paramArrayOfDictInfo = l.JyV;
      if (l.bGa())
      {
        paramArrayOfDictInfo = com.tencent.mm.plugin.hld.f.c.Jyj;
        com.tencent.threadpool.h.ahAA.bk(new n..ExternalSyntheticLambda8(new byte[0], 0));
      }
      com.tencent.mm.plugin.hld.model.a.a.JwD.fNl();
      Log.i("WxIme.WxEngineMgr", "wxIme initialize successfully!，" + (System.currentTimeMillis() - l2) + ' ');
      fMI();
      fMG();
      paramArrayOfDictInfo = k.JvH;
      k.c(l8 - l7, l6 - l5, l1, l4 - l3);
      paramArrayOfDictInfo = g.JuL;
      paramn = g.Jvd;
      if ((paramn != null) && (paramn.getVisibility() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          paramArrayOfDictInfo.fLY();
        }
        AppMethodBeat.o(312260);
        return;
      }
    }
    Jwh = true;
    paramArrayOfDictInfo = l.JyV;
    l.fOR();
    g.JuL.fLY();
    Log.e("WxIme.WxEngineMgr", "cloud dict is null，" + (System.currentTimeMillis() - l2) + ' ');
    AppMethodBeat.o(312260);
  }
  
  private static final void a(PendingInput[] paramArrayOfPendingInput, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(312352);
    s.u(paramCharSequence, "$lastPendingInputContent");
    Iterator localIterator = JvZ.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.hld.candidate.b)localIterator.next()).a(paramArrayOfPendingInput, paramCharSequence, Jwc);
    }
    if (fMH()) {
      fMT();
    }
    AppMethodBeat.o(312352);
  }
  
  private static final void a(Syllable[] paramArrayOfSyllable)
  {
    AppMethodBeat.i(312356);
    Jno.clear();
    if (paramArrayOfSyllable != null) {
      p.a((Collection)Jno, paramArrayOfSyllable);
    }
    paramArrayOfSyllable = Jwa.iterator();
    while (paramArrayOfSyllable.hasNext()) {
      ((com.tencent.mm.plugin.hld.alternative.a)paramArrayOfSyllable.next()).aQ(Jno);
    }
    AppMethodBeat.o(312356);
  }
  
  public static void aIq(String paramString)
  {
    AppMethodBeat.i(312154);
    s.u(paramString, "text");
    Log.d("WxIme.WxEngineMgr", "reportNoTransEngineStr");
    g localg = g.JuL;
    if (g.b(com.tencent.mm.plugin.hld.keyboard.c.Jrv))
    {
      paramString = g.JuL;
      g.fMk();
      AppMethodBeat.o(312154);
      return;
    }
    com.tencent.threadpool.h.ahAA.bm(new n..ExternalSyntheticLambda6(paramString));
    AppMethodBeat.o(312154);
  }
  
  private static final void aIr(String paramString)
  {
    AppMethodBeat.i(312367);
    s.u(paramString, "$text");
    PunctToScreenEvent localPunctToScreenEvent = new PunctToScreenEvent();
    localPunctToScreenEvent.input = paramString;
    localPunctToScreenEvent.currentSessionId = JvX;
    paramString = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
    if (paramString != null)
    {
      paramString = paramString.fKG();
      if (paramString != null)
      {
        com.tencent.mm.plugin.hld.a.e locale = paramString.Yk(50);
        if (locale != null)
        {
          StringBuilder localStringBuilder = new StringBuilder("reportNoTransEngineStr before:");
          paramString = locale.JnB;
          if (paramString != null) {
            break label191;
          }
          paramString = "";
          localStringBuilder = localStringBuilder.append(Util.secPrint(paramString)).append(" after:");
          paramString = locale.JnD;
          if (paramString != null) {
            break label209;
          }
          paramString = "";
          label126:
          Log.d("WxIme.WxEngineMgr", Util.secPrint(paramString));
          paramString = locale.JnB;
          if (paramString != null) {
            break label227;
          }
          paramString = "";
          label157:
          localPunctToScreenEvent.textBeforeCursor = paramString;
          paramString = locale.JnD;
          if (paramString != null) {
            break label245;
          }
          paramString = "";
        }
      }
    }
    for (;;)
    {
      localPunctToScreenEvent.textAfterCursor = paramString;
      WxhldApi.report_punct_input_to_screen(localPunctToScreenEvent);
      AppMethodBeat.o(312367);
      return;
      label191:
      String str = paramString.toString();
      paramString = str;
      if (str != null) {
        break;
      }
      paramString = "";
      break;
      label209:
      str = paramString.toString();
      paramString = str;
      if (str != null) {
        break label126;
      }
      paramString = "";
      break label126;
      label227:
      str = paramString.toString();
      paramString = str;
      if (str != null) {
        break label157;
      }
      paramString = "";
      break label157;
      label245:
      str = paramString.toString();
      paramString = str;
      if (str == null) {
        paramString = "";
      }
    }
  }
  
  private static final void aR(ArrayList paramArrayList)
  {
    AppMethodBeat.i(312329);
    s.u(paramArrayList, "$candidates");
    Log.d("WxIme.WxEngineMgr", s.X("OnCandidateListUpdate size:", Integer.valueOf(JvY.size())));
    Jwd.addAll((Collection)paramArrayList);
    paramArrayList = JvY.iterator();
    while (paramArrayList.hasNext()) {
      ((com.tencent.mm.plugin.hld.candidate.a)paramArrayList.next()).a(Jwd, Jwg, false, Jwf);
    }
    AppMethodBeat.o(312329);
  }
  
  public static void b(com.tencent.mm.plugin.hld.alternative.a parama)
  {
    AppMethodBeat.i(312122);
    s.u(parama, "listener");
    Jwa.remove(parama);
    AppMethodBeat.o(312122);
  }
  
  public static void b(com.tencent.mm.plugin.hld.candidate.a parama)
  {
    AppMethodBeat.i(312100);
    s.u(parama, "listener");
    JvY.remove(parama);
    AppMethodBeat.o(312100);
  }
  
  public static void b(com.tencent.mm.plugin.hld.candidate.b paramb)
  {
    AppMethodBeat.i(312113);
    s.u(paramb, "listener");
    JvZ.remove(paramb);
    AppMethodBeat.o(312113);
  }
  
  public static void b(Syllable paramSyllable, long paramLong)
  {
    AppMethodBeat.i(312063);
    Log.d("WxIme.WxEngineMgr", s.X("onSelectPinyin ", paramSyllable));
    if (paramSyllable == null)
    {
      WxhldApi.session_set_syllable_hint(JvX, null, 0, "");
      AppMethodBeat.o(312063);
      return;
    }
    k localk = k.JvH;
    k.an(paramLong, 4);
    WxhldApi.session_set_syllable_hint(JvX, paramSyllable.id, paramSyllable.id_len, paramSyllable.syllable);
    AppMethodBeat.o(312063);
  }
  
  public static boolean fMF()
  {
    return Jox;
  }
  
  private static void fMG()
  {
    AppMethodBeat.i(311971);
    com.tencent.threadpool.h.ahAA.bk(n..ExternalSyntheticLambda14.INSTANCE);
    AppMethodBeat.o(311971);
  }
  
  public static boolean fMH()
  {
    AppMethodBeat.i(311977);
    if (fNa())
    {
      AppMethodBeat.o(311977);
      return true;
    }
    boolean bool = Util.isNullOrNil(Jwb);
    AppMethodBeat.o(311977);
    return bool;
  }
  
  public static void fMI()
  {
    Object localObject1 = null;
    boolean bool = true;
    AppMethodBeat.i(311998);
    SessionConfig localSessionConfig = new SessionConfig();
    Object localObject2 = g.JuL;
    int j = g.fMi();
    localSessionConfig.enable_auto_most_likely = true;
    localObject2 = com.tencent.mm.plugin.hld.f.e.Jym;
    localSessionConfig.enable_pre_input = com.tencent.mm.plugin.hld.f.e.fNZ();
    localObject2 = com.tencent.mm.plugin.hld.f.i.JyA;
    localSessionConfig.safe_mode = com.tencent.mm.plugin.hld.f.i.fOo();
    if (j == com.tencent.mm.plugin.hld.keyboard.c.Jrp.ordinal())
    {
      i = 1;
      localSessionConfig.key_board_type = i;
      Jwl = localSessionConfig.key_board_type;
      localObject2 = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
      if (localObject2 == null) {
        break label549;
      }
      localObject2 = ((com.tencent.mm.plugin.hld.a.d)localObject2).fKG();
      if ((localObject2 == null) || (((com.tencent.mm.plugin.hld.a.b)localObject2).fKy() != true)) {
        break label549;
      }
    }
    label549:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localSessionConfig.use_wechat_internal_emoji = true;
      }
      localSessionConfig.enable_shift_key_correction = false;
      localObject2 = com.tencent.mm.plugin.hld.f.e.Jym;
      if (!com.tencent.mm.plugin.hld.f.e.fNQ())
      {
        localObject2 = com.tencent.mm.plugin.hld.f.e.Jym;
        localSessionConfig.enable_exchange = com.tencent.mm.plugin.hld.f.e.fNR();
        localObject2 = com.tencent.mm.plugin.hld.f.e.Jym;
        localSessionConfig.enable_insert_at_middle = com.tencent.mm.plugin.hld.f.e.fNS();
        localObject2 = com.tencent.mm.plugin.hld.f.e.Jym;
        localSessionConfig.enable_skip = com.tencent.mm.plugin.hld.f.e.fNT();
      }
      localObject2 = com.tencent.mm.plugin.hld.f.e.Jym;
      if (!com.tencent.mm.plugin.hld.f.e.fNU())
      {
        localSessionConfig.enable_nl = false;
        localSessionConfig.enable_rl = false;
        localSessionConfig.enable_hf = false;
        localSessionConfig.enable_gk = false;
        localSessionConfig.enable_ang = false;
        localSessionConfig.enable_iang = false;
        localSessionConfig.enable_uang = false;
        localSessionConfig.enable_retroflex = false;
        localSessionConfig.enable_hui_fei = false;
        localSessionConfig.enable_eng = false;
        localSessionConfig.enable_ing = false;
        localSessionConfig.enable_ong = false;
        localSessionConfig.enable_huang_wang = false;
        localSessionConfig.enable_un_ong = false;
        localSessionConfig.enable_un_iong = false;
        localSessionConfig.enable_an_ai = false;
        localSessionConfig.enable_eng_ong = false;
      }
      localObject2 = g.JuL;
      if (g.b(com.tencent.mm.plugin.hld.keyboard.c.Jrp)) {
        localSessionConfig.enable_keyboard_neighbour = false;
      }
      Log.i("WxIme.WxEngineMgr", "createSession " + Jox + ' ' + j);
      if (Jox)
      {
        if (!fNa()) {
          fMJ();
        }
        if (Jwj)
        {
          localObject2 = mContext;
          if (localObject2 != null) {
            break label554;
          }
          localObject1 = null;
          bool = false;
          if (localObject1 == null) {
            Log.e("WxIme.WxEngineMgr", "createSession mContext is null");
          }
          Jwj = false;
          localObject1 = com.tencent.mm.plugin.hld.c.a.JoL;
          com.tencent.mm.plugin.hld.c.a.fKX();
          Log.i("WxIme.WxEngineMgr", s.X("use new cloud dicts, reInit:", Boolean.valueOf(bool)));
        }
        long l = System.currentTimeMillis();
        JvX = WxhldApi.create_session(localSessionConfig);
        localObject1 = k.JvH;
        k.ao(System.currentTimeMillis() - l, localSessionConfig.key_board_type);
        fMO();
        fMT();
        localObject1 = com.tencent.mm.plugin.hld.f.c.Jyj;
        if (!Jwi) {
          fMG();
        }
      }
      AppMethodBeat.o(311998);
      return;
      if (j == com.tencent.mm.plugin.hld.keyboard.c.Jrq.ordinal())
      {
        i = 0;
        break;
      }
      if (j == com.tencent.mm.plugin.hld.keyboard.c.Jrr.ordinal())
      {
        i = 2;
        break;
      }
      Log.e("WxIme.WxEngineMgr", s.X("createSession why here? ", Integer.valueOf(j)));
      i = 0;
      break;
    }
    label554:
    f localf = f.Jyn;
    localObject2 = f.io((Context)localObject2);
    if (localObject2 == null) {
      bool = false;
    }
    for (;;)
    {
      if (localObject1 == null) {
        Log.e("WxIme.WxEngineMgr", "createSession BaseDictInfos is null");
      }
      localObject1 = ah.aiuX;
      break;
      com.tencent.mm.plugin.hld.model.a.a.JwD.startMonitor();
      localObject1 = f.Jyn;
      WxhldApi.config_dict((DictInfo[])localObject2, f.fOi());
      localObject1 = f.Jyn;
      localObject1 = f.fOf();
      if (localObject1 != null)
      {
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localObject2 = localObject1[i];
          if (localObject2 != null) {
            WxhldApi.add_cell_dict(((DictInfo)localObject2).path, ((DictInfo)localObject2).id);
          }
          i += 1;
        }
      }
      com.tencent.mm.plugin.hld.model.a.a.JwD.fNl();
      localObject1 = ah.aiuX;
    }
  }
  
  public static void fMJ()
  {
    AppMethodBeat.i(312007);
    Log.i("WxIme.WxEngineMgr", "destroySession");
    if (fNa())
    {
      AppMethodBeat.o(312007);
      return;
    }
    WxhldApi.destroy_session(JvX);
    JvX = 0L;
    Jwb = (CharSequence)"";
    Jwc = 0;
    Jwd.clear();
    Jno.clear();
    AppMethodBeat.o(312007);
  }
  
  public static void fMK()
  {
    AppMethodBeat.i(312011);
    Log.i("WxIme.WxEngineMgr", "setNeedReInitDict reInit:true mInitializeWait:" + Jwh);
    Jwj = true;
    if (Jwh)
    {
      localObject = mContext;
      if (localObject != null) {
        break label71;
      }
    }
    for (Object localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null) {
        Log.e("WxIme.WxEngineMgr", "setNeedReInitDict mContext is null??");
      }
      AppMethodBeat.o(312011);
      return;
      label71:
      im((Context)localObject);
    }
  }
  
  public static void fML()
  {
    AppMethodBeat.i(312022);
    Log.i("WxIme.WxEngineMgr", "setNeedReInitEngine reInit:true mInitializeWait:" + Jwh + " mInitializeSuccess:" + Jox);
    Jwk = true;
    Object localObject;
    if (Jwh)
    {
      localObject = mContext;
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = ah.aiuX)
      {
        Log.e("WxIme.WxEngineMgr", "setNeedReInitEngine mContext is null??");
        AppMethodBeat.o(312022);
        return;
        im((Context)localObject);
      }
      AppMethodBeat.o(312022);
      return;
    }
    if (Jox)
    {
      localObject = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
      if (localObject == null) {
        break label157;
      }
      localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).fKG();
      if ((localObject == null) || (((com.tencent.mm.plugin.hld.a.b)localObject).fKu())) {
        break label157;
      }
    }
    label157:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        finalize1();
      }
      AppMethodBeat.o(312022);
      return;
    }
  }
  
  public static void fMM()
  {
    AppMethodBeat.i(312033);
    Log.i("WxIme.WxEngineMgr", "resetCursorIndex " + JvX + ' ' + fMP().length());
    if (fNa())
    {
      AppMethodBeat.o(312033);
      return;
    }
    WxhldApi.session_set_internal_cursor(JvX, 0);
    AppMethodBeat.o(312033);
  }
  
  public static void fMN()
  {
    AppMethodBeat.i(312041);
    Log.d("WxIme.WxEngineMgr", "dropLastChar");
    WxhldApi.drop_last(JvX);
    AppMethodBeat.o(312041);
  }
  
  public static void fMO()
  {
    AppMethodBeat.i(312047);
    if (fNa())
    {
      AppMethodBeat.o(312047);
      return;
    }
    com.tencent.threadpool.h.ahAA.bm(n..ExternalSyntheticLambda13.INSTANCE);
    AppMethodBeat.o(312047);
  }
  
  public static CharSequence fMP()
  {
    AppMethodBeat.i(312085);
    if (fNa())
    {
      localCharSequence = (CharSequence)"";
      AppMethodBeat.o(312085);
      return localCharSequence;
    }
    CharSequence localCharSequence = Jwb;
    AppMethodBeat.o(312085);
    return localCharSequence;
  }
  
  public static void fMQ()
  {
    AppMethodBeat.i(312129);
    com.tencent.threadpool.h.ahAA.g(n..ExternalSyntheticLambda12.INSTANCE, "TAG_CANDIDATE");
    AppMethodBeat.o(312129);
  }
  
  public static Candidate fMS()
  {
    AppMethodBeat.i(312178);
    if (Jwd.isEmpty())
    {
      localCandidate = new Candidate(0);
      localCandidate.text = "";
      AppMethodBeat.o(312178);
      return localCandidate;
    }
    Candidate localCandidate = (Candidate)p.oK((List)Jwd);
    AppMethodBeat.o(312178);
    return localCandidate;
  }
  
  public static void fMT()
  {
    AppMethodBeat.i(312184);
    Log.d("WxIme.WxEngineMgr", s.X("triggerAssociate ", Util.getStack()));
    if (fNa())
    {
      AppMethodBeat.o(312184);
      return;
    }
    AppMethodBeat.o(312184);
  }
  
  public static String[] fMU()
  {
    AppMethodBeat.i(312189);
    String[] arrayOfString = WxhldApi.get_puncts_classification(2);
    s.s(arrayOfString, "get_puncts_classificatio….WxhldPunctType.CLASS_II)");
    AppMethodBeat.o(312189);
    return arrayOfString;
  }
  
  public static String[] fMV()
  {
    AppMethodBeat.i(312196);
    String[] arrayOfString = WxhldApi.get_puncts_classification(3);
    s.s(arrayOfString, "get_puncts_classificatio…WxhldPunctType.CLASS_III)");
    AppMethodBeat.o(312196);
    return arrayOfString;
  }
  
  public static String fMW()
  {
    AppMethodBeat.i(312202);
    String str = WxhldApi.get_version();
    s.s(str, "oriVersion");
    Object localObject = kotlin.n.n.a((CharSequence)str, new String[] { "." });
    if (((List)localObject).size() >= 3) {}
    for (localObject = (String)((List)localObject).get(0) + '.' + (String)((List)localObject).get(1) + '.' + (String)((List)localObject).get(2);; localObject = str)
    {
      Log.i("WxIme.WxEngineMgr", "getEngineVersion oriVersion:" + str + " version:" + localObject);
      s.s(localObject, "version");
      AppMethodBeat.o(312202);
      return localObject;
    }
  }
  
  public static String fMX()
  {
    AppMethodBeat.i(312207);
    String str = WxhldApi.get_version();
    s.s(str, "get_version()");
    AppMethodBeat.o(312207);
    return str;
  }
  
  public static String fMY()
  {
    AppMethodBeat.i(312215);
    long l = WxhldApi.get_commit_time();
    AppMethodBeat.o(312215);
    return String.valueOf(l);
  }
  
  public static int fMZ()
  {
    return Jwl;
  }
  
  public static boolean fNa()
  {
    return JvX == 0L;
  }
  
  private static final void fNb()
  {
    AppMethodBeat.i(312278);
    Log.i("WxIme.WxEngineMgr", "initializeEngineNullNetWorkImp");
    WxhldApi.network_login(new NetworkInfo(0));
    AppMethodBeat.o(312278);
  }
  
  private static final void fNc()
  {
    AppMethodBeat.i(312285);
    Object localObject1 = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
    Object localObject3;
    label102:
    long l;
    label138:
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.hld.a.d)localObject1).fKG();
      if (localObject1 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.hld.a.b)localObject1).Yk(50);
        if (localObject3 != null)
        {
          StringBuilder localStringBuilder = new StringBuilder("setTextAroundCursor ");
          localObject1 = ((com.tencent.mm.plugin.hld.a.e)localObject3).JnB;
          if (localObject1 != null) {
            break label165;
          }
          localObject1 = "";
          localStringBuilder = localStringBuilder.append(Util.secPrint((String)localObject1)).append(' ');
          localObject1 = ((com.tencent.mm.plugin.hld.a.e)localObject3).JnD;
          if (localObject1 != null) {
            break label183;
          }
          localObject1 = "";
          Log.d("WxIme.WxEngineMgr", Util.secPrint((String)localObject1));
          l = JvX;
          localObject1 = ((com.tencent.mm.plugin.hld.a.e)localObject3).JnB;
          if (localObject1 != null) {
            break label201;
          }
          localObject1 = "";
          localObject2 = ((com.tencent.mm.plugin.hld.a.e)localObject3).JnD;
          if (localObject2 != null) {
            break label219;
          }
          localObject2 = "";
        }
      }
    }
    for (;;)
    {
      WxhldApi.set_text_around_cursor(l, (String)localObject1, (String)localObject2);
      AppMethodBeat.o(312285);
      return;
      label165:
      localObject2 = localObject1.toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label183:
      localObject2 = localObject1.toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label102;
      }
      localObject1 = "";
      break label102;
      label201:
      localObject2 = localObject1.toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label138;
      }
      localObject1 = "";
      break label138;
      label219:
      localObject3 = localObject2.toString();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
    }
  }
  
  private static final void fNd()
  {
    AppMethodBeat.i(312336);
    Log.i("WxIme.WxEngineMgr", "fetchMoreCandidateList");
    ArrayList localArrayList;
    if (Jwe != 0L)
    {
      localArrayList = rV(Jwe);
      if (localArrayList.size() < 100) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      Jwf = bool;
      if (!bool)
      {
        WxhldApi.delete_candidate_iterator(Jwe);
        Jwe = 0L;
      }
      com.tencent.threadpool.h.ahAA.bk(new n..ExternalSyntheticLambda7(localArrayList));
      AppMethodBeat.o(312336);
      return;
    }
  }
  
  public static void finalize1()
  {
    AppMethodBeat.i(312170);
    Log.i("WxIme.WxEngineMgr", s.X("finalize1 ", Boolean.valueOf(Jox)));
    if (!Jox)
    {
      AppMethodBeat.o(312170);
      return;
    }
    if (!fNa()) {
      WxhldApi.destroy_session(JvX);
    }
    JvX = 0L;
    Jwb = (CharSequence)"";
    Jwc = 0;
    Jwd.clear();
    Jwe = 0L;
    Jwf = false;
    Jno.clear();
    Object localObject = JvY.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.plugin.hld.candidate.a)((Iterator)localObject).next()).a(Jwd, Jwg, true, Jwf);
    }
    localObject = JvZ.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.plugin.hld.candidate.b)((Iterator)localObject).next()).a((PendingInput[])new PendingInput[0], null, 0);
    }
    localObject = Jwa.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.plugin.hld.alternative.a)((Iterator)localObject).next()).aQ(new ArrayList());
    }
    WxhldApi.finalize1();
    localObject = mContext;
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null) {
        Log.e("WxIme.WxEngineMgr", "finalize1 mContext is null");
      }
      AppMethodBeat.o(312170);
      return;
      im((Context)localObject);
    }
  }
  
  public static void im(Context paramContext)
  {
    AppMethodBeat.i(311961);
    s.u(paramContext, "context");
    Log.i("WxIme.WxEngineMgr", "initializeEngine");
    mContext = paramContext;
    com.tencent.threadpool.h.ahAA.bm(new n..ExternalSyntheticLambda5(paramContext));
    AppMethodBeat.o(311961);
  }
  
  private static final void in(Context paramContext)
  {
    int j = 0;
    AppMethodBeat.i(312245);
    s.u(paramContext, "$context");
    Log.i("WxIme.WxEngineMgr", "wxIme get WximeInitInfo");
    Object localObject1 = l.JyV;
    int i;
    boolean bool;
    label162:
    dbu localdbu;
    Object localObject2;
    if (!l.fKH())
    {
      localObject1 = com.tencent.mm.plugin.hld.f.e.Jym;
      if (com.tencent.mm.plugin.hld.f.e.fOc())
      {
        localObject1 = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
        if ((localObject1 != null) && (((com.tencent.mm.plugin.hld.a.d)localObject1).fKF() == true)) {}
        for (i = 1; i == 0; i = 0)
        {
          Log.i("WxIme.WxEngineMgr", "no finish first cloud res download");
          paramContext = l.JyV;
          l.fOR();
          Jwh = true;
          AppMethodBeat.o(312245);
          return;
        }
      }
      localObject1 = com.tencent.mm.plugin.hld.model.a.a.JwD;
      if (com.tencent.mm.plugin.hld.model.a.a.JwE == null)
      {
        localObject1 = l.JyV;
        localObject1 = l.getKV();
        if (localObject1 == null)
        {
          localObject1 = null;
          com.tencent.mm.plugin.hld.model.a.a.JwE = (Integer)localObject1;
        }
      }
      else
      {
        localObject1 = l.JyV;
        localObject1 = l.getKV();
        if (localObject1 != null) {
          break label465;
        }
        bool = true;
        Log.i("WxIme.ImeDictRecovery", "initRecovery isFirstLevel:" + bool + " engineCrashNum:" + com.tencent.mm.plugin.hld.model.a.a.JwE);
        if (!bool) {
          break label598;
        }
        localObject1 = com.tencent.mm.plugin.hld.model.a.a.JwE;
        s.checkNotNull(localObject1);
        if (((Integer)localObject1).intValue() <= 3) {
          break label593;
        }
        localObject1 = l.JyV;
        localObject1 = l.getKV();
        if (localObject1 != null) {
          ((MultiProcessMMKV)localObject1).putBoolean("ime_engine_init_recovery_first_level", false);
        }
        localObject1 = l.JyV;
        localObject1 = l.getKV();
        if (localObject1 != null) {
          ((MultiProcessMMKV)localObject1).putInt("ime_engine_init_native_crash_num", 0);
        }
        localObject1 = l.JyV;
        localObject1 = l.getKV();
        if (localObject1 == null) {
          break label676;
        }
        localdbu = new dbu();
        localObject2 = ((MultiProcessMMKV)localObject1).decodeBytes("ime_engine_init_recovery_data");
        if (localObject2 != null) {
          localdbu.parseFrom((byte[])localObject2);
        }
        if (localdbu.aaHl == null) {
          break label671;
        }
        localObject2 = localdbu.aaHl.aaHc;
        s.s(localObject2, "successBase.baseDicts.cloudDicts");
        if (((Collection)localObject2).isEmpty()) {
          break label478;
        }
        i = 1;
        label358:
        if (i == 0) {
          break label671;
        }
        i = 1;
        label364:
        ((MultiProcessMMKV)localObject1).encode("key_current_cloud_dicts", localdbu.aaHl.toByteArray());
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        Log.i("WxIme.ImeDictRecovery", "initRecovery no success data!");
        com.tencent.mm.plugin.hld.model.a.a.reset();
        i = j;
        label399:
        if (i != 0) {
          break label630;
        }
        Log.e("WxIme.WxEngineMgr", "repeatedly crash, switch to another ime!!");
        paramContext = WxHldService.Jnb;
        paramContext = WxHldService.fKD();
        if (!(paramContext instanceof WxHldService)) {
          break label625;
        }
      }
      label465:
      label478:
      label625:
      for (paramContext = (WxHldService)paramContext;; paramContext = null)
      {
        if (paramContext != null) {
          paramContext.Jnc = true;
        }
        AppMethodBeat.o(312245);
        return;
        localObject1 = Integer.valueOf(((MultiProcessMMKV)localObject1).getInt("ime_engine_init_native_crash_num", 0));
        break;
        bool = ((MultiProcessMMKV)localObject1).getBoolean("ime_engine_init_recovery_first_level", true);
        break label162;
        i = 0;
        break label358;
        localObject1 = l.JyV;
        if (l.bGa())
        {
          localObject1 = l.JyV;
          localObject1 = l.fPk();
          if (localObject1 != null)
          {
            localdbu = new dbu();
            localObject2 = ((MultiProcessMMKV)localObject1).decodeBytes("ime_engine_init_recovery_data");
            if (localObject2 != null) {
              localdbu.parseFrom((byte[])localObject2);
            }
            localObject2 = new dbw();
            ((dbw)localObject2).aaHn = localdbu.aaHn;
            ((dbw)localObject2).aaHm = localdbu.aaHm;
            ((MultiProcessMMKV)localObject1).encode("key_current_cloud_dicts", ((dbw)localObject2).toByteArray());
          }
        }
        Log.i("WxIme.ImeDictRecovery", "initRecovery success reset data!");
        do
        {
          i = 1;
          break;
          localObject1 = com.tencent.mm.plugin.hld.model.a.a.JwE;
          s.checkNotNull(localObject1);
        } while (((Integer)localObject1).intValue() <= 3);
        com.tencent.mm.plugin.hld.model.a.a.reset();
        i = j;
        break label399;
      }
      label593:
      label598:
      label630:
      localObject1 = f.Jyn;
      paramContext = f.io(paramContext);
      localObject1 = JvW;
      com.tencent.threadpool.h.ahAA.bk(new n..ExternalSyntheticLambda9(paramContext, (n)localObject1));
      AppMethodBeat.o(312245);
      return;
      label671:
      i = 0;
      break label364;
      label676:
      i = 0;
    }
  }
  
  private static final void m(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(312321);
    if (Jwe != 0L) {
      WxhldApi.delete_candidate_iterator(Jwe);
    }
    Jwe = paramLong1;
    ArrayList localArrayList = rV(paramLong1);
    if (localArrayList.size() >= 100) {}
    for (boolean bool = true;; bool = false)
    {
      Jwf = bool;
      if (!bool)
      {
        WxhldApi.delete_candidate_iterator(Jwe);
        Jwe = 0L;
      }
      paramLong1 = System.currentTimeMillis();
      Log.i("WxIme.WxEngineMgr", s.X("OnCandidateListUpdate ", Integer.valueOf(Jwd.size())));
      com.tencent.threadpool.h.ahAA.bk(new n..ExternalSyntheticLambda3(paramLong2, paramLong1 - paramLong2, localArrayList, paramInt));
      AppMethodBeat.o(312321);
      return;
    }
  }
  
  private static ArrayList<Candidate> rV(long paramLong)
  {
    AppMethodBeat.i(312138);
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Candidate[] arrayOfCandidate = WxhldApi.candidate_get_n(paramLong, 100);
    Collection localCollection = (Collection)localArrayList;
    s.s(arrayOfCandidate, "tempArray");
    p.a(localCollection, (Object[])arrayOfCandidate);
    Log.i("WxIme.WxEngineMgr", s.X("candidateGetOnce getCandidateTime ", Long.valueOf(System.currentTimeMillis() - l)));
    AppMethodBeat.o(312138);
    return localArrayList;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(312160);
    JvY.clear();
    JvZ.clear();
    Jwa.clear();
    AppMethodBeat.o(312160);
  }
  
  public static void wY(boolean paramBoolean)
  {
    AppMethodBeat.i(312146);
    Log.d("WxIme.WxEngineMgr", "setSingleWord");
    long l = JvX;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      WxhldApi.session_set_bool_option(l, 0, paramBoolean);
      AppMethodBeat.o(312146);
      return;
    }
  }
  
  public final void OnCandidateListUpdate(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(312517);
    Log.i("WxIme.WxEngineMgr", "OnCandidateListUpdate " + paramLong1 + ' ' + paramLong2 + ' ' + paramInt);
    paramLong1 = System.currentTimeMillis();
    com.tencent.threadpool.h.ahAA.g(new n..ExternalSyntheticLambda0(paramLong2, paramLong1, paramInt), "TAG_CANDIDATE");
    AppMethodBeat.o(312517);
  }
  
  public final void OnCandidateSelected(long paramLong)
  {
    AppMethodBeat.i(312525);
    Log.i("WxIme.WxEngineMgr", s.X("OnCandidateSelected ", Long.valueOf(paramLong)));
    AppMethodBeat.o(312525);
  }
  
  public final void OnEmitInputToScreen(long paramLong, String paramString)
  {
    AppMethodBeat.i(312532);
    long l = System.currentTimeMillis();
    Log.i("WxIme.WxEngineMgr", s.X("OnEmitInputToScreen ", Long.valueOf(paramLong)));
    com.tencent.threadpool.h.ahAA.bk(new n..ExternalSyntheticLambda4(l, paramString));
    AppMethodBeat.o(312532);
  }
  
  public final void OnLoginComplete(int paramInt)
  {
    AppMethodBeat.i(312574);
    Log.i("WxIme.WxEngineMgr", s.X("OnLoginComplete ", Integer.valueOf(paramInt)));
    AppMethodBeat.o(312574);
  }
  
  public final void OnLogouted()
  {
    AppMethodBeat.i(312588);
    Log.i("WxIme.WxEngineMgr", "OnLogouted");
    AppMethodBeat.o(312588);
  }
  
  public final void OnPendingInputUpdate(long paramLong, String paramString)
  {
    AppMethodBeat.i(312543);
    Log.d("WxIme.WxEngineMgr", s.X("OnPendingInputUpdate ", paramString));
    AppMethodBeat.o(312543);
  }
  
  public final void OnPendingInputUpdateV2(long paramLong, PendingInput[] paramArrayOfPendingInput)
  {
    int i = 0;
    AppMethodBeat.i(312554);
    Log.i("WxIme.WxEngineMgr", "OnPendingInputUpdateV2 session_id:" + paramLong + ", mSession:" + JvX);
    if (paramLong != JvX)
    {
      AppMethodBeat.o(312554);
      return;
    }
    CharSequence localCharSequence = Jwb;
    Object localObject = com.tencent.mm.plugin.hld.f.h.Jyy;
    localObject = mContext;
    s.checkNotNull(localObject);
    localObject = com.tencent.mm.plugin.hld.f.h.a((Context)localObject, paramArrayOfPendingInput);
    Jwb = (CharSequence)((r)localObject).bsC;
    Jwc = ((Number)((r)localObject).bsD).intValue();
    localObject = new StringBuilder("OnPendingInputUpdateV2: ").append(Jwb.length()).append(", ");
    boolean bool;
    if (paramArrayOfPendingInput == null)
    {
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append(", ");
      if (paramArrayOfPendingInput != null) {
        break label260;
      }
    }
    for (;;)
    {
      Log.i("WxIme.WxEngineMgr", i + ", " + Jwc);
      localObject = com.tencent.mm.plugin.hld.f.h.Jyy;
      localObject = mContext;
      s.checkNotNull(localObject);
      Log.d("WxIme.WxEngineMgr", s.X("DebugPendingInputText: ", com.tencent.mm.plugin.hld.f.h.b((Context)localObject, paramArrayOfPendingInput)));
      com.tencent.threadpool.h.ahAA.bk(new n..ExternalSyntheticLambda10(paramArrayOfPendingInput, localCharSequence));
      AppMethodBeat.o(312554);
      return;
      bool = false;
      break;
      label260:
      i = paramArrayOfPendingInput.length;
    }
  }
  
  public final void OnSessionExpired()
  {
    AppMethodBeat.i(312581);
    Log.i("WxIme.WxEngineMgr", "OnSessionExpired");
    AppMethodBeat.o(312581);
  }
  
  public final void OnSyllableListUpdate(long paramLong, Syllable[] paramArrayOfSyllable)
  {
    AppMethodBeat.i(312562);
    StringBuilder localStringBuilder = new StringBuilder("OnSyllableListUpdate ").append(paramLong).append(' ');
    if (paramArrayOfSyllable == null) {}
    for (int i = -1;; i = paramArrayOfSyllable.length)
    {
      Log.i("WxIme.WxEngineMgr", i);
      com.tencent.threadpool.h.ahAA.bk(new n..ExternalSyntheticLambda11(paramArrayOfSyllable));
      AppMethodBeat.o(312562);
      return;
    }
  }
  
  public final void fMR()
  {
    AppMethodBeat.i(312570);
    if (fNa())
    {
      AppMethodBeat.o(312570);
      return;
    }
    Log.d("WxIme.WxEngineMgr", "resetInput");
    JvX = 0L;
    WxhldApi.destroy_session(0L);
    Jwb = (CharSequence)"";
    Jwc = 0;
    Jwd.clear();
    Jwe = 0L;
    Jwf = false;
    Jno.clear();
    Iterator localIterator = JvY.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.hld.candidate.a)localIterator.next()).a(Jwd, Jwg, true, Jwf);
    }
    localIterator = JvZ.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.hld.candidate.b)localIterator.next()).a((PendingInput[])new PendingInput[0], null, 0);
    }
    localIterator = Jwa.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.hld.alternative.a)localIterator.next()).aQ(new ArrayList());
    }
    fMI();
    AppMethodBeat.o(312570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.n
 * JD-Core Version:    0.7.0.1
 */