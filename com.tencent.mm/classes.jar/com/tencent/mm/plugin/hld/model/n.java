package com.tencent.mm.plugin.hld.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.WxHldService;
import com.tencent.mm.plugin.hld.f.f;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.clm;
import com.tencent.mm.protocal.protobuf.clo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
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
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.o;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/WxEngineMgr;", "Lcom/tencent/wxhld/WxhldApi$WxhldEventListener;", "Lcom/tencent/wxhld/WxhldApi$WxhldLoginStatusListener;", "()V", "TAG", "", "TAG_CANDIDATE", "lastImeKeyParam", "Lcom/tencent/mm/plugin/hld/api/ImeKeyParam;", "mCandidateIterator", "", "mCandidateList", "Ljava/util/ArrayList;", "Lcom/tencent/wxhld/info/Candidate;", "Lkotlin/collections/ArrayList;", "mCandidateType", "", "mContext", "Landroid/content/Context;", "mCurrentKeyboardType", "mHasMoreCandidate", "", "mICandidateDataListeners", "Lcom/tencent/mm/plugin/hld/candidate/ICandidateDataListener;", "mIPendingInputDataListeners", "Lcom/tencent/mm/plugin/hld/candidate/IPendingInputDataListener;", "mISyllableListDataListeners", "Lcom/tencent/mm/plugin/hld/alternative/ISyllableListDataListener;", "mInitializeNetworkSuccess", "mInitializeSuccess", "mInitializeWait", "mPendingInputContent", "", "mPendingInputCurSorIndex", "mSession", "mSyllables", "Lcom/tencent/wxhld/info/Syllable;", "needReInitDict", "needReInitEngine", "OnCandidateListUpdate", "", "session_id", "new_iterator", "type", "OnCandidateSelected", "OnEmitInputToScreen", "text", "OnLoginComplete", "errCode", "OnLogouted", "OnPendingInputUpdate", "pending_input", "OnPendingInputUpdateV2", "pendingInputs", "", "Lcom/tencent/wxhld/info/PendingInput;", "(J[Lcom/tencent/wxhld/info/PendingInput;)V", "OnSessionExpired", "OnSyllableListUpdate", "syllables", "(J[Lcom/tencent/wxhld/info/Syllable;)V", "addICandidateDataListener", "listener", "addIPendingInputDataListener", "addISyllableListDataListener", "candidateGetOnce", "iterator", "clearUserDictPath", "createSession", "destroySession", "doThirdAppSimpleAuth", "dropLastChar", "fetchMoreCandidateList", "finalize1", "getCommonSymbols", "()[Ljava/lang/String;", "getCurrentKeyboardType", "getEngineCommitTime", "getEngineVersion", "getFirstCandidate", "getOriEngineVersion", "getPendingInput", "getPendingInputCursorIndex", "getSecondClassSymbols", "getThirdClassSymbols", "initializeEngine", "context", "initializeEngineImp", "dictInfos", "Lcom/tencent/wxhld/info/DictInfo;", "([Lcom/tencent/wxhld/info/DictInfo;)V", "initializeEngineNetWorkImp", "authCode", "", "sessionType", "initializeEngineNullNetWorkImp", "isCandidateNull", "isInitializeSuccess", "isLoginStatusOk", "isNeedReInitDict", "isNoSession", "isPendingInputNull", "loadContactData", "contacts", "([Ljava/lang/String;)Z", "loadUserDict", "path", "onSelectCandidate", "id", "suffix", "fromCandidateArea", "pressTime", "forceResetInput", "onSelectPinyin", "syllable", "onWindowHidden", "removeICandidateDataListener", "removeIPendingInputDataListener", "removeISyllableListDataListener", "reportNoTransEngineStr", "reset", "resetCursorIndex", "resetInput", "resetNeedReInitDict", "resetNeedReInitEngine", "setCursorIndex", "cursorIndex", "setNeedReInitDict", "reInit", "setNeedReInitEngine", "setSingleWord", "single", "setTextAroundCursor", "transToEngine", "processType", "Lcom/tencent/mm/plugin/hld/model/ImeProcessInputType;", "keyParam", "triggerAssociate", "plugin-hld_release"})
@SuppressLint({"StaticFieldLeak"})
public final class n
  implements WxhldApi.WxhldEventListener, WxhldApi.WxhldLoginStatusListener
{
  public static long DDY;
  private static final ArrayList<com.tencent.mm.plugin.hld.candidate.a> DDZ;
  private static ArrayList<com.tencent.mm.plugin.hld.candidate.b> DEa;
  private static ArrayList<com.tencent.mm.plugin.hld.alternative.a> DEb;
  private static CharSequence DEc;
  private static int DEd;
  private static final ArrayList<Candidate> DEe;
  private static long DEf;
  private static boolean DEg;
  private static int DEh;
  static volatile boolean DEi;
  private static boolean DEj;
  private static boolean DEk;
  public static boolean DEl;
  private static int DEm;
  public static final n DEn;
  private static final ArrayList<Syllable> DtM;
  static boolean Dva;
  private static com.tencent.mm.plugin.hld.a.g DxI;
  static Context mContext;
  
  static
  {
    AppMethodBeat.i(216951);
    DEn = new n();
    DDZ = new ArrayList();
    DEa = new ArrayList();
    DEb = new ArrayList();
    DEc = (CharSequence)"";
    DEe = new ArrayList();
    DEh = 1;
    DtM = new ArrayList();
    AppMethodBeat.o(216951);
  }
  
  public static boolean K(String[] paramArrayOfString)
  {
    AppMethodBeat.i(216940);
    p.k(paramArrayOfString, "contacts");
    if (!Dva)
    {
      Log.i("WxIme.WxEngineMgr", "loadUContactData mInitializeNetworkSuccess:" + DEj);
      AppMethodBeat.o(216940);
      return false;
    }
    long l = System.currentTimeMillis();
    WxhldApi.refresh_local_contacts(paramArrayOfString);
    paramArrayOfString = k.DDb;
    k.NX(System.currentTimeMillis() - l);
    AppMethodBeat.o(216940);
    return true;
  }
  
  public static void a(com.tencent.mm.plugin.hld.alternative.a parama)
  {
    AppMethodBeat.i(216913);
    p.k(parama, "listener");
    if (!DEb.contains(parama))
    {
      DEb.add(parama);
      parama.aB(DtM);
    }
    AppMethodBeat.o(216913);
  }
  
  public static void a(com.tencent.mm.plugin.hld.candidate.a parama)
  {
    AppMethodBeat.i(216906);
    p.k(parama, "listener");
    if (!DDZ.contains(parama))
    {
      DDZ.add(parama);
      parama.a(DEe, DEh, true, DEg);
    }
    AppMethodBeat.o(216906);
  }
  
  public static void a(com.tencent.mm.plugin.hld.candidate.b paramb)
  {
    AppMethodBeat.i(216910);
    p.k(paramb, "listener");
    if (!DEa.contains(paramb)) {
      DEa.add(paramb);
    }
    AppMethodBeat.o(216910);
  }
  
  public static void a(h paramh, com.tencent.mm.plugin.hld.a.g paramg)
  {
    AppMethodBeat.i(216903);
    p.k(paramh, "processType");
    Log.i("WxIme.WxEngineMgr", "transToEngine " + paramh.value);
    if (paramg != null)
    {
      Object localObject = paramg.text;
      if (localObject != null)
      {
        if (eEX())
        {
          if (paramh == h.DCQ)
          {
            paramh = com.tencent.mm.plugin.hld.f.l.DHK;
            paramh = mContext;
            if (paramh == null) {
              p.iCn();
            }
            com.tencent.mm.plugin.hld.f.l.hb(paramh);
          }
          AppMethodBeat.o(216903);
          return;
        }
        if (DxI == null)
        {
          int i = eEM().length();
          if (((String)localObject).length() + i > 60)
          {
            Log.w("WxIme.WxEngineMgr", "transToEngine exceed limit num");
            AppMethodBeat.o(216903);
            return;
          }
        }
        switch (o.$EnumSwitchMapping$0[paramh.ordinal()])
        {
        }
        for (;;)
        {
          long l = DDY;
          localObject = com.tencent.mm.plugin.hld.f.l.DHK;
          WxhldApi.process_input(l, com.tencent.mm.plugin.hld.f.l.b(paramh, paramg));
          AppMethodBeat.o(216903);
          return;
          DxI = paramg;
          continue;
          DxI = null;
          continue;
          DxI = null;
          localObject = g.DCm;
          if (g.eEh())
          {
            localObject = com.tencent.mm.plugin.hld.f.l.DHK;
            if ((com.tencent.mm.plugin.hld.f.l.eGY()) && (!eEE())) {
              DEn.eEO();
            }
          }
          localObject = k.DDb;
          k.X(paramg.Dui, paramg.keyType);
        }
      }
      Log.e("WxIme.WxEngineMgr", "transToEngine text is null");
      AppMethodBeat.o(216903);
      return;
    }
    Log.e("WxIme.WxEngineMgr", "transToEngine keyParam is null");
    AppMethodBeat.o(216903);
  }
  
  public static void aLz(String paramString)
  {
    AppMethodBeat.i(216926);
    p.k(paramString, "text");
    Log.d("WxIme.WxEngineMgr", "reportNoTransEngineStr");
    g localg = g.DCm;
    if (g.b(com.tencent.mm.plugin.hld.keyboard.c.Dyr))
    {
      paramString = g.DCm;
      g.eEi();
      AppMethodBeat.o(216926);
      return;
    }
    com.tencent.e.h.ZvG.be((Runnable)new l(paramString));
    AppMethodBeat.o(216926);
  }
  
  public static void b(com.tencent.mm.plugin.hld.alternative.a parama)
  {
    AppMethodBeat.i(216914);
    p.k(parama, "listener");
    DEb.remove(parama);
    AppMethodBeat.o(216914);
  }
  
  public static void b(com.tencent.mm.plugin.hld.candidate.a parama)
  {
    AppMethodBeat.i(216908);
    p.k(parama, "listener");
    DDZ.remove(parama);
    AppMethodBeat.o(216908);
  }
  
  public static void b(com.tencent.mm.plugin.hld.candidate.b paramb)
  {
    AppMethodBeat.i(216911);
    p.k(paramb, "listener");
    DEa.remove(paramb);
    AppMethodBeat.o(216911);
  }
  
  public static void b(Syllable paramSyllable, long paramLong)
  {
    AppMethodBeat.i(216902);
    Log.d("WxIme.WxEngineMgr", "onSelectPinyin ".concat(String.valueOf(paramSyllable)));
    if (paramSyllable == null)
    {
      WxhldApi.session_set_syllable_hint(DDY, null, 0, "");
      AppMethodBeat.o(216902);
      return;
    }
    k localk = k.DDb;
    k.X(paramLong, 4);
    WxhldApi.session_set_syllable_hint(DDY, paramSyllable.id, paramSyllable.id_len, paramSyllable.syllable);
    AppMethodBeat.o(216902);
  }
  
  public static boolean eEB()
  {
    return Dva;
  }
  
  private static void eED()
  {
    AppMethodBeat.i(216889);
    com.tencent.e.h.ZvG.bc((Runnable)i.DEy);
    AppMethodBeat.o(216889);
  }
  
  public static boolean eEE()
  {
    AppMethodBeat.i(216891);
    if (eEX())
    {
      AppMethodBeat.o(216891);
      return true;
    }
    boolean bool = Util.isNullOrNil(DEc);
    AppMethodBeat.o(216891);
    return bool;
  }
  
  public static void eEF()
  {
    boolean bool = true;
    AppMethodBeat.i(216895);
    Object localObject1 = new SessionConfig();
    Object localObject2 = g.DCm;
    int j = g.eEg();
    ((SessionConfig)localObject1).enable_auto_most_likely = true;
    localObject2 = com.tencent.mm.plugin.hld.f.e.DGW;
    ((SessionConfig)localObject1).enable_pre_input = com.tencent.mm.plugin.hld.f.e.eGn();
    localObject2 = com.tencent.mm.plugin.hld.f.i.DHq;
    ((SessionConfig)localObject1).safe_mode = com.tencent.mm.plugin.hld.f.i.eGC();
    int i;
    if (j == com.tencent.mm.plugin.hld.keyboard.c.Dyl.ordinal()) {
      i = 1;
    }
    for (;;)
    {
      ((SessionConfig)localObject1).key_board_type = i;
      DEm = ((SessionConfig)localObject1).key_board_type;
      localObject2 = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.hld.a.d.class);
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.hld.a.d)localObject2).eCD();
        if ((localObject2 != null) && (((com.tencent.mm.plugin.hld.a.b)localObject2).eCv() == true)) {
          ((SessionConfig)localObject1).use_wechat_internal_emoji = true;
        }
      }
      ((SessionConfig)localObject1).enable_shift_key_correction = false;
      localObject2 = com.tencent.mm.plugin.hld.f.e.DGW;
      localObject2 = com.tencent.mm.plugin.hld.f.e.DGW;
      ((SessionConfig)localObject1).enable_nl = false;
      ((SessionConfig)localObject1).enable_rl = false;
      ((SessionConfig)localObject1).enable_hf = false;
      ((SessionConfig)localObject1).enable_gk = false;
      ((SessionConfig)localObject1).enable_ang = false;
      ((SessionConfig)localObject1).enable_iang = false;
      ((SessionConfig)localObject1).enable_uang = false;
      ((SessionConfig)localObject1).enable_retroflex = false;
      ((SessionConfig)localObject1).enable_hui_fei = false;
      ((SessionConfig)localObject1).enable_eng = false;
      ((SessionConfig)localObject1).enable_ing = false;
      ((SessionConfig)localObject1).enable_ong = false;
      ((SessionConfig)localObject1).enable_huang_wang = false;
      ((SessionConfig)localObject1).enable_un_ong = false;
      ((SessionConfig)localObject1).enable_un_iong = false;
      ((SessionConfig)localObject1).enable_an_ai = false;
      ((SessionConfig)localObject1).enable_eng_ong = false;
      localObject2 = g.DCm;
      if (g.b(com.tencent.mm.plugin.hld.keyboard.c.Dyl)) {
        ((SessionConfig)localObject1).enable_keyboard_neighbour = false;
      }
      Log.i("WxIme.WxEngineMgr", "createSession " + Dva + ' ' + j);
      if (!Dva) {
        break label565;
      }
      if (!eEX()) {
        eEG();
      }
      if (!DEk) {
        break label512;
      }
      localObject2 = mContext;
      if (localObject2 == null) {
        break label586;
      }
      f localf = f.DGX;
      localObject2 = f.gS((Context)localObject2);
      if (localObject2 == null) {
        break label572;
      }
      com.tencent.mm.plugin.hld.model.a.a.DEX.startMonitor();
      localf = f.DGX;
      WxhldApi.config_dict((DictInfo[])localObject2, f.eGu());
      localObject2 = f.DGX;
      localObject2 = f.eGs();
      if (localObject2 == null) {
        break;
      }
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        localf = localObject2[i];
        if (localf != null) {
          WxhldApi.add_cell_dict(localf.path, localf.id);
        }
        i += 1;
      }
      if (j == com.tencent.mm.plugin.hld.keyboard.c.Dym.ordinal())
      {
        i = 0;
      }
      else if (j == com.tencent.mm.plugin.hld.keyboard.c.Dyn.ordinal())
      {
        i = 2;
      }
      else
      {
        Log.e("WxIme.WxEngineMgr", "createSession why here? ".concat(String.valueOf(j)));
        i = 0;
      }
    }
    com.tencent.mm.plugin.hld.model.a.a.DEX.eFu();
    for (;;)
    {
      DEk = false;
      localObject2 = com.tencent.mm.plugin.hld.c.a.DvH;
      com.tencent.mm.plugin.hld.c.a.eCW();
      Log.i("WxIme.WxEngineMgr", "use new cloud dicts, reInit:".concat(String.valueOf(bool)));
      label512:
      long l = System.currentTimeMillis();
      DDY = WxhldApi.create_session((SessionConfig)localObject1);
      localObject2 = k.DDb;
      k.Y(System.currentTimeMillis() - l, ((SessionConfig)localObject1).key_board_type);
      eEL();
      eEQ();
      localObject1 = com.tencent.mm.plugin.hld.f.c.DGO;
      com.tencent.mm.plugin.hld.f.c.eFY();
      if (!DEj) {
        eED();
      }
      label565:
      AppMethodBeat.o(216895);
      return;
      label572:
      Log.e("WxIme.WxEngineMgr", "createSession BaseDictInfos is null");
      bool = false;
      continue;
      label586:
      Log.e("WxIme.WxEngineMgr", "createSession mContext is null");
      bool = false;
    }
  }
  
  public static void eEG()
  {
    AppMethodBeat.i(216896);
    Log.i("WxIme.WxEngineMgr", "destroySession");
    if (eEX())
    {
      AppMethodBeat.o(216896);
      return;
    }
    WxhldApi.destroy_session(DDY);
    DDY = 0L;
    DEc = (CharSequence)"";
    DEd = 0;
    DEe.clear();
    DtM.clear();
    AppMethodBeat.o(216896);
  }
  
  public static void eEH()
  {
    AppMethodBeat.i(216897);
    Log.i("WxIme.WxEngineMgr", "setNeedReInitDict reInit:true mInitializeWait:" + DEi);
    DEk = true;
    if (DEi)
    {
      Context localContext = mContext;
      if (localContext != null)
      {
        gR(localContext);
        AppMethodBeat.o(216897);
        return;
      }
      Log.e("WxIme.WxEngineMgr", "setNeedReInitDict mContext is null??");
    }
    AppMethodBeat.o(216897);
  }
  
  public static void eEI()
  {
    DEl = false;
  }
  
  public static void eEJ()
  {
    AppMethodBeat.i(216898);
    Log.i("WxIme.WxEngineMgr", "resetCursorIndex " + DDY + ' ' + eEM().length());
    if (eEX())
    {
      AppMethodBeat.o(216898);
      return;
    }
    WxhldApi.session_set_internal_cursor(DDY, 0);
    AppMethodBeat.o(216898);
  }
  
  public static void eEK()
  {
    AppMethodBeat.i(216899);
    Log.d("WxIme.WxEngineMgr", "dropLastChar");
    WxhldApi.drop_last(DDY);
    AppMethodBeat.o(216899);
  }
  
  public static void eEL()
  {
    AppMethodBeat.i(216900);
    if (eEX())
    {
      AppMethodBeat.o(216900);
      return;
    }
    com.tencent.e.h.ZvG.be((Runnable)m.DEC);
    AppMethodBeat.o(216900);
  }
  
  public static CharSequence eEM()
  {
    AppMethodBeat.i(216904);
    if (eEX())
    {
      localCharSequence = (CharSequence)"";
      AppMethodBeat.o(216904);
      return localCharSequence;
    }
    CharSequence localCharSequence = DEc;
    AppMethodBeat.o(216904);
    return localCharSequence;
  }
  
  public static void eEN()
  {
    AppMethodBeat.i(216918);
    com.tencent.e.h.ZvG.d((Runnable)e.DEv, "TAG_CANDIDATE");
    AppMethodBeat.o(216918);
  }
  
  public static Candidate eEP()
  {
    AppMethodBeat.i(216936);
    if (DEe.isEmpty())
    {
      localCandidate = new Candidate(0);
      localCandidate.text = "";
      AppMethodBeat.o(216936);
      return localCandidate;
    }
    Candidate localCandidate = (Candidate)j.lo((List)DEe);
    AppMethodBeat.o(216936);
    return localCandidate;
  }
  
  public static void eEQ()
  {
    AppMethodBeat.i(216937);
    Log.d("WxIme.WxEngineMgr", "triggerAssociate " + Util.getStack());
    if (eEX())
    {
      AppMethodBeat.o(216937);
      return;
    }
    AppMethodBeat.o(216937);
  }
  
  public static String[] eER()
  {
    AppMethodBeat.i(216942);
    String[] arrayOfString = WxhldApi.get_puncts_classification(2);
    p.j(arrayOfString, "WxhldApi.get_puncts_clas….WxhldPunctType.CLASS_II)");
    AppMethodBeat.o(216942);
    return arrayOfString;
  }
  
  public static String[] eES()
  {
    AppMethodBeat.i(216944);
    String[] arrayOfString = WxhldApi.get_puncts_classification(3);
    p.j(arrayOfString, "WxhldApi.get_puncts_clas…WxhldPunctType.CLASS_III)");
    AppMethodBeat.o(216944);
    return arrayOfString;
  }
  
  public static String eET()
  {
    AppMethodBeat.i(216945);
    String str = WxhldApi.get_version();
    p.j(str, "oriVersion");
    Object localObject = kotlin.n.n.a((CharSequence)str, new String[] { "." });
    if (((List)localObject).size() >= 3) {}
    for (localObject = (String)((List)localObject).get(0) + '.' + (String)((List)localObject).get(1) + '.' + (String)((List)localObject).get(2);; localObject = str)
    {
      Log.i("WxIme.WxEngineMgr", "getEngineVersion oriVersion:" + str + " version:" + (String)localObject);
      p.j(localObject, "version");
      AppMethodBeat.o(216945);
      return localObject;
    }
  }
  
  public static String eEU()
  {
    AppMethodBeat.i(216946);
    String str = WxhldApi.get_version();
    p.j(str, "WxhldApi.get_version()");
    AppMethodBeat.o(216946);
    return str;
  }
  
  public static String eEV()
  {
    AppMethodBeat.i(216947);
    long l = WxhldApi.get_commit_time();
    AppMethodBeat.o(216947);
    return String.valueOf(l);
  }
  
  public static int eEW()
  {
    return DEm;
  }
  
  public static boolean eEX()
  {
    return DDY == 0L;
  }
  
  public static void finalize1()
  {
    AppMethodBeat.i(216934);
    Log.i("WxIme.WxEngineMgr", "finalize1 " + Dva);
    if (!Dva)
    {
      AppMethodBeat.o(216934);
      return;
    }
    if (!eEX()) {
      WxhldApi.destroy_session(DDY);
    }
    DDY = 0L;
    DEc = (CharSequence)"";
    DEd = 0;
    DEe.clear();
    DEf = 0L;
    DEg = false;
    DtM.clear();
    Object localObject = DDZ.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.plugin.hld.candidate.a)((Iterator)localObject).next()).a(DEe, DEh, true, DEg);
    }
    localObject = DEa.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.plugin.hld.candidate.b)((Iterator)localObject).next()).a(new PendingInput[0], null, 0);
    }
    localObject = DEb.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.plugin.hld.alternative.a)((Iterator)localObject).next()).aB(new ArrayList());
    }
    WxhldApi.finalize1();
    localObject = mContext;
    if (localObject != null)
    {
      gR((Context)localObject);
      AppMethodBeat.o(216934);
      return;
    }
    Log.e("WxIme.WxEngineMgr", "finalize1 mContext is null");
    AppMethodBeat.o(216934);
  }
  
  public static void gR(Context paramContext)
  {
    AppMethodBeat.i(216882);
    p.k(paramContext, "context");
    Log.i("WxIme.WxEngineMgr", "initializeEngine");
    mContext = paramContext;
    com.tencent.e.h.ZvG.be((Runnable)new f(paramContext));
    AppMethodBeat.o(216882);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(216931);
    DDZ.clear();
    DEa.clear();
    DEb.clear();
    AppMethodBeat.o(216931);
  }
  
  public static void sS(boolean paramBoolean)
  {
    AppMethodBeat.i(216925);
    Log.d("WxIme.WxEngineMgr", "setSingleWord");
    long l = DDY;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      WxhldApi.session_set_bool_option(l, 0, paramBoolean);
      AppMethodBeat.o(216925);
      return;
    }
  }
  
  public final void OnCandidateListUpdate(long paramLong1, long paramLong2, final int paramInt)
  {
    AppMethodBeat.i(216916);
    Log.i("WxIme.WxEngineMgr", "OnCandidateListUpdate " + paramLong1 + ' ' + paramLong2 + ' ' + paramInt);
    paramLong1 = System.currentTimeMillis();
    com.tencent.e.h.ZvG.d((Runnable)new a(paramLong2, paramLong1, paramInt), "TAG_CANDIDATE");
    AppMethodBeat.o(216916);
  }
  
  public final void OnCandidateSelected(long paramLong)
  {
    AppMethodBeat.i(216919);
    Log.i("WxIme.WxEngineMgr", "OnCandidateSelected ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(216919);
  }
  
  public final void OnEmitInputToScreen(long paramLong, String paramString)
  {
    AppMethodBeat.i(216920);
    long l = System.currentTimeMillis();
    Log.i("WxIme.WxEngineMgr", "OnEmitInputToScreen ".concat(String.valueOf(paramLong)));
    com.tencent.e.h.ZvG.bc((Runnable)new b(l, paramString));
    AppMethodBeat.o(216920);
  }
  
  public final void OnLoginComplete(int paramInt)
  {
    AppMethodBeat.i(216948);
    Log.i("WxIme.WxEngineMgr", "OnLoginComplete ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(216948);
  }
  
  public final void OnLogouted()
  {
    AppMethodBeat.i(216950);
    Log.i("WxIme.WxEngineMgr", "OnLogouted");
    AppMethodBeat.o(216950);
  }
  
  public final void OnPendingInputUpdate(long paramLong, String paramString)
  {
    AppMethodBeat.i(216922);
    Log.d("WxIme.WxEngineMgr", "OnPendingInputUpdate ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(216922);
  }
  
  public final void OnPendingInputUpdateV2(long paramLong, PendingInput[] paramArrayOfPendingInput)
  {
    int i = 0;
    AppMethodBeat.i(216923);
    Log.i("WxIme.WxEngineMgr", "OnPendingInputUpdateV2 session_id:" + paramLong + ", mSession:" + DDY);
    if (paramLong != DDY)
    {
      AppMethodBeat.o(216923);
      return;
    }
    final CharSequence localCharSequence = DEc;
    Object localObject1 = com.tencent.mm.plugin.hld.f.h.DHl;
    localObject1 = mContext;
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = com.tencent.mm.plugin.hld.f.h.a((Context)localObject1, paramArrayOfPendingInput);
    DEc = (CharSequence)((o)localObject1).Mx;
    DEd = ((Number)((o)localObject1).My).intValue();
    localObject1 = new StringBuilder("OnPendingInputUpdateV2: ").append(DEc.length()).append(", ");
    if (paramArrayOfPendingInput == null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = ((StringBuilder)localObject1).append(bool).append(", ");
      if (paramArrayOfPendingInput != null) {
        i = paramArrayOfPendingInput.length;
      }
      Log.i("WxIme.WxEngineMgr", i + ", " + DEd);
      localObject1 = new StringBuilder("DebugPendingInputText: ");
      Object localObject2 = com.tencent.mm.plugin.hld.f.h.DHl;
      localObject2 = mContext;
      if (localObject2 == null) {
        p.iCn();
      }
      Log.d("WxIme.WxEngineMgr", com.tencent.mm.plugin.hld.f.h.b((Context)localObject2, paramArrayOfPendingInput));
      com.tencent.e.h.ZvG.bc((Runnable)new c(paramArrayOfPendingInput, localCharSequence));
      AppMethodBeat.o(216923);
      return;
    }
  }
  
  public final void OnSessionExpired()
  {
    AppMethodBeat.i(216949);
    Log.i("WxIme.WxEngineMgr", "OnSessionExpired");
    AppMethodBeat.o(216949);
  }
  
  public final void OnSyllableListUpdate(long paramLong, Syllable[] paramArrayOfSyllable)
  {
    AppMethodBeat.i(216924);
    StringBuilder localStringBuilder = new StringBuilder("OnSyllableListUpdate ").append(paramLong).append(' ');
    if (paramArrayOfSyllable != null) {}
    for (int i = paramArrayOfSyllable.length;; i = -1)
    {
      Log.i("WxIme.WxEngineMgr", i);
      com.tencent.e.h.ZvG.bc((Runnable)new d(paramArrayOfSyllable));
      AppMethodBeat.o(216924);
      return;
    }
  }
  
  public final void eEO()
  {
    AppMethodBeat.i(216929);
    if (eEX())
    {
      AppMethodBeat.o(216929);
      return;
    }
    Log.d("WxIme.WxEngineMgr", "resetInput");
    DDY = 0L;
    WxhldApi.destroy_session(0L);
    DEc = (CharSequence)"";
    DEd = 0;
    DEe.clear();
    DEf = 0L;
    DEg = false;
    DtM.clear();
    Iterator localIterator = DDZ.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.hld.candidate.a)localIterator.next()).a(DEe, DEh, true, DEg);
    }
    localIterator = DEa.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.hld.candidate.b)localIterator.next()).a(new PendingInput[0], null, 0);
    }
    localIterator = DEb.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.hld.alternative.a)localIterator.next()).aB(new ArrayList());
    }
    eEF();
    AppMethodBeat.o(216929);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(long paramLong1, long paramLong2, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(209839);
      Object localObject1 = n.DEn;
      if (n.eFe() != 0L)
      {
        localObject1 = n.DEn;
        WxhldApi.delete_candidate_iterator(n.eFe());
      }
      localObject1 = n.DEn;
      n.NY(this.DEo);
      localObject1 = n.DEn;
      localObject1 = n.NZ(n.eFe());
      Object localObject2 = n.DEn;
      if (((ArrayList)localObject1).size() >= 100) {}
      for (boolean bool = true;; bool = false)
      {
        n.sT(bool);
        localObject2 = n.DEn;
        if (!n.eFf())
        {
          localObject2 = n.DEn;
          WxhldApi.delete_candidate_iterator(n.eFe());
          localObject2 = n.DEn;
          n.NY(0L);
        }
        long l1 = System.currentTimeMillis();
        long l2 = paramInt;
        localObject2 = new StringBuilder("OnCandidateListUpdate ");
        n localn = n.DEn;
        Log.i("WxIme.WxEngineMgr", n.eFg().size());
        com.tencent.e.h.ZvG.bc((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(217162);
            Object localObject1 = new StringBuilder("OnCandidateListUpdate size:");
            Object localObject2 = n.DEn;
            Log.d("WxIme.WxEngineMgr", n.eFh().size());
            localObject1 = k.DDb;
            k.n(this.DEq.DEp, System.currentTimeMillis() - this.DEq.DEp - this.DDp, this.DDp);
            localObject1 = n.DEn;
            n.eFg().clear();
            localObject1 = n.DEn;
            n.eFg().addAll((Collection)this.DEr);
            localObject1 = n.DEn;
            n.UE(this.DEq.cPi);
            localObject1 = n.DEn;
            localObject1 = n.eFh().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (com.tencent.mm.plugin.hld.candidate.a)((Iterator)localObject1).next();
              Object localObject3 = n.DEn;
              localObject3 = n.eFg();
              n localn = n.DEn;
              int i = n.eFi();
              localn = n.DEn;
              ((com.tencent.mm.plugin.hld.candidate.a)localObject2).a((ArrayList)localObject3, i, true, n.eFf());
            }
            AppMethodBeat.o(217162);
          }
        });
        AppMethodBeat.o(209839);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(long paramLong, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(214216);
      Object localObject = k.DDb;
      k.ag(this.DEp, System.currentTimeMillis() - this.DEp);
      localObject = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.hld.a.d.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).eCD();
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.hld.a.b)localObject).c((CharSequence)this.uXe, true);
          AppMethodBeat.o(214216);
          return;
        }
      }
      AppMethodBeat.o(214216);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(PendingInput[] paramArrayOfPendingInput, CharSequence paramCharSequence) {}
    
    public final void run()
    {
      AppMethodBeat.i(214050);
      Object localObject = n.DEn;
      localObject = n.eFj().iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.hld.candidate.b localb = (com.tencent.mm.plugin.hld.candidate.b)((Iterator)localObject).next();
        PendingInput[] arrayOfPendingInput = this.DEs;
        CharSequence localCharSequence = localCharSequence;
        n localn = n.DEn;
        localb.a(arrayOfPendingInput, localCharSequence, n.eFk());
      }
      localObject = n.DEn;
      if (n.eEE())
      {
        localObject = n.DEn;
        n.eEQ();
      }
      AppMethodBeat.o(214050);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(Syllable[] paramArrayOfSyllable) {}
    
    public final void run()
    {
      AppMethodBeat.i(209137);
      Object localObject = n.DEn;
      n.eFl().clear();
      if (this.DEu != null)
      {
        localObject = n.DEn;
        j.a((Collection)n.eFl(), this.DEu);
      }
      localObject = n.DEn;
      localObject = n.eFm().iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.hld.alternative.a locala = (com.tencent.mm.plugin.hld.alternative.a)((Iterator)localObject).next();
        n localn = n.DEn;
        locala.aB(n.eFl());
      }
      AppMethodBeat.o(209137);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    public static final e DEv;
    
    static
    {
      AppMethodBeat.i(209908);
      DEv = new e();
      AppMethodBeat.o(209908);
    }
    
    public final void run()
    {
      AppMethodBeat.i(209906);
      Log.i("WxIme.WxEngineMgr", "fetchMoreCandidateList");
      Object localObject = n.DEn;
      n localn;
      if (n.eFe() != 0L)
      {
        localObject = n.DEn;
        localObject = n.NZ(n.eFe());
        localn = n.DEn;
        if (((ArrayList)localObject).size() < 100) {
          break label108;
        }
      }
      label108:
      for (boolean bool = true;; bool = false)
      {
        n.sT(bool);
        localn = n.DEn;
        if (!n.eFf())
        {
          localn = n.DEn;
          WxhldApi.delete_candidate_iterator(n.eFe());
          localn = n.DEn;
          n.NY(0L);
        }
        com.tencent.e.h.ZvG.bc((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(217503);
            Object localObject1 = new StringBuilder("OnCandidateListUpdate size:");
            Object localObject2 = n.DEn;
            Log.d("WxIme.WxEngineMgr", n.eFh().size());
            localObject1 = n.DEn;
            n.eFg().addAll((Collection)this.DEr);
            localObject1 = n.DEn;
            localObject1 = n.eFh().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (com.tencent.mm.plugin.hld.candidate.a)((Iterator)localObject1).next();
              Object localObject3 = n.DEn;
              localObject3 = n.eFg();
              n localn = n.DEn;
              int i = n.eFi();
              localn = n.DEn;
              ((com.tencent.mm.plugin.hld.candidate.a)localObject2).a((ArrayList)localObject3, i, false, n.eFf());
            }
            AppMethodBeat.o(217503);
          }
        });
        AppMethodBeat.o(209906);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(Context paramContext) {}
    
    public final void run()
    {
      int j = 0;
      AppMethodBeat.i(216614);
      Log.i("WxIme.WxEngineMgr", "wxIme get WximeInitInfo");
      Object localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      boolean bool;
      label153:
      Object localObject2;
      Object localObject3;
      if (!com.tencent.mm.plugin.hld.f.l.eCE())
      {
        localObject1 = com.tencent.mm.plugin.hld.f.e.DGW;
        localObject1 = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.hld.a.d.class);
        if ((localObject1 == null) || (((com.tencent.mm.plugin.hld.a.d)localObject1).eCC() != true))
        {
          Log.i("WxIme.WxEngineMgr", "no finish first cloud res download");
          localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
          com.tencent.mm.plugin.hld.f.l.eHi();
          localObject1 = n.DEn;
          n.eEY();
          AppMethodBeat.o(216614);
          return;
        }
        localObject1 = com.tencent.mm.plugin.hld.model.a.a.DEX;
        if (com.tencent.mm.plugin.hld.model.a.a.DEU == null)
        {
          localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
          localObject1 = com.tencent.mm.plugin.hld.f.l.getKV();
          if (localObject1 != null)
          {
            localObject1 = Integer.valueOf(((MultiProcessMMKV)localObject1).getInt("ime_engine_init_native_crash_num", 0));
            com.tencent.mm.plugin.hld.model.a.a.DEU = (Integer)localObject1;
          }
        }
        else
        {
          localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
          localObject1 = com.tencent.mm.plugin.hld.f.l.getKV();
          if (localObject1 == null) {
            break label449;
          }
          bool = ((MultiProcessMMKV)localObject1).getBoolean("ime_engine_init_recovery_first_level", true);
          Log.i("WxIme.ImeDictRecovery", "initRecovery isFirstLevel:" + bool + " engineCrashNum:" + com.tencent.mm.plugin.hld.model.a.a.DEU);
          if (!bool) {
            break label575;
          }
          localObject1 = com.tencent.mm.plugin.hld.model.a.a.DEU;
          if (localObject1 == null) {
            p.iCn();
          }
          if (((Integer)localObject1).intValue() <= 3) {
            break label570;
          }
          localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
          localObject1 = com.tencent.mm.plugin.hld.f.l.getKV();
          if (localObject1 != null) {
            ((MultiProcessMMKV)localObject1).putBoolean("ime_engine_init_recovery_first_level", false);
          }
          localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
          localObject1 = com.tencent.mm.plugin.hld.f.l.getKV();
          if (localObject1 != null) {
            ((MultiProcessMMKV)localObject1).putInt("ime_engine_init_native_crash_num", 0);
          }
          localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
          localObject1 = com.tencent.mm.plugin.hld.f.l.getKV();
          if (localObject1 == null) {
            break label459;
          }
          localObject2 = new clm();
          localObject3 = ((MultiProcessMMKV)localObject1).decodeBytes("ime_engine_init_recovery_data");
          if (localObject3 != null) {
            ((clm)localObject2).parseFrom((byte[])localObject3);
          }
          if (((clm)localObject2).Tta == null) {
            break label641;
          }
          localObject3 = ((clm)localObject2).Tta.TsR;
          p.j(localObject3, "successBase.baseDicts.cloudDicts");
          if (((Collection)localObject3).isEmpty()) {
            break label454;
          }
          i = 1;
          label345:
          if (i == 0) {
            break label641;
          }
        }
      }
      label641:
      for (int i = 1;; i = 0)
      {
        ((MultiProcessMMKV)localObject1).encode("key_current_cloud_dicts", ((clm)localObject2).Tta.toByteArray());
        label367:
        if (i == 0)
        {
          Log.i("WxIme.ImeDictRecovery", "initRecovery no success data!");
          com.tencent.mm.plugin.hld.model.a.a.reset();
          i = j;
        }
        for (;;)
        {
          if (i == 0)
          {
            Log.e("WxIme.WxEngineMgr", "repeatedly crash, switch to another ime!!");
            localObject1 = WxHldService.DtA;
            localObject2 = WxHldService.eCA();
            localObject1 = localObject2;
            if (!(localObject2 instanceof WxHldService)) {
              localObject1 = null;
            }
            localObject1 = (WxHldService)localObject1;
            if (localObject1 != null)
            {
              ((WxHldService)localObject1).Dtv = true;
              AppMethodBeat.o(216614);
              return;
              localObject1 = null;
              break;
              label449:
              bool = true;
              break label153;
              label454:
              i = 0;
              break label345;
              label459:
              i = 0;
              break label367;
              localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
              if (com.tencent.mm.plugin.hld.f.l.biq())
              {
                localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
                localObject1 = com.tencent.mm.plugin.hld.f.l.eHB();
                if (localObject1 != null)
                {
                  localObject2 = new clm();
                  localObject3 = ((MultiProcessMMKV)localObject1).decodeBytes("ime_engine_init_recovery_data");
                  if (localObject3 != null) {
                    ((clm)localObject2).parseFrom((byte[])localObject3);
                  }
                  localObject3 = new clo();
                  ((clo)localObject3).Ttc = ((clm)localObject2).Ttc;
                  ((clo)localObject3).Ttb = ((clm)localObject2).Ttb;
                  ((MultiProcessMMKV)localObject1).encode("key_current_cloud_dicts", ((clo)localObject3).toByteArray());
                }
              }
              Log.i("WxIme.ImeDictRecovery", "initRecovery success reset data!");
              label570:
              label575:
              do
              {
                i = 1;
                break;
                localObject1 = com.tencent.mm.plugin.hld.model.a.a.DEU;
                if (localObject1 == null) {
                  p.iCn();
                }
              } while (((Integer)localObject1).intValue() <= 3);
              com.tencent.mm.plugin.hld.model.a.a.reset();
              i = j;
              continue;
            }
            AppMethodBeat.o(216614);
            return;
          }
        }
        localObject1 = f.DGX;
        localObject1 = f.gS(this.$context);
        localObject2 = n.DEn;
        n.a((DictInfo[])localObject1);
        AppMethodBeat.o(216614);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(DictInfo[] paramArrayOfDictInfo) {}
    
    public final void run()
    {
      AppMethodBeat.i(216777);
      long l6 = System.currentTimeMillis();
      Object localObject1 = com.tencent.mm.plugin.hld.f.i.DHq;
      boolean bool = com.tencent.mm.plugin.hld.f.i.eGC();
      Log.i("WxIme.WxEngineMgr", "wxIme start initialize(isSafetyMode:" + bool + ')');
      if (this.DEw != null)
      {
        com.tencent.mm.plugin.hld.model.a.a.DEX.startMonitor();
        localObject1 = WxhldApi.getInstance();
        Object localObject2 = n.DEn;
        ((WxhldApi)localObject1).init(n.eEZ());
        localObject1 = com.tencent.mm.plugin.hld.f.e.DGW;
        WxhldApi.set_debug_console_log(com.tencent.mm.plugin.hld.f.e.eGm());
        long l2 = System.currentTimeMillis();
        localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
        localObject1 = com.tencent.mm.plugin.hld.f.l.eGU() + "/net";
        if (!u.agG((String)localObject1)) {
          u.bBD((String)localObject1);
        }
        WxhldApi.init_network((String)localObject1);
        long l3 = System.currentTimeMillis();
        long l1 = 0L;
        localObject1 = f.DGX;
        Log.i("WxIme.WxEngineMgr", "initializeEngineImp ".concat(String.valueOf(f.eGu())));
        long l4 = System.currentTimeMillis();
        localObject1 = this.DEw;
        localObject2 = f.DGX;
        WxhldApi.config_dict((DictInfo[])localObject1, f.eGu());
        long l5 = System.currentTimeMillis();
        localObject1 = f.DGX;
        localObject1 = f.eGs();
        if (localObject1 != null)
        {
          l1 = System.currentTimeMillis();
          int j = localObject1.length;
          int i = 0;
          if (i < j)
          {
            localObject2 = localObject1[i];
            if (localObject2 != null)
            {
              if (!u.agG(((DictInfo)localObject2).path)) {
                break label270;
              }
              WxhldApi.add_cell_dict(((DictInfo)localObject2).path, ((DictInfo)localObject2).id);
            }
            for (;;)
            {
              i += 1;
              break;
              label270:
              Log.i("WxIme.WxEngineMgr", "add_cell_dict " + ((DictInfo)localObject2).path + ' ' + ((DictInfo)localObject2).id + " no exist");
            }
          }
          l1 = System.currentTimeMillis() - l1;
        }
        WxhldApi.getInstance().SetWxhldLoginStatusListener((WxhldApi.WxhldLoginStatusListener)n.DEn);
        localObject1 = new InitInfo();
        localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
        localObject2 = com.tencent.mm.plugin.hld.f.l.eGU() + "/engine";
        if (!u.agG((String)localObject2)) {
          u.bBD((String)localObject2);
        }
        ((InitInfo)localObject1).workDir = ((String)localObject2);
        ((InitInfo)localObject1).safeMode = bool;
        long l7 = System.currentTimeMillis();
        WxhldApi.initialize((InitInfo)localObject1);
        long l8 = System.currentTimeMillis();
        WxhldApi.getInstance().SetWxhldEventListener((WxhldApi.WxhldEventListener)n.DEn);
        localObject1 = n.DEn;
        n.eFa();
        localObject1 = n.DEn;
        n.eEI();
        localObject1 = com.tencent.mm.plugin.hld.c.a.DvH;
        com.tencent.mm.plugin.hld.c.a.eCW();
        localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
        if (com.tencent.mm.plugin.hld.f.l.biq())
        {
          localObject1 = com.tencent.mm.plugin.hld.f.c.DGO;
          com.tencent.mm.plugin.hld.f.c.eFX();
          localObject1 = n.DEn;
          n.eEC();
        }
        com.tencent.mm.plugin.hld.model.a.a.DEX.eFu();
        Log.i("WxIme.WxEngineMgr", "wxIme initialize successfully!，" + (System.currentTimeMillis() - l6) + ' ');
        localObject1 = n.DEn;
        n.eEF();
        localObject1 = n.DEn;
        n.eFb();
        localObject1 = n.DEn;
        n.eFc();
        localObject1 = k.DDb;
        if (!k.eEz())
        {
          l6 = System.currentTimeMillis();
          com.tencent.e.h.ZvG.d((Runnable)new k.k(l8 - l7, l5 - l4, l1, l3 - l2, l6), "WxIme.ImeReporter");
        }
        localObject1 = g.DCm;
        localObject2 = g.DCd;
        if (localObject2 != null)
        {
          if (((View)localObject2).getVisibility() == 0) {
            ((g)localObject1).eDW();
          }
          AppMethodBeat.o(216777);
          return;
        }
        AppMethodBeat.o(216777);
        return;
      }
      localObject1 = n.DEn;
      n.eEY();
      localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      com.tencent.mm.plugin.hld.f.l.eHi();
      g.DCm.eDW();
      Log.e("WxIme.WxEngineMgr", "cloud dict is null，" + (System.currentTimeMillis() - l6) + ' ');
      AppMethodBeat.o(216777);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      AppMethodBeat.i(215962);
      Log.i("WxIme.WxEngineMgr", "initializeEngineNetWorkImp authCode:" + this.DEx.length + " sessionType:" + this.DDz);
      NetworkInfo localNetworkInfo = new NetworkInfo(this.DEx.length);
      localNetworkInfo.authCode = this.DEx;
      localNetworkInfo.sessionType = this.DDz;
      localNetworkInfo.lkid = com.tencent.mm.plugin.normsg.a.d.GxJ.fju();
      localNetworkInfo.useDefaultDebugIp = false;
      WxhldApi.network_login(localNetworkInfo);
      AppMethodBeat.o(215962);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    public static final i DEy;
    
    static
    {
      AppMethodBeat.i(211451);
      DEy = new i();
      AppMethodBeat.o(211451);
    }
    
    public final void run()
    {
      AppMethodBeat.i(211450);
      Log.i("WxIme.WxEngineMgr", "initializeEngineNullNetWorkImp");
      WxhldApi.network_login(new NetworkInfo(0));
      AppMethodBeat.o(211450);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(long paramLong1, long paramLong2, String paramString1, boolean paramBoolean, String paramString2, CharSequence paramCharSequence) {}
    
    public final void run()
    {
      AppMethodBeat.i(216726);
      Object localObject = k.DDb;
      k.a(this.DDm, 0L, System.currentTimeMillis() - this.DEp, 0L, 2L, 0);
      localObject = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.hld.a.d.class);
      if (localObject != null)
      {
        com.tencent.mm.plugin.hld.a.b localb = ((com.tencent.mm.plugin.hld.a.d)localObject).eCD();
        if (localb != null)
        {
          StringBuilder localStringBuilder = new StringBuilder().append(this.uXe);
          if (this.DEz)
          {
            localObject = " ";
            localStringBuilder = localStringBuilder.append((String)localObject);
            if (!Util.isNullOrNil(this.DEA)) {
              break label131;
            }
          }
          label131:
          for (localObject = "";; localObject = this.DEA)
          {
            localb.a((CharSequence)localObject, this.DEB);
            AppMethodBeat.o(216726);
            return;
            localObject = "";
            break;
          }
        }
      }
      AppMethodBeat.o(216726);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(long paramLong1, long paramLong2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(209423);
      Object localObject = k.DDb;
      k.ag(this.DDm, System.currentTimeMillis() - this.DEp);
      localObject = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.hld.a.d.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).eCD();
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.hld.a.b)localObject).c((CharSequence)this.uXe, true);
          AppMethodBeat.o(209423);
          return;
        }
      }
      AppMethodBeat.o(209423);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(216157);
      PunctToScreenEvent localPunctToScreenEvent = new PunctToScreenEvent();
      localPunctToScreenEvent.input = this.uXe;
      Object localObject = n.DEn;
      localPunctToScreenEvent.currentSessionId = n.eFd();
      localObject = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.hld.a.d.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).eCD();
        if (localObject != null)
        {
          com.tencent.mm.plugin.hld.a.e locale = ((com.tencent.mm.plugin.hld.a.b)localObject).Uo(50);
          if (locale != null)
          {
            StringBuilder localStringBuilder = new StringBuilder("reportNoTransEngineStr before:");
            localObject = locale.Dud;
            String str;
            if (localObject != null)
            {
              str = localObject.toString();
              localObject = str;
              if (str != null) {}
            }
            else
            {
              localObject = "";
            }
            localStringBuilder = localStringBuilder.append(Util.secPrint((String)localObject)).append(" after:");
            localObject = locale.Duf;
            if (localObject != null)
            {
              str = localObject.toString();
              localObject = str;
              if (str != null) {}
            }
            else
            {
              localObject = "";
            }
            Log.d("WxIme.WxEngineMgr", Util.secPrint((String)localObject));
            localObject = locale.Dud;
            if (localObject != null)
            {
              str = localObject.toString();
              localObject = str;
              if (str != null) {}
            }
            else
            {
              localObject = "";
            }
            localPunctToScreenEvent.textBeforeCursor = ((String)localObject);
            localObject = locale.Duf;
            if (localObject != null)
            {
              str = localObject.toString();
              localObject = str;
              if (str != null) {}
            }
            else
            {
              localObject = "";
            }
            localPunctToScreenEvent.textAfterCursor = ((String)localObject);
          }
        }
      }
      WxhldApi.report_punct_input_to_screen(localPunctToScreenEvent);
      AppMethodBeat.o(216157);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    public static final m DEC;
    
    static
    {
      AppMethodBeat.i(217512);
      DEC = new m();
      AppMethodBeat.o(217512);
    }
    
    public final void run()
    {
      AppMethodBeat.i(217510);
      Object localObject1 = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.hld.a.d.class);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.hld.a.d)localObject1).eCD();
        if (localObject1 != null)
        {
          Object localObject3 = ((com.tencent.mm.plugin.hld.a.b)localObject1).Uo(50);
          if (localObject3 != null)
          {
            StringBuilder localStringBuilder = new StringBuilder("setTextAroundCursor ");
            localObject1 = ((com.tencent.mm.plugin.hld.a.e)localObject3).Dud;
            if (localObject1 != null)
            {
              localObject2 = localObject1.toString();
              localObject1 = localObject2;
              if (localObject2 != null) {}
            }
            else
            {
              localObject1 = "";
            }
            localStringBuilder = localStringBuilder.append(Util.secPrint((String)localObject1)).append(' ');
            localObject1 = ((com.tencent.mm.plugin.hld.a.e)localObject3).Duf;
            if (localObject1 != null)
            {
              localObject2 = localObject1.toString();
              localObject1 = localObject2;
              if (localObject2 != null) {}
            }
            else
            {
              localObject1 = "";
            }
            Log.d("WxIme.WxEngineMgr", Util.secPrint((String)localObject1));
            localObject1 = n.DEn;
            long l = n.eFd();
            localObject1 = ((com.tencent.mm.plugin.hld.a.e)localObject3).Dud;
            if (localObject1 != null)
            {
              localObject2 = localObject1.toString();
              localObject1 = localObject2;
              if (localObject2 != null) {}
            }
            else
            {
              localObject1 = "";
            }
            Object localObject2 = ((com.tencent.mm.plugin.hld.a.e)localObject3).Duf;
            if (localObject2 != null)
            {
              localObject3 = localObject2.toString();
              localObject2 = localObject3;
              if (localObject3 != null) {}
            }
            else
            {
              localObject2 = "";
            }
            WxhldApi.set_text_around_cursor(l, (String)localObject1, (String)localObject2);
            AppMethodBeat.o(217510);
            return;
          }
          AppMethodBeat.o(217510);
          return;
        }
      }
      AppMethodBeat.o(217510);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.n
 * JD-Core Version:    0.7.0.1
 */