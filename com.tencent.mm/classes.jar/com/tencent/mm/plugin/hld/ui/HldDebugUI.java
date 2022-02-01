package com.tencent.mm.plugin.hld.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.a.m;
import com.tencent.mm.plugin.hld.b.e.a;
import com.tencent.mm.plugin.hld.c.a;
import com.tencent.mm.plugin.hld.f.c;
import com.tencent.mm.plugin.hld.f.g;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.plugin.hld.view.ImeSeekBar;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.dbq;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.UserInfo;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.ao;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/ui/HldDebugUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "formatTimeMillis", "", "timeMillis", "", "getResourceId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "showDictInfo", "updateFaultStatus", "updateStatus", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HldDebugUI
  extends MMPreference
{
  public static final HldDebugUI.a Jxq;
  
  static
  {
    AppMethodBeat.i(312427);
    Jxq = new HldDebugUI.a((byte)0);
    AppMethodBeat.o(312427);
  }
  
  private static final void a(HldDebugUI paramHldDebugUI)
  {
    AppMethodBeat.i(312394);
    s.u(paramHldDebugUI, "this$0");
    Object localObject = com.tencent.mm.plugin.hld.f.l.JyV;
    localObject = com.tencent.mm.plugin.hld.f.l.getKV();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).encode("key_current_cloud_dicts", new dbq().toByteArray());
    }
    localObject = com.tencent.mm.plugin.hld.f.l.JyV;
    localObject = com.tencent.mm.plugin.hld.f.l.getKV();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).encode("key_new_cloud_dicts", new dbq().toByteArray());
    }
    localObject = com.tencent.mm.plugin.hld.f.f.Jyn;
    boolean bool = y.ew(com.tencent.mm.plugin.hld.f.f.fOh(), true);
    localObject = (Context)paramHldDebugUI;
    if (bool) {}
    for (paramHldDebugUI = "字典成功删除";; paramHldDebugUI = "字典删除失败")
    {
      aa.makeText((Context)localObject, (CharSequence)paramHldDebugUI, 0).show();
      AppMethodBeat.o(312394);
      return;
    }
  }
  
  private static final void a(ImeSeekBar paramImeSeekBar)
  {
    AppMethodBeat.i(312401);
    com.tencent.mm.plugin.hld.f.e locale = com.tencent.mm.plugin.hld.f.e.Jym;
    paramImeSeekBar.setInitSeekSize((int)com.tencent.mm.plugin.hld.f.e.fOd());
    AppMethodBeat.o(312401);
  }
  
  private static final void a(ImeSeekBar paramImeSeekBar1, ImeSeekBar paramImeSeekBar2, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(312420);
    if (paramBoolean)
    {
      paramString = com.tencent.mm.plugin.hld.f.e.Jym;
      com.tencent.mm.plugin.hld.f.e.rW(paramImeSeekBar1.getCurrentSeekSize());
      paramImeSeekBar1 = com.tencent.mm.plugin.hld.f.e.Jym;
      com.tencent.mm.plugin.hld.f.e.rX(paramImeSeekBar2.getCurrentSeekSize());
    }
    AppMethodBeat.o(312420);
  }
  
  private static final boolean a(HldDebugUI paramHldDebugUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(312376);
    s.u(paramHldDebugUI, "this$0");
    paramHldDebugUI.finish();
    AppMethodBeat.o(312376);
    return true;
  }
  
  private static final void b(ImeSeekBar paramImeSeekBar)
  {
    AppMethodBeat.i(312412);
    com.tencent.mm.plugin.hld.f.e locale = com.tencent.mm.plugin.hld.f.e.Jym;
    paramImeSeekBar.setInitSeekSize((int)com.tencent.mm.plugin.hld.f.e.fOe());
    AppMethodBeat.o(312412);
  }
  
  private final void fNo()
  {
    AppMethodBeat.i(312326);
    Object localObject = com.tencent.mm.plugin.hld.f.e.Jym;
    if (com.tencent.mm.plugin.hld.f.e.fNQ())
    {
      getPreferenceScreen().eh("enable_fault_exchange", false);
      getPreferenceScreen().eh("enable_fault_insert_at_middle", false);
      getPreferenceScreen().eh("enable_fault_skip", false);
      localObject = getPreferenceScreen().bAi("enable_fault_exchange");
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
        AppMethodBeat.o(312326);
        throw ((Throwable)localObject);
      }
      localObject = (CheckBoxPreference)localObject;
      com.tencent.mm.plugin.hld.f.e locale = com.tencent.mm.plugin.hld.f.e.Jym;
      ((CheckBoxPreference)localObject).setChecked(com.tencent.mm.plugin.hld.f.e.fNR());
      localObject = getPreferenceScreen().bAi("enable_fault_insert_at_middle");
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
        AppMethodBeat.o(312326);
        throw ((Throwable)localObject);
      }
      localObject = (CheckBoxPreference)localObject;
      locale = com.tencent.mm.plugin.hld.f.e.Jym;
      ((CheckBoxPreference)localObject).setChecked(com.tencent.mm.plugin.hld.f.e.fNS());
      localObject = getPreferenceScreen().bAi("enable_fault_skip");
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
        AppMethodBeat.o(312326);
        throw ((Throwable)localObject);
      }
      localObject = (CheckBoxPreference)localObject;
      locale = com.tencent.mm.plugin.hld.f.e.Jym;
      ((CheckBoxPreference)localObject).setChecked(com.tencent.mm.plugin.hld.f.e.fNT());
      AppMethodBeat.o(312326);
      return;
    }
    getPreferenceScreen().eh("enable_fault_exchange", true);
    getPreferenceScreen().eh("enable_fault_insert_at_middle", true);
    getPreferenceScreen().eh("enable_fault_skip", true);
    AppMethodBeat.o(312326);
  }
  
  private final void fNp()
  {
    AppMethodBeat.i(312361);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = am.aixg;
    localObject1 = String.format("[ver  ] %s %08X\n", Arrays.copyOf(new Object[] { ChannelUtil.formatVersion((Context)getContext(), com.tencent.mm.protocal.d.Yxh, true), Integer.valueOf(com.tencent.mm.protocal.d.Yxh) }, 2));
    s.s(localObject1, "java.lang.String.format(format, *args)");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(BuildInfo.info());
    localObject1 = am.aixg;
    localObject1 = com.tencent.mm.loader.i.b.bmt();
    long l;
    if (com.tencent.mm.sdcard_migrate.b.bui(com.tencent.mm.loader.i.b.bmy()))
    {
      i = 1;
      localObject1 = String.format("[storage] %s|%s\n", Arrays.copyOf(new Object[] { localObject1, Integer.valueOf(i) }, 2));
      s.s(localObject1, "java.lang.String.format(format, *args)");
      localStringBuilder.append((String)localObject1);
      localObject1 = am.aixg;
      localObject1 = String.format("[application] %s\n", Arrays.copyOf(new Object[] { getContext().getPackageName() }, 1));
      s.s(localObject1, "java.lang.String.format(format, *args)");
      localStringBuilder.append((String)localObject1);
      localObject1 = am.aixg;
      localObject1 = String.format("[brands] %d %s\n", Arrays.copyOf(new Object[] { Integer.valueOf(WeChatBrands.UserInfo.xagreementId), WeChatBrands.AppInfo.lang }, 2));
      s.s(localObject1, "java.lang.String.format(format, *args)");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("[xw.ver] ").append(ao.getInstalledNewstVersion(MMApplicationContext.getContext())).append("\n");
      localObject1 = com.tencent.mm.plugin.hld.f.l.JyV;
      localObject1 = com.tencent.mm.plugin.hld.f.l.getKV();
      if (localObject1 != null) {
        break label592;
      }
      l = 0L;
      label291:
      localStringBuilder.append(s.X("[ime.lastupdatetime] ", iO(l))).append("\n");
      localObject1 = com.tencent.mm.plugin.hld.f.l.JyV;
      localObject1 = com.tencent.mm.plugin.hld.f.l.getKV();
      if (localObject1 != null) {
        break label605;
      }
      l = 0L;
      label330:
      localStringBuilder.append(s.X("[ime.nextupdatetime] ", iO(l))).append("\n");
      localObject2 = new dbq();
      localObject1 = com.tencent.mm.plugin.hld.f.l.JyV;
      localObject1 = com.tencent.mm.plugin.hld.f.l.getKV();
      if (localObject1 != null)
      {
        localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes("key_current_cloud_dicts");
        if (localObject1 != null)
        {
          ((dbq)localObject2).parseFrom((byte[])localObject1);
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
        }
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
      }
      localObject1 = ah.aiuX;
      localObject4 = new HashMap();
      localObject3 = new HashMap();
      localObject1 = new HashMap();
      localObject2 = ((dbq)localObject2).aaHc.iterator();
      label460:
      if (!((Iterator)localObject2).hasNext()) {
        break label650;
      }
      localObject5 = (dbp)((Iterator)localObject2).next();
      localObject6 = a.JoL;
      s.s(localObject5, "cloudDict");
      localObject6 = a.f((dbp)localObject5);
      if (((dbp)localObject5).aaGX != com.tencent.mm.plugin.hld.model.l.JvM.value) {
        break label618;
      }
      ((Map)localObject4).put(localObject6, localObject5);
    }
    for (;;)
    {
      Log.i("WxIme.HldDebugUI", "currentCloudDictMap init " + ((dbp)localObject5).name + ' ' + ((dbp)localObject5).version + ' ' + ((dbp)localObject5).typeId);
      break label460;
      i = 0;
      break;
      label592:
      l = ((MultiProcessMMKV)localObject1).getLong("ime_get_dict_list_last_time", 0L);
      break label291;
      label605:
      l = ((MultiProcessMMKV)localObject1).getLong("ime_get_dict_list_next_time", 0L);
      break label330;
      label618:
      if (((dbp)localObject5).aaGX == com.tencent.mm.plugin.hld.model.l.JvO.value) {
        ((Map)localObject1).put(localObject6, localObject5);
      }
    }
    label650:
    Object localObject2 = new HashMap();
    Object localObject5 = new dbw();
    Object localObject6 = com.tencent.mm.plugin.hld.f.l.JyV;
    localObject6 = com.tencent.mm.plugin.hld.f.l.fPk();
    if (localObject6 != null)
    {
      localObject6 = ((MultiProcessMMKV)localObject6).decodeBytes("key_current_cloud_dicts");
      if (localObject6 != null)
      {
        ((dbw)localObject5).parseFrom((byte[])localObject6);
        localObject6 = ah.aiuX;
        localObject6 = ah.aiuX;
      }
      localObject6 = ah.aiuX;
      localObject6 = ah.aiuX;
    }
    localObject6 = ah.aiuX;
    localObject6 = ((dbw)localObject5).aaHn.iterator();
    Object localObject7;
    while (((Iterator)localObject6).hasNext())
    {
      localObject7 = (dbt)((Iterator)localObject6).next();
      Map localMap = (Map)localObject2;
      String str = ((dbt)localObject7).aaHk;
      s.s(str, "rawDict.rawDictId");
      s.s(localObject7, "rawDict");
      localMap.put(str, localObject7);
      Log.i("WxIme.HldDebugUI", "currentUserLocalDictMap init " + ((dbt)localObject7).type + ' ' + ((dbt)localObject7).aaHk);
    }
    localObject5 = ((dbw)localObject5).aaHm;
    if (localObject5 != null)
    {
      localObject5 = ((dbq)localObject5).aaHc.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (dbp)((Iterator)localObject5).next();
        localObject7 = a.JoL;
        s.s(localObject6, "cloudDict");
        localObject7 = a.f((dbp)localObject6);
        ((Map)localObject3).put(localObject7, localObject6);
        Log.i("WxIme.HldDebugUI", "currentUserLocalDictMap optionalDicts init " + ((dbp)localObject6).name + ' ' + ((dbp)localObject6).version + ' ' + ((dbp)localObject6).typeId);
      }
      localObject5 = ah.aiuX;
      localObject5 = ah.aiuX;
    }
    localStringBuilder.append("[ime.dict.base]\n");
    Object localObject4 = ((HashMap)localObject4).values();
    s.s(localObject4, "currentBaseCloudDictMap.values");
    localObject4 = ((Collection)localObject4).iterator();
    int i = 0;
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (dbp)((Iterator)localObject4).next();
      localStringBuilder.append(i + 1 + ": " + ((dbp)localObject5).name + ' ' + ((dbp)localObject5).typeId + ' ' + ((dbp)localObject5).aaGX + ' ' + ((dbp)localObject5).version + ' ' + ((dbp)localObject5).md5).append("\n");
      i += 1;
    }
    localStringBuilder.append("[ime.dict.optional]\n");
    Object localObject3 = ((HashMap)localObject3).values();
    s.s(localObject3, "currentOptionalCloudDictMap.values");
    localObject3 = ((Collection)localObject3).iterator();
    i = 0;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (dbp)((Iterator)localObject3).next();
      localStringBuilder.append(i + 1 + ": " + ((dbp)localObject4).name + ' ' + ((dbp)localObject4).typeId + ' ' + ((dbp)localObject4).aaGX + ' ' + ((dbp)localObject4).version + ' ' + ((dbp)localObject4).md5).append("\n");
      i += 1;
    }
    localStringBuilder.append("[ime.dict.common]\n");
    localObject1 = ((HashMap)localObject1).values();
    s.s(localObject1, "currentCommonCloudDictMap.values");
    localObject1 = ((Collection)localObject1).iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (dbp)((Iterator)localObject1).next();
      localStringBuilder.append(i + 1 + ": " + ((dbp)localObject3).name + ' ' + ((dbp)localObject3).typeId + ' ' + ((dbp)localObject3).aaGX + ' ' + ((dbp)localObject3).version + ' ' + ((dbp)localObject3).md5).append("\n");
      i += 1;
    }
    localStringBuilder.append("[ime.dict.mp]\n");
    localObject1 = ((HashMap)localObject2).values();
    s.s(localObject1, "currentUserLocalDictMap.values");
    localObject1 = ((Collection)localObject1).iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (dbt)((Iterator)localObject1).next();
      localStringBuilder.append(i + 1 + ": " + ((dbt)localObject2).type + ' ' + ((dbt)localObject2).aaHk).append("\n");
      i += 1;
    }
    localObject1 = com.tencent.mm.plugin.hld.f.l.JyV;
    localObject1 = com.tencent.mm.plugin.hld.f.l.fPk();
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder.append(s.X("[ime.dict.wx.contact] ", localObject1)).append("\n");
      localObject1 = com.tencent.mm.plugin.hld.f.i.JyA;
      if (!com.tencent.mm.plugin.hld.f.i.fOo()) {
        break label2029;
      }
      localObject1 = Integer.valueOf(0);
    }
    for (;;)
    {
      localStringBuilder.append(s.X("[ime.dict.tele.contact] ", localObject1)).append("\n");
      localObject1 = new StringBuilder("[ime.localdict] ");
      localObject2 = com.tencent.mm.plugin.hld.f.l.JyV;
      localObject2 = com.tencent.mm.plugin.hld.f.l.fOD();
      if (!y.ZC((String)localObject2)) {
        y.bDX((String)localObject2);
      }
      localStringBuilder.append(y.ZC(s.X((String)localObject2, "/local_dict.bin")) + '\n');
      localObject1 = new StringBuilder("[ime.loadlocaldict] ");
      localObject2 = com.tencent.mm.plugin.hld.f.f.Jyn;
      localStringBuilder.append(com.tencent.mm.plugin.hld.f.f.fOj() + '\n');
      localObject1 = new StringBuilder("[ime.loadcontact] ");
      localObject2 = com.tencent.mm.plugin.hld.f.f.Jyn;
      localStringBuilder.append(com.tencent.mm.plugin.hld.f.f.fOk() + '\n');
      localObject1 = new StringBuilder("[ime.engine.version] ");
      localObject2 = n.JvW;
      localStringBuilder.append(n.fMX() + '\n');
      localObject1 = new StringBuilder("[ime.engine.time] ");
      localObject2 = n.JvW;
      localStringBuilder.append(n.fMY() + '\n');
      localObject1 = new TextView((Context)getContext());
      ((TextView)localObject1).setText((CharSequence)localStringBuilder);
      ((TextView)localObject1).setGravity(19);
      ((TextView)localObject1).setTextSize(1, 10.0F);
      ((TextView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      ((TextView)localObject1).setTextColor(getContext().getResources().getColor(a.c.FG_0));
      ((TextView)localObject1).setTypeface(Typeface.MONOSPACE);
      i = getContext().getResources().getDimensionPixelSize(a.d.LargePadding);
      ((TextView)localObject1).setPadding(i, i, i, i);
      k.a((Context)getContext(), null, (View)localObject1, null);
      AppMethodBeat.o(312361);
      return;
      localObject1 = Integer.valueOf(((MultiProcessMMKV)localObject1).getInt("ime_wechat_contact_num", 0));
      break;
      label2029:
      localObject1 = com.tencent.mm.plugin.hld.f.l.JyV;
      localObject1 = com.tencent.mm.plugin.hld.f.l.fPk();
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = Integer.valueOf(((MultiProcessMMKV)localObject1).getInt("ime_telephone_contact_num", 0));
      }
    }
  }
  
  private static final void fNq()
  {
    AppMethodBeat.i(312385);
    com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.JyV;
    com.tencent.mm.plugin.hld.f.l.fPe();
    AppMethodBeat.o(312385);
  }
  
  private static String iO(long paramLong)
  {
    AppMethodBeat.i(312369);
    Object localObject = new Date(paramLong);
    localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format((Date)localObject);
    AppMethodBeat.o(312369);
    return localObject;
  }
  
  public final int getResourceId()
  {
    return a.m.wxime_debug;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(312496);
    super.onCreate(paramBundle);
    setMMTitle("DEBUG");
    setBackBtn(new HldDebugUI..ExternalSyntheticLambda0(this));
    paramBundle = getPreferenceScreen().bAi("enable_fault");
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(312496);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    com.tencent.mm.plugin.hld.f.e locale = com.tencent.mm.plugin.hld.f.e.Jym;
    paramBundle.setChecked(com.tencent.mm.plugin.hld.f.e.fNQ());
    fNo();
    paramBundle = getPreferenceScreen().bAi("enable_fuzzy_syllables");
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(312496);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    locale = com.tencent.mm.plugin.hld.f.e.Jym;
    paramBundle.setChecked(com.tencent.mm.plugin.hld.f.e.fNU());
    getPreferenceScreen().eh("enable_emoji_unicode", true);
    getPreferenceScreen().eh("enable_emoji_config_clear", false);
    getPreferenceScreen().eh("enable_ilink_login", true);
    getPreferenceScreen().eh("clear_active_process", true);
    paramBundle = getPreferenceScreen().bAi("can_print_click_data");
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(312496);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    locale = com.tencent.mm.plugin.hld.f.e.Jym;
    paramBundle.setChecked(com.tencent.mm.plugin.hld.f.e.fNX());
    paramBundle = getPreferenceScreen().bAi("can_print_engine_log");
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(312496);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    locale = com.tencent.mm.plugin.hld.f.e.Jym;
    paramBundle.setChecked(com.tencent.mm.plugin.hld.f.e.fNY());
    paramBundle = getPreferenceScreen().bAi("enable_pre_input");
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(312496);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    locale = com.tencent.mm.plugin.hld.f.e.Jym;
    paramBundle.setChecked(com.tencent.mm.plugin.hld.f.e.fNZ());
    paramBundle = getPreferenceScreen().bAi("enable_selfdraw_keyboard");
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(312496);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    locale = com.tencent.mm.plugin.hld.f.e.Jym;
    paramBundle.setChecked(com.tencent.mm.plugin.hld.f.e.fOa());
    paramBundle = getPreferenceScreen().bAi("enable_move_cursor");
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(312496);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    locale = com.tencent.mm.plugin.hld.f.e.Jym;
    paramBundle.setChecked(com.tencent.mm.plugin.hld.f.e.fOb());
    AppMethodBeat.o(312496);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    boolean bool8 = false;
    boolean bool9 = false;
    boolean bool10 = false;
    boolean bool11 = false;
    boolean bool12 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool1 = false;
    AppMethodBeat.i(312537);
    s.u(paramf, "screen");
    s.u(paramPreference, "pref");
    Log.i("WxIme.HldDebugUI", s.X("onPreferenceTreeClick ", paramPreference.mKey));
    paramf = paramPreference.mKey;
    if (paramf != null) {}
    switch (paramf.hashCode())
    {
    default: 
    case 1963567949: 
    case -912851086: 
    case 1441853653: 
    case -1424537775: 
    case 636892639: 
    case 1236253026: 
    case 1167464888: 
    case -1105959686: 
    case -1751290163: 
    case -1726776062: 
    case 867930728: 
    case 64699375: 
    case 819862248: 
    case 1218342600: 
      label360:
      do
      {
        for (;;)
        {
          getPreferenceScreen().notifyDataSetChanged();
          AppMethodBeat.o(312537);
          return true;
          if (paramf.equals("refresh_contact_data"))
          {
            paramf = c.Jyj;
            aa.makeText((Context)this, (CharSequence)"成功触发更刷新联系人信息(通讯录+好友)", 0).show();
            continue;
            if (paramf.equals("enable_pre_input"))
            {
              paramPreference = (Context)this;
              paramf = com.tencent.mm.plugin.hld.f.e.Jym;
              if (!com.tencent.mm.plugin.hld.f.e.fNZ()) {
                break label2183;
              }
              paramf = "预处理已关闭";
              aa.makeText(paramPreference, (CharSequence)paramf, 0).show();
              paramf = com.tencent.mm.plugin.hld.f.e.Jym;
              paramf = com.tencent.mm.plugin.hld.f.e.Jym;
              if (!com.tencent.mm.plugin.hld.f.e.fNZ()) {
                bool1 = true;
              }
              com.tencent.mm.plugin.hld.f.e.xl(bool1);
              continue;
              if (paramf.equals("show_dict_info"))
              {
                fNp();
                continue;
                if (paramf.equals("enable_ilink_login"))
                {
                  paramf = com.tencent.mm.plugin.hld.f.e.Jym;
                  paramf = com.tencent.mm.plugin.hld.f.e.Jym;
                  bool1 = bool8;
                  if (!com.tencent.mm.plugin.hld.f.e.fNW()) {
                    bool1 = true;
                  }
                  com.tencent.mm.plugin.hld.f.e.xi(bool1);
                  continue;
                  if (paramf.equals("op_req_three"))
                  {
                    long l = cn.bDx();
                    paramf = com.tencent.mm.plugin.hld.b.e.JoK;
                    e.a.a(com.tencent.mm.plugin.hld.model.b.Jul, 0L, null, 6);
                    paramf = com.tencent.mm.plugin.hld.b.e.JoK;
                    e.a.a(com.tencent.mm.plugin.hld.model.b.Juk, 0L, null, 6);
                    paramf = com.tencent.mm.plugin.hld.b.e.JoK;
                    e.a.a(com.tencent.mm.plugin.hld.model.b.Jus, l - 20L, null, 4);
                    continue;
                    if (paramf.equals("can_print_click_data"))
                    {
                      paramPreference = (Context)this;
                      paramf = com.tencent.mm.plugin.hld.f.e.Jym;
                      if (!com.tencent.mm.plugin.hld.f.e.fNX()) {
                        break label2169;
                      }
                      paramf = "打印敲击数据已关闭";
                      aa.makeText(paramPreference, (CharSequence)paramf, 0).show();
                      paramf = com.tencent.mm.plugin.hld.f.e.Jym;
                      paramf = com.tencent.mm.plugin.hld.f.e.Jym;
                      bool1 = bool9;
                      if (!com.tencent.mm.plugin.hld.f.e.fNX()) {
                        bool1 = true;
                      }
                      com.tencent.mm.plugin.hld.f.e.xj(bool1);
                      continue;
                      if (paramf.equals("enable_fault_skip"))
                      {
                        paramf = getPreferenceScreen().bAi("enable_fault_skip");
                        if (paramf != null) {
                          break;
                        }
                        paramf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
                        AppMethodBeat.o(312537);
                        throw paramf;
                        if (paramf.equals("enable_selfdraw_keyboard"))
                        {
                          paramPreference = (Context)this;
                          paramf = com.tencent.mm.plugin.hld.f.e.Jym;
                          if (!com.tencent.mm.plugin.hld.f.e.fOa()) {
                            break label2190;
                          }
                          paramf = "自绘键盘已关闭";
                          aa.makeText(paramPreference, (CharSequence)paramf, 0).show();
                          paramf = com.tencent.mm.plugin.hld.f.e.Jym;
                          paramf = com.tencent.mm.plugin.hld.f.e.Jym;
                          bool1 = bool10;
                          if (!com.tencent.mm.plugin.hld.f.e.fOa()) {
                            bool1 = true;
                          }
                          com.tencent.mm.plugin.hld.f.e.xm(bool1);
                          continue;
                          if (paramf.equals("op_req_two"))
                          {
                            l = cn.bDx();
                            paramf = com.tencent.mm.plugin.hld.b.e.JoK;
                            e.a.a(com.tencent.mm.plugin.hld.model.b.Jul, 0L, null, 6);
                            paramf = com.tencent.mm.plugin.hld.b.e.JoK;
                            e.a.a(com.tencent.mm.plugin.hld.model.b.Juk, 0L, null, 6);
                            paramf = com.tencent.mm.plugin.hld.b.e.JoK;
                            e.a.a(com.tencent.mm.plugin.hld.model.b.Jum, l - 20L, null, 4);
                            continue;
                            if (paramf.equals("enable_fuzzy_syllables"))
                            {
                              paramf = getPreferenceScreen().bAi("enable_fuzzy_syllables");
                              if (paramf != null) {
                                break label2053;
                              }
                              paramf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
                              AppMethodBeat.o(312537);
                              throw paramf;
                              if (paramf.equals("clear_active_process"))
                              {
                                paramf = com.tencent.mm.plugin.hld.f.l.JyV;
                                paramf = com.tencent.mm.plugin.hld.f.l.fPk();
                                if (paramf != null) {
                                  paramf.putBoolean("ime_active_first_process_privacy_info", false);
                                }
                                paramf = com.tencent.mm.plugin.hld.f.l.fPl();
                                if (paramf != null) {
                                  paramf.putBoolean("ime_active_first_process_privacy_info", false);
                                }
                                paramf = com.tencent.mm.plugin.hld.f.l.fPk();
                                if (paramf != null) {
                                  paramf.putBoolean("ime_active_second_process_collect_data", false);
                                }
                                paramf = com.tencent.mm.plugin.hld.f.l.fPl();
                                if (paramf != null) {
                                  paramf.putBoolean("ime_active_second_process_collect_data", false);
                                }
                                paramf = com.tencent.mm.plugin.hld.f.l.fPk();
                                if (paramf != null) {
                                  paramf.putBoolean("ime_active_fifth_process_choose_keyboard", false);
                                }
                                paramf = com.tencent.mm.plugin.hld.f.l.fPl();
                                if (paramf != null) {
                                  paramf.putBoolean("ime_active_fifth_process_choose_keyboard", false);
                                }
                                paramf = com.tencent.mm.plugin.hld.f.l.fPk();
                                if (paramf != null) {
                                  paramf.putBoolean("ime_local_user_dict_generator_finish", false);
                                }
                                paramf = com.tencent.mm.plugin.hld.f.l.fPl();
                                if (paramf != null) {
                                  paramf.putBoolean("ime_local_user_dict_generator_finish", false);
                                }
                                paramf = com.tencent.mm.plugin.hld.f.l.fPk();
                                if (paramf != null) {
                                  paramf.putBoolean("ime_local_user_dict_load_finish", false);
                                }
                                paramf = com.tencent.mm.plugin.hld.f.l.fPl();
                                if (paramf != null) {
                                  paramf.putBoolean("ime_local_user_dict_load_finish", false);
                                }
                                paramf = com.tencent.mm.plugin.hld.f.l.fPk();
                                if (paramf != null) {
                                  paramf.putBoolean("ime_phone_contact_data_load_finish", false);
                                }
                                paramf = com.tencent.mm.plugin.hld.f.l.fPl();
                                if (paramf != null) {
                                  paramf.putBoolean("ime_phone_contact_data_load_finish", false);
                                }
                                paramf = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
                                if (paramf != null)
                                {
                                  paramf = paramf.fKG();
                                  if (paramf != null) {
                                    paramf.fKw();
                                  }
                                }
                                aa.makeText((Context)this, (CharSequence)"成功重置激活流程", 0).show();
                                continue;
                                if (paramf.equals("force_fetch_dict"))
                                {
                                  paramf = com.tencent.mm.plugin.hld.f.l.JyV;
                                  com.tencent.mm.plugin.hld.f.l.fPe();
                                  paramf = com.tencent.mm.plugin.hld.f.l.JyV;
                                  paramf = com.tencent.mm.plugin.hld.f.l.getKV();
                                  if (paramf != null) {
                                    paramf.putLong("ime_get_dict_list_next_time", 0L);
                                  }
                                  paramf = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
                                  if (paramf != null) {
                                    paramf.fKE();
                                  }
                                  aa.makeText((Context)this, (CharSequence)"成功触发更新Dict", 0).show();
                                  continue;
                                  if (paramf.equals("config_delete_key"))
                                  {
                                    paramf = View.inflate((Context)getContext(), a.h.ime_debug_config_delete_key, null);
                                    paramPreference = (ImeSeekBar)paramf.findViewById(a.f.repeat_inter_time_seek_bar);
                                    paramPreference.setMinSize(10);
                                    paramPreference.setTotalSize(300);
                                    paramPreference.post(new HldDebugUI..ExternalSyntheticLambda4(paramPreference));
                                    ImeSeekBar localImeSeekBar = (ImeSeekBar)paramf.findViewById(a.f.repeat_delay_time_seek_bar);
                                    localImeSeekBar.setMinSize(50);
                                    localImeSeekBar.setTotalSize(500);
                                    localImeSeekBar.post(new HldDebugUI..ExternalSyntheticLambda3(localImeSeekBar));
                                    g.a locala = new g.a((Context)getContext());
                                    locala.bf((CharSequence)getString(a.j.ime_debug_config_delete_key)).mg(paramf);
                                    locala.c(new HldDebugUI..ExternalSyntheticLambda1(paramPreference, localImeSeekBar)).show();
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      } while (!paramf.equals("enable_move_cursor"));
      label541:
      paramPreference = (Context)this;
      label651:
      paramf = com.tencent.mm.plugin.hld.f.e.Jym;
      if (!com.tencent.mm.plugin.hld.f.e.fOb()) {
        break;
      }
    }
    for (paramf = "移动光标已关闭";; paramf = "移动光标已开启")
    {
      aa.makeText(paramPreference, (CharSequence)paramf, 0).show();
      paramf = com.tencent.mm.plugin.hld.f.e.Jym;
      paramf = com.tencent.mm.plugin.hld.f.e.Jym;
      bool1 = bool11;
      if (!com.tencent.mm.plugin.hld.f.e.fOb()) {
        bool1 = true;
      }
      com.tencent.mm.plugin.hld.f.e.xn(bool1);
      break;
      if (!paramf.equals("enable_emoji_config_clear")) {
        break;
      }
      paramf = g.Jyo;
      g.clear("emoji");
      g.clear("kaoemoji");
      g.jA("emoji", "emotion");
      g.jA("kaoemoji", "happy");
      com.tencent.threadpool.h.ahAA.p(HldDebugUI..ExternalSyntheticLambda5.INSTANCE, 500L);
      AppMethodBeat.o(312537);
      return true;
      if (!paramf.equals("can_print_engine_log")) {
        break;
      }
      paramPreference = (Context)this;
      paramf = com.tencent.mm.plugin.hld.f.e.Jym;
      if (com.tencent.mm.plugin.hld.f.e.fNX()) {}
      for (paramf = "打印Engine日志已关闭";; paramf = "打印Engine日志已开启")
      {
        aa.makeText(paramPreference, (CharSequence)s.X(paramf, ", 重启输入法生效"), 0).show();
        paramf = com.tencent.mm.plugin.hld.f.e.Jym;
        paramf = com.tencent.mm.plugin.hld.f.e.Jym;
        bool1 = bool12;
        if (!com.tencent.mm.plugin.hld.f.e.fNY()) {
          bool1 = true;
        }
        com.tencent.mm.plugin.hld.f.e.xk(bool1);
        break;
        if (!paramf.equals("again_generate_user_dict")) {
          break;
        }
        aa.makeText((Context)getContext(), (CharSequence)"暂不支持该功能，请等待更新~", 1).show();
        break;
        if (!paramf.equals("enable_emoji_unicode")) {
          break;
        }
        paramf = getPreferenceScreen().bAi("enable_emoji_unicode");
        if (paramf == null)
        {
          paramf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
          AppMethodBeat.o(312537);
          throw paramf;
          if (!paramf.equals("op_req_one")) {
            break;
          }
          paramf = com.tencent.mm.plugin.hld.b.e.JoK;
          e.a.a(com.tencent.mm.plugin.hld.model.b.Jul, 0L, null, 6);
          paramf = com.tencent.mm.plugin.hld.b.e.JoK;
          e.a.a(com.tencent.mm.plugin.hld.model.b.Juk, 0L, null, 6);
          paramf = com.tencent.mm.plugin.hld.b.e.JoK;
          e.a.a(com.tencent.mm.plugin.hld.model.b.Juo, 0L, null, 6);
          break;
          if (!paramf.equals("enable_fault")) {
            break;
          }
          paramf = getPreferenceScreen().bAi("enable_fault");
          if (paramf == null)
          {
            paramf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(312537);
            throw paramf;
            if (!paramf.equals("delete_dict_data")) {
              break;
            }
            paramf = com.tencent.mm.plugin.hld.f.l.JyV;
            com.tencent.mm.plugin.hld.f.l.fPe();
            com.tencent.threadpool.h.ahAA.o(new HldDebugUI..ExternalSyntheticLambda2(this), 500L);
            break;
            if (!paramf.equals("enable_fault_insert_at_middle")) {
              break;
            }
            paramf = getPreferenceScreen().bAi("enable_fault_insert_at_middle");
            if (paramf != null) {
              break label1937;
            }
            paramf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(312537);
            throw paramf;
            if (!paramf.equals("enable_fault_exchange")) {
              break;
            }
            paramf = getPreferenceScreen().bAi("enable_fault_exchange");
            if (paramf != null) {
              break label1879;
            }
            paramf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(312537);
            throw paramf;
          }
          paramf = (CheckBoxPreference)paramf;
          paramPreference = com.tencent.mm.plugin.hld.f.e.Jym;
          if (!com.tencent.mm.plugin.hld.f.e.fNQ()) {}
          for (bool1 = true;; bool1 = false)
          {
            paramf.setChecked(bool1);
            paramf = com.tencent.mm.plugin.hld.f.e.Jym;
            paramf = com.tencent.mm.plugin.hld.f.e.Jym;
            bool1 = bool2;
            if (!com.tencent.mm.plugin.hld.f.e.fNQ()) {
              bool1 = true;
            }
            com.tencent.mm.plugin.hld.f.e.xc(bool1);
            fNo();
            AppMethodBeat.o(312537);
            return true;
          }
          label1879:
          paramf = (CheckBoxPreference)paramf;
          paramPreference = com.tencent.mm.plugin.hld.f.e.Jym;
          if (!com.tencent.mm.plugin.hld.f.e.fNR()) {}
          for (bool1 = true;; bool1 = false)
          {
            paramf.setChecked(bool1);
            paramf = com.tencent.mm.plugin.hld.f.e.Jym;
            paramf = com.tencent.mm.plugin.hld.f.e.Jym;
            bool1 = bool3;
            if (!com.tencent.mm.plugin.hld.f.e.fNR()) {
              bool1 = true;
            }
            com.tencent.mm.plugin.hld.f.e.xd(bool1);
            AppMethodBeat.o(312537);
            return true;
          }
          label1937:
          paramf = (CheckBoxPreference)paramf;
          paramPreference = com.tencent.mm.plugin.hld.f.e.Jym;
          if (!com.tencent.mm.plugin.hld.f.e.fNS()) {}
          for (bool1 = true;; bool1 = false)
          {
            paramf.setChecked(bool1);
            paramf = com.tencent.mm.plugin.hld.f.e.Jym;
            paramf = com.tencent.mm.plugin.hld.f.e.Jym;
            bool1 = bool4;
            if (!com.tencent.mm.plugin.hld.f.e.fNS()) {
              bool1 = true;
            }
            com.tencent.mm.plugin.hld.f.e.xe(bool1);
            AppMethodBeat.o(312537);
            return true;
          }
          paramf = (CheckBoxPreference)paramf;
          paramPreference = com.tencent.mm.plugin.hld.f.e.Jym;
          if (!com.tencent.mm.plugin.hld.f.e.fNT()) {}
          for (bool1 = true;; bool1 = false)
          {
            paramf.setChecked(bool1);
            paramf = com.tencent.mm.plugin.hld.f.e.Jym;
            paramf = com.tencent.mm.plugin.hld.f.e.Jym;
            bool1 = bool5;
            if (!com.tencent.mm.plugin.hld.f.e.fNT()) {
              bool1 = true;
            }
            com.tencent.mm.plugin.hld.f.e.xf(bool1);
            AppMethodBeat.o(312537);
            return true;
          }
          label2053:
          paramf = (CheckBoxPreference)paramf;
          paramPreference = com.tencent.mm.plugin.hld.f.e.Jym;
          if (!com.tencent.mm.plugin.hld.f.e.fNU()) {}
          for (bool1 = true;; bool1 = false)
          {
            paramf.setChecked(bool1);
            paramf = com.tencent.mm.plugin.hld.f.e.Jym;
            paramf = com.tencent.mm.plugin.hld.f.e.Jym;
            bool1 = bool6;
            if (!com.tencent.mm.plugin.hld.f.e.fNU()) {
              bool1 = true;
            }
            com.tencent.mm.plugin.hld.f.e.xg(bool1);
            AppMethodBeat.o(312537);
            return true;
          }
        }
        paramf = (CheckBoxPreference)paramf;
        paramPreference = com.tencent.mm.plugin.hld.f.e.Jym;
        if (!com.tencent.mm.plugin.hld.f.e.fNV()) {}
        for (bool1 = true;; bool1 = false)
        {
          paramf.setChecked(bool1);
          paramf = com.tencent.mm.plugin.hld.f.e.Jym;
          paramf = com.tencent.mm.plugin.hld.f.e.Jym;
          bool1 = bool7;
          if (!com.tencent.mm.plugin.hld.f.e.fNV()) {
            bool1 = true;
          }
          com.tencent.mm.plugin.hld.f.e.xh(bool1);
          AppMethodBeat.o(312537);
          return true;
        }
        label2169:
        paramf = "打印敲击数据已开启";
        break label541;
      }
      label2183:
      paramf = "预处理已开启";
      break label360;
      label2190:
      paramf = "自绘键盘已开启";
      break label651;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.HldDebugUI
 * JD-Core Version:    0.7.0.1
 */