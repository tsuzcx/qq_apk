package com.tencent.mm.plugin.hld.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
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
import com.tencent.mm.protocal.protobuf.clh;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.cll;
import com.tencent.mm.protocal.protobuf.clo;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.UserInfo;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.u;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.t;
import org.xwalk.core.XWalkEnvironment;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/HldDebugUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "formatTimeMillis", "", "timeMillis", "", "getResourceId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "showDictInfo", "updateFaultStatus", "updateStatus", "Companion", "plugin-hld_release"})
public final class HldDebugUI
  extends MMPreference
{
  public static final a DFJ;
  
  static
  {
    AppMethodBeat.i(209894);
    DFJ = new a((byte)0);
    AppMethodBeat.o(209894);
  }
  
  private static String GD(long paramLong)
  {
    AppMethodBeat.i(209891);
    Object localObject = new Date(paramLong);
    localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format((Date)localObject);
    AppMethodBeat.o(209891);
    return localObject;
  }
  
  private final void eFw()
  {
    AppMethodBeat.i(209882);
    Object localObject = com.tencent.mm.plugin.hld.f.e.DGW;
    getPreferenceScreen().dz("enable_fault_exchange", false);
    getPreferenceScreen().dz("enable_fault_insert_at_middle", false);
    getPreferenceScreen().dz("enable_fault_skip", false);
    localObject = getPreferenceScreen().byG("enable_fault_exchange");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(209882);
      throw ((Throwable)localObject);
    }
    localObject = (CheckBoxPreference)localObject;
    com.tencent.mm.plugin.hld.f.e locale = com.tencent.mm.plugin.hld.f.e.DGW;
    ((CheckBoxPreference)localObject).setChecked(true);
    localObject = getPreferenceScreen().byG("enable_fault_insert_at_middle");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(209882);
      throw ((Throwable)localObject);
    }
    localObject = (CheckBoxPreference)localObject;
    locale = com.tencent.mm.plugin.hld.f.e.DGW;
    ((CheckBoxPreference)localObject).setChecked(true);
    localObject = getPreferenceScreen().byG("enable_fault_skip");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(209882);
      throw ((Throwable)localObject);
    }
    localObject = (CheckBoxPreference)localObject;
    locale = com.tencent.mm.plugin.hld.f.e.DGW;
    ((CheckBoxPreference)localObject).setChecked(false);
    AppMethodBeat.o(209882);
  }
  
  private final void eFx()
  {
    AppMethodBeat.i(209889);
    Object localObject2 = new StringBuilder();
    Object localObject1 = af.aaBG;
    localObject1 = String.format("[ver  ] %s %08X\n", Arrays.copyOf(new Object[] { ChannelUtil.formatVersion((Context)getContext(), com.tencent.mm.protocal.d.RAD, true), Integer.valueOf(com.tencent.mm.protocal.d.RAD) }, 2));
    p.j(localObject1, "java.lang.String.format(format, *args)");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(BuildInfo.info());
    localObject1 = af.aaBG;
    localObject1 = com.tencent.mm.loader.j.b.aSF();
    long l;
    if (com.tencent.mm.sdcard_migrate.b.buj(com.tencent.mm.loader.j.b.aSK()))
    {
      i = 1;
      localObject1 = String.format("[storage] %s|%s\n", Arrays.copyOf(new Object[] { localObject1, Integer.valueOf(i) }, 2));
      p.j(localObject1, "java.lang.String.format(format, *args)");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = af.aaBG;
      localObject1 = getContext();
      p.j(localObject1, "getContext()");
      localObject1 = String.format("[application] %s\n", Arrays.copyOf(new Object[] { ((AppCompatActivity)localObject1).getPackageName() }, 1));
      p.j(localObject1, "java.lang.String.format(format, *args)");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = af.aaBG;
      localObject1 = String.format("[brands] %d %s\n", Arrays.copyOf(new Object[] { Integer.valueOf(WeChatBrands.UserInfo.xagreementId), WeChatBrands.AppInfo.lang }, 2));
      p.j(localObject1, "java.lang.String.format(format, *args)");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("[xw.ver] ").append(XWalkEnvironment.getInstalledNewstVersion(MMApplicationContext.getContext())).append("\n");
      localObject1 = new StringBuilder("[ime.lastupdatetime] ");
      localObject3 = com.tencent.mm.plugin.hld.f.l.DHK;
      localObject3 = com.tencent.mm.plugin.hld.f.l.getKV();
      if (localObject3 == null) {
        break label610;
      }
      l = ((MultiProcessMMKV)localObject3).getLong("ime_get_dict_list_last_time", 0L);
      label311:
      ((StringBuilder)localObject2).append(GD(l)).append("\n");
      localObject1 = new StringBuilder("[ime.nextupdatetime] ");
      localObject3 = com.tencent.mm.plugin.hld.f.l.DHK;
      localObject3 = com.tencent.mm.plugin.hld.f.l.getKV();
      if (localObject3 == null) {
        break label615;
      }
      l = ((MultiProcessMMKV)localObject3).getLong("ime_get_dict_list_next_time", 0L);
      label371:
      ((StringBuilder)localObject2).append(GD(l)).append("\n");
      localObject3 = new cli();
      localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      localObject1 = com.tencent.mm.plugin.hld.f.l.getKV();
      if (localObject1 != null)
      {
        localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes("key_current_cloud_dicts");
        if (localObject1 != null) {
          ((cli)localObject3).parseFrom((byte[])localObject1);
        }
      }
      localObject5 = new HashMap();
      localObject4 = new HashMap();
      localObject1 = new HashMap();
      localObject3 = ((cli)localObject3).TsR.iterator();
      label478:
      if (!((Iterator)localObject3).hasNext()) {
        break label652;
      }
      localObject6 = (clh)((Iterator)localObject3).next();
      localObject7 = a.DvH;
      p.j(localObject6, "cloudDict");
      localObject7 = a.c((clh)localObject6);
      if (((clh)localObject6).TsM != com.tencent.mm.plugin.hld.model.l.DDO.value) {
        break label620;
      }
      ((Map)localObject5).put(localObject7, localObject6);
    }
    for (;;)
    {
      Log.i("WxIme.HldDebugUI", "currentCloudDictMap init " + ((clh)localObject6).name + ' ' + ((clh)localObject6).version + ' ' + ((clh)localObject6).ddx);
      break label478;
      i = 0;
      break;
      label610:
      l = 0L;
      break label311;
      label615:
      l = 0L;
      break label371;
      label620:
      if (((clh)localObject6).TsM == com.tencent.mm.plugin.hld.model.l.DDQ.value) {
        ((Map)localObject1).put(localObject7, localObject6);
      }
    }
    label652:
    Object localObject3 = new HashMap();
    Object localObject6 = new clo();
    Object localObject7 = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject7 = com.tencent.mm.plugin.hld.f.l.eHB();
    if (localObject7 != null)
    {
      localObject7 = ((MultiProcessMMKV)localObject7).decodeBytes("key_current_cloud_dicts");
      if (localObject7 != null) {
        ((clo)localObject6).parseFrom((byte[])localObject7);
      }
    }
    localObject7 = ((clo)localObject6).Ttc.iterator();
    Object localObject8;
    while (((Iterator)localObject7).hasNext())
    {
      localObject8 = (cll)((Iterator)localObject7).next();
      Map localMap = (Map)localObject3;
      String str = ((cll)localObject8).TsZ;
      p.j(str, "rawDict.rawDictId");
      p.j(localObject8, "rawDict");
      localMap.put(str, localObject8);
      Log.i("WxIme.HldDebugUI", "currentUserLocalDictMap init " + ((cll)localObject8).type + ' ' + ((cll)localObject8).TsZ);
    }
    localObject6 = ((clo)localObject6).Ttb;
    if (localObject6 != null)
    {
      localObject6 = ((cli)localObject6).TsR.iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (clh)((Iterator)localObject6).next();
        localObject8 = a.DvH;
        p.j(localObject7, "cloudDict");
        localObject8 = a.c((clh)localObject7);
        ((Map)localObject4).put(localObject8, localObject7);
        Log.i("WxIme.HldDebugUI", "currentUserLocalDictMap optionalDicts init " + ((clh)localObject7).name + ' ' + ((clh)localObject7).version + ' ' + ((clh)localObject7).ddx);
      }
    }
    ((StringBuilder)localObject2).append("[ime.dict.base]\n");
    Object localObject5 = ((HashMap)localObject5).values();
    p.j(localObject5, "currentBaseCloudDictMap.values");
    localObject5 = ((Iterable)localObject5).iterator();
    int i = 0;
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = (clh)((Iterator)localObject5).next();
      ((StringBuilder)localObject2).append(i + 1 + ": " + ((clh)localObject6).name + ' ' + ((clh)localObject6).ddx + ' ' + ((clh)localObject6).TsM + ' ' + ((clh)localObject6).version + ' ' + ((clh)localObject6).md5).append("\n");
      i += 1;
    }
    ((StringBuilder)localObject2).append("[ime.dict.optional]\n");
    Object localObject4 = ((HashMap)localObject4).values();
    p.j(localObject4, "currentOptionalCloudDictMap.values");
    localObject4 = ((Iterable)localObject4).iterator();
    i = 0;
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (clh)((Iterator)localObject4).next();
      ((StringBuilder)localObject2).append(i + 1 + ": " + ((clh)localObject5).name + ' ' + ((clh)localObject5).ddx + ' ' + ((clh)localObject5).TsM + ' ' + ((clh)localObject5).version + ' ' + ((clh)localObject5).md5).append("\n");
      i += 1;
    }
    ((StringBuilder)localObject2).append("[ime.dict.common]\n");
    localObject1 = ((HashMap)localObject1).values();
    p.j(localObject1, "currentCommonCloudDictMap.values");
    localObject1 = ((Iterable)localObject1).iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (clh)((Iterator)localObject1).next();
      ((StringBuilder)localObject2).append(i + 1 + ": " + ((clh)localObject4).name + ' ' + ((clh)localObject4).ddx + ' ' + ((clh)localObject4).TsM + ' ' + ((clh)localObject4).version + ' ' + ((clh)localObject4).md5).append("\n");
      i += 1;
    }
    ((StringBuilder)localObject2).append("[ime.dict.mp]\n");
    localObject1 = ((HashMap)localObject3).values();
    p.j(localObject1, "currentUserLocalDictMap.values");
    localObject1 = ((Iterable)localObject1).iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (cll)((Iterator)localObject1).next();
      ((StringBuilder)localObject2).append(i + 1 + ": " + ((cll)localObject3).type + ' ' + ((cll)localObject3).TsZ).append("\n");
      i += 1;
    }
    localObject3 = new StringBuilder("[ime.dict.wx.contact] ");
    localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject1 = com.tencent.mm.plugin.hld.f.l.eHB();
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((MultiProcessMMKV)localObject1).getInt("ime_wechat_contact_num", 0));
      ((StringBuilder)localObject2).append(localObject1).append("\n");
      localObject3 = new StringBuilder("[ime.dict.tele.contact] ");
      localObject1 = com.tencent.mm.plugin.hld.f.i.DHq;
      if (!com.tencent.mm.plugin.hld.f.i.eGC()) {
        break label2054;
      }
      localObject1 = Integer.valueOf(0);
    }
    for (;;)
    {
      ((StringBuilder)localObject2).append(localObject1).append("\n");
      localObject1 = new StringBuilder("[ime.localdict] ");
      localObject3 = com.tencent.mm.plugin.hld.f.l.DHK;
      localObject3 = com.tencent.mm.plugin.hld.f.l.eGV();
      if (!u.agG((String)localObject3)) {
        u.bBD((String)localObject3);
      }
      ((StringBuilder)localObject2).append(u.agG(p.I((String)localObject3, "/local_dict.bin")) + '\n');
      localObject1 = new StringBuilder("[ime.loadlocaldict] ");
      localObject3 = com.tencent.mm.plugin.hld.f.f.DGX;
      ((StringBuilder)localObject2).append(com.tencent.mm.plugin.hld.f.f.eGv() + '\n');
      localObject1 = new StringBuilder("[ime.loadcontact] ");
      localObject3 = com.tencent.mm.plugin.hld.f.f.DGX;
      ((StringBuilder)localObject2).append(com.tencent.mm.plugin.hld.f.f.eGw() + '\n');
      localObject1 = new StringBuilder("[ime.engine.version] ");
      localObject3 = n.DEn;
      ((StringBuilder)localObject2).append(n.eEU() + '\n');
      localObject1 = new StringBuilder("[ime.engine.time] ");
      localObject3 = n.DEn;
      ((StringBuilder)localObject2).append(n.eEV() + '\n');
      localObject1 = new TextView((Context)getContext());
      ((TextView)localObject1).setText((CharSequence)localObject2);
      ((TextView)localObject1).setGravity(19);
      ((TextView)localObject1).setTextSize(1, 10.0F);
      ((TextView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      localObject2 = getContext();
      p.j(localObject2, "getContext()");
      ((TextView)localObject1).setTextColor(((AppCompatActivity)localObject2).getResources().getColor(a.c.FG_0));
      ((TextView)localObject1).setTypeface(Typeface.MONOSPACE);
      localObject2 = getContext();
      p.j(localObject2, "context");
      i = ((AppCompatActivity)localObject2).getResources().getDimensionPixelSize(a.d.LargePadding);
      ((TextView)localObject1).setPadding(i, i, i, i);
      com.tencent.mm.ui.base.h.a((Context)getContext(), null, (View)localObject1, null);
      AppMethodBeat.o(209889);
      return;
      localObject1 = null;
      break;
      label2054:
      localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      localObject1 = com.tencent.mm.plugin.hld.f.l.eHB();
      if (localObject1 != null) {
        localObject1 = Integer.valueOf(((MultiProcessMMKV)localObject1).getInt("ime_telephone_contact_num", 0));
      } else {
        localObject1 = null;
      }
    }
  }
  
  public final int getResourceId()
  {
    return a.m.wxime_debug;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(209881);
    super.onCreate(paramBundle);
    setMMTitle("DEBUG");
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    paramBundle = getPreferenceScreen().byG("enable_fault");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(209881);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    com.tencent.mm.plugin.hld.f.e locale = com.tencent.mm.plugin.hld.f.e.DGW;
    paramBundle.setChecked(true);
    eFw();
    paramBundle = getPreferenceScreen().byG("enable_fuzzy_syllables");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(209881);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    locale = com.tencent.mm.plugin.hld.f.e.DGW;
    paramBundle.setChecked(false);
    getPreferenceScreen().dz("enable_emoji_unicode", true);
    getPreferenceScreen().dz("enable_emoji_config_clear", false);
    getPreferenceScreen().dz("enable_ilink_login", true);
    getPreferenceScreen().dz("clear_active_process", true);
    paramBundle = getPreferenceScreen().byG("can_print_click_data");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(209881);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    locale = com.tencent.mm.plugin.hld.f.e.DGW;
    paramBundle.setChecked(com.tencent.mm.plugin.hld.f.e.eGl());
    paramBundle = getPreferenceScreen().byG("can_print_engine_log");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(209881);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    locale = com.tencent.mm.plugin.hld.f.e.DGW;
    paramBundle.setChecked(com.tencent.mm.plugin.hld.f.e.eGm());
    paramBundle = getPreferenceScreen().byG("enable_pre_input");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(209881);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    locale = com.tencent.mm.plugin.hld.f.e.DGW;
    paramBundle.setChecked(com.tencent.mm.plugin.hld.f.e.eGn());
    paramBundle = getPreferenceScreen().byG("enable_selfdraw_keyboard");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(209881);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    locale = com.tencent.mm.plugin.hld.f.e.DGW;
    paramBundle.setChecked(com.tencent.mm.plugin.hld.f.e.eGo());
    paramBundle = getPreferenceScreen().byG("enable_move_cursor");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(209881);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    locale = com.tencent.mm.plugin.hld.f.e.DGW;
    paramBundle.setChecked(com.tencent.mm.plugin.hld.f.e.eGp());
    AppMethodBeat.o(209881);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    AppMethodBeat.i(209888);
    p.k(paramf, "screen");
    p.k(paramPreference, "pref");
    Log.i("WxIme.HldDebugUI", "onPreferenceTreeClick " + paramPreference.getKey());
    paramf = paramPreference.getKey();
    if (paramf == null) {}
    label382:
    Object localObject;
    label551:
    label579:
    do
    {
      for (;;)
      {
        getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(209888);
        return true;
        long l;
        switch (paramf.hashCode())
        {
        default: 
          break;
        case -2008639329: 
          if (paramf.equals("again_generate_user_dict")) {
            w.makeText((Context)getContext(), (CharSequence)"暂不支持该功能，请等待更新~", 1).show();
          }
          break;
        case 1963567949: 
          if (paramf.equals("refresh_contact_data"))
          {
            paramf = c.DGO;
            c.eFZ();
            w.makeText((Context)this, (CharSequence)"成功触发更刷新联系人信息(通讯录+好友)", 0).show();
          }
          break;
        case -912851086: 
          if (paramf.equals("enable_pre_input"))
          {
            paramPreference = (Context)this;
            paramf = com.tencent.mm.plugin.hld.f.e.DGW;
            if (!com.tencent.mm.plugin.hld.f.e.eGn()) {
              break label2044;
            }
            paramf = "预处理已关闭";
            w.makeText(paramPreference, (CharSequence)paramf, 0).show();
            paramf = com.tencent.mm.plugin.hld.f.e.DGW;
            paramf = com.tencent.mm.plugin.hld.f.e.DGW;
            if (!com.tencent.mm.plugin.hld.f.e.eGn()) {
              bool1 = true;
            }
            com.tencent.mm.plugin.hld.f.e.sZ(bool1);
          }
          break;
        case 1441853653: 
          if (paramf.equals("show_dict_info")) {
            eFx();
          }
          break;
        case -1424537775: 
          if (paramf.equals("enable_ilink_login"))
          {
            paramf = com.tencent.mm.plugin.hld.f.e.DGW;
            paramf = com.tencent.mm.plugin.hld.f.e.DGW;
            com.tencent.mm.plugin.hld.f.e.eGk();
          }
          break;
        case 636892639: 
          if (paramf.equals("op_req_three"))
          {
            l = cm.bfG();
            paramf = com.tencent.mm.plugin.hld.b.e.Dvq;
            e.a.a(com.tencent.mm.plugin.hld.model.b.DBm, 0L, null, 6);
            paramf = com.tencent.mm.plugin.hld.b.e.Dvq;
            e.a.a(com.tencent.mm.plugin.hld.model.b.DBl, 0L, null, 6);
            paramf = com.tencent.mm.plugin.hld.b.e.Dvq;
            e.a.a(com.tencent.mm.plugin.hld.model.b.DBt, l - 20L, null, 4);
          }
          break;
        case 1236253026: 
          if (paramf.equals("can_print_click_data"))
          {
            paramPreference = (Context)this;
            paramf = com.tencent.mm.plugin.hld.f.e.DGW;
            if (!com.tencent.mm.plugin.hld.f.e.eGl()) {
              break label2025;
            }
            paramf = "打印敲击数据已关闭";
            w.makeText(paramPreference, (CharSequence)paramf, 0).show();
            paramf = com.tencent.mm.plugin.hld.f.e.DGW;
            paramf = com.tencent.mm.plugin.hld.f.e.DGW;
            if (com.tencent.mm.plugin.hld.f.e.eGl()) {
              break label2032;
            }
            bool1 = true;
            com.tencent.mm.plugin.hld.f.e.sX(bool1);
          }
          break;
        case 1167464888: 
          if (paramf.equals("enable_fault_skip"))
          {
            paramf = getPreferenceScreen().byG("enable_fault_skip");
            if (paramf != null) {
              break label1926;
            }
            paramf = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(209888);
            throw paramf;
          }
          break;
        case -1105959686: 
          if (paramf.equals("enable_selfdraw_keyboard"))
          {
            paramPreference = (Context)this;
            paramf = com.tencent.mm.plugin.hld.f.e.DGW;
            if (!com.tencent.mm.plugin.hld.f.e.eGo()) {
              break label2051;
            }
            paramf = "自绘键盘已关闭";
            w.makeText(paramPreference, (CharSequence)paramf, 0).show();
            paramf = com.tencent.mm.plugin.hld.f.e.DGW;
            paramf = com.tencent.mm.plugin.hld.f.e.DGW;
            bool1 = bool2;
            if (!com.tencent.mm.plugin.hld.f.e.eGo()) {
              bool1 = true;
            }
            com.tencent.mm.plugin.hld.f.e.ta(bool1);
          }
          break;
        case -1751290163: 
          if (paramf.equals("op_req_two"))
          {
            l = cm.bfG();
            paramf = com.tencent.mm.plugin.hld.b.e.Dvq;
            e.a.a(com.tencent.mm.plugin.hld.model.b.DBm, 0L, null, 6);
            paramf = com.tencent.mm.plugin.hld.b.e.Dvq;
            e.a.a(com.tencent.mm.plugin.hld.model.b.DBl, 0L, null, 6);
            paramf = com.tencent.mm.plugin.hld.b.e.Dvq;
            e.a.a(com.tencent.mm.plugin.hld.model.b.DBn, l - 20L, null, 4);
          }
          break;
        case -1726776062: 
          if (paramf.equals("enable_fuzzy_syllables"))
          {
            paramf = getPreferenceScreen().byG("enable_fuzzy_syllables");
            if (paramf != null) {
              break label1959;
            }
            paramf = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(209888);
            throw paramf;
          }
          break;
        case 867930728: 
          if (paramf.equals("clear_active_process"))
          {
            paramf = com.tencent.mm.plugin.hld.f.l.DHK;
            paramf = com.tencent.mm.plugin.hld.f.l.eHB();
            if (paramf != null) {
              paramf.putBoolean("ime_active_first_process_privacy_info", false);
            }
            paramf = com.tencent.mm.plugin.hld.f.l.eHC();
            if (paramf != null) {
              paramf.putBoolean("ime_active_first_process_privacy_info", false);
            }
            paramf = com.tencent.mm.plugin.hld.f.l.eHB();
            if (paramf != null) {
              paramf.putBoolean("ime_active_second_process_collect_data", false);
            }
            paramf = com.tencent.mm.plugin.hld.f.l.eHC();
            if (paramf != null) {
              paramf.putBoolean("ime_active_second_process_collect_data", false);
            }
            paramf = com.tencent.mm.plugin.hld.f.l.eHB();
            if (paramf != null) {
              paramf.putBoolean("ime_active_fifth_process_choose_keyboard", false);
            }
            paramf = com.tencent.mm.plugin.hld.f.l.eHC();
            if (paramf != null) {
              paramf.putBoolean("ime_active_fifth_process_choose_keyboard", false);
            }
            paramf = com.tencent.mm.plugin.hld.f.l.eHB();
            if (paramf != null) {
              paramf.putBoolean("ime_local_user_dict_generator_finish", false);
            }
            paramf = com.tencent.mm.plugin.hld.f.l.eHC();
            if (paramf != null) {
              paramf.putBoolean("ime_local_user_dict_generator_finish", false);
            }
            paramf = com.tencent.mm.plugin.hld.f.l.eHB();
            if (paramf != null) {
              paramf.putBoolean("ime_local_user_dict_load_finish", false);
            }
            paramf = com.tencent.mm.plugin.hld.f.l.eHC();
            if (paramf != null) {
              paramf.putBoolean("ime_local_user_dict_load_finish", false);
            }
            paramf = com.tencent.mm.plugin.hld.f.l.eHB();
            if (paramf != null) {
              paramf.putBoolean("ime_phone_contact_data_load_finish", false);
            }
            paramf = com.tencent.mm.plugin.hld.f.l.eHC();
            if (paramf != null) {
              paramf.putBoolean("ime_phone_contact_data_load_finish", false);
            }
            paramf = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.hld.a.d.class);
            if (paramf != null)
            {
              paramf = paramf.eCD();
              if (paramf != null) {
                paramf.eCt();
              }
            }
            w.makeText((Context)this, (CharSequence)"成功重置激活流程", 0).show();
          }
          break;
        case 64699375: 
          if (paramf.equals("force_fetch_dict"))
          {
            paramf = com.tencent.mm.plugin.hld.f.l.DHK;
            com.tencent.mm.plugin.hld.f.l.eHv();
            paramf = com.tencent.mm.plugin.hld.f.l.DHK;
            paramf = com.tencent.mm.plugin.hld.f.l.getKV();
            if (paramf != null) {
              paramf.putLong("ime_get_dict_list_next_time", 0L);
            }
            paramf = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.hld.a.d.class);
            if (paramf != null) {
              paramf.eCB();
            }
            w.makeText((Context)this, (CharSequence)"成功触发更新Dict", 0).show();
          }
          break;
        case 819862248: 
          if (paramf.equals("config_delete_key"))
          {
            paramf = View.inflate((Context)getContext(), a.h.ime_debug_config_delete_key, null);
            paramPreference = (ImeSeekBar)paramf.findViewById(a.f.repeat_inter_time_seek_bar);
            paramPreference.setMinSize(10);
            paramPreference.setTotalSize(300);
            paramPreference.post((Runnable)new e(paramPreference));
            localObject = (ImeSeekBar)paramf.findViewById(a.f.repeat_delay_time_seek_bar);
            ((ImeSeekBar)localObject).setMinSize(50);
            ((ImeSeekBar)localObject).setTotalSize(500);
            ((ImeSeekBar)localObject).post((Runnable)new f((ImeSeekBar)localObject));
            f.a locala = new f.a((Context)getContext());
            locala.aR((CharSequence)getString(a.j.ime_debug_config_delete_key)).iK(paramf);
            locala.c((f.c)new g(paramPreference, (ImeSeekBar)localObject)).show();
          }
          break;
        }
      }
    } while (!paramf.equals("enable_move_cursor"));
    label658:
    paramPreference = (Context)this;
    paramf = com.tencent.mm.plugin.hld.f.e.DGW;
    if (com.tencent.mm.plugin.hld.f.e.eGp()) {}
    for (paramf = "移动光标已关闭";; paramf = "移动光标已开启")
    {
      w.makeText(paramPreference, (CharSequence)paramf, 0).show();
      paramf = com.tencent.mm.plugin.hld.f.e.DGW;
      paramf = com.tencent.mm.plugin.hld.f.e.DGW;
      bool1 = bool3;
      if (!com.tencent.mm.plugin.hld.f.e.eGp()) {
        bool1 = true;
      }
      com.tencent.mm.plugin.hld.f.e.tb(bool1);
      break;
      if (!paramf.equals("enable_emoji_config_clear")) {
        break;
      }
      paramf = g.DHh;
      g.clear("emoji");
      g.clear("kaoemoji");
      g.ir("emoji", "emotion");
      g.ir("kaoemoji", "happy");
      com.tencent.e.h.ZvG.o((Runnable)c.DFL, 500L);
      AppMethodBeat.o(209888);
      return true;
      if (!paramf.equals("can_print_engine_log")) {
        break;
      }
      paramPreference = (Context)this;
      localObject = new StringBuilder();
      paramf = com.tencent.mm.plugin.hld.f.e.DGW;
      if (com.tencent.mm.plugin.hld.f.e.eGl()) {}
      for (paramf = "打印Engine日志已关闭";; paramf = "打印Engine日志已开启")
      {
        w.makeText(paramPreference, (CharSequence)(paramf + ", 重启输入法生效"), 0).show();
        paramf = com.tencent.mm.plugin.hld.f.e.DGW;
        paramf = com.tencent.mm.plugin.hld.f.e.DGW;
        bool1 = bool4;
        if (!com.tencent.mm.plugin.hld.f.e.eGm()) {
          bool1 = true;
        }
        com.tencent.mm.plugin.hld.f.e.sY(bool1);
        break;
        if (!paramf.equals("enable_emoji_unicode")) {
          break;
        }
        paramf = getPreferenceScreen().byG("enable_emoji_unicode");
        if (paramf == null)
        {
          paramf = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
          AppMethodBeat.o(209888);
          throw paramf;
          if (!paramf.equals("op_req_one")) {
            break;
          }
          paramf = com.tencent.mm.plugin.hld.b.e.Dvq;
          e.a.a(com.tencent.mm.plugin.hld.model.b.DBm, 0L, null, 6);
          paramf = com.tencent.mm.plugin.hld.b.e.Dvq;
          e.a.a(com.tencent.mm.plugin.hld.model.b.DBl, 0L, null, 6);
          paramf = com.tencent.mm.plugin.hld.b.e.Dvq;
          e.a.a(com.tencent.mm.plugin.hld.model.b.DBp, 0L, null, 6);
          break;
          if (!paramf.equals("enable_fault")) {
            break;
          }
          paramf = getPreferenceScreen().byG("enable_fault");
          if (paramf == null)
          {
            paramf = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(209888);
            throw paramf;
            if (!paramf.equals("delete_dict_data")) {
              break;
            }
            paramf = com.tencent.mm.plugin.hld.f.l.DHK;
            com.tencent.mm.plugin.hld.f.l.eHv();
            com.tencent.e.h.ZvG.n((Runnable)new d(this), 500L);
            break;
            if (!paramf.equals("enable_fault_insert_at_middle")) {
              break;
            }
            paramf = getPreferenceScreen().byG("enable_fault_insert_at_middle");
            if (paramf != null) {
              break label1893;
            }
            paramf = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(209888);
            throw paramf;
            if (!paramf.equals("enable_fault_exchange")) {
              break;
            }
            paramf = getPreferenceScreen().byG("enable_fault_exchange");
            if (paramf != null) {
              break label1860;
            }
            paramf = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(209888);
            throw paramf;
          }
          paramf = (CheckBoxPreference)paramf;
          paramPreference = com.tencent.mm.plugin.hld.f.e.DGW;
          paramf.setChecked(false);
          paramf = com.tencent.mm.plugin.hld.f.e.DGW;
          paramf = com.tencent.mm.plugin.hld.f.e.DGW;
          com.tencent.mm.plugin.hld.f.e.eGe();
          eFw();
          AppMethodBeat.o(209888);
          return true;
          label1860:
          paramf = (CheckBoxPreference)paramf;
          paramPreference = com.tencent.mm.plugin.hld.f.e.DGW;
          paramf.setChecked(false);
          paramf = com.tencent.mm.plugin.hld.f.e.DGW;
          paramf = com.tencent.mm.plugin.hld.f.e.DGW;
          com.tencent.mm.plugin.hld.f.e.eGf();
          AppMethodBeat.o(209888);
          return true;
          label1893:
          paramf = (CheckBoxPreference)paramf;
          paramPreference = com.tencent.mm.plugin.hld.f.e.DGW;
          paramf.setChecked(false);
          paramf = com.tencent.mm.plugin.hld.f.e.DGW;
          paramf = com.tencent.mm.plugin.hld.f.e.DGW;
          com.tencent.mm.plugin.hld.f.e.eGg();
          AppMethodBeat.o(209888);
          return true;
          label1926:
          paramf = (CheckBoxPreference)paramf;
          paramPreference = com.tencent.mm.plugin.hld.f.e.DGW;
          paramf.setChecked(true);
          paramf = com.tencent.mm.plugin.hld.f.e.DGW;
          paramf = com.tencent.mm.plugin.hld.f.e.DGW;
          com.tencent.mm.plugin.hld.f.e.eGh();
          AppMethodBeat.o(209888);
          return true;
          label1959:
          paramf = (CheckBoxPreference)paramf;
          paramPreference = com.tencent.mm.plugin.hld.f.e.DGW;
          paramf.setChecked(true);
          paramf = com.tencent.mm.plugin.hld.f.e.DGW;
          paramf = com.tencent.mm.plugin.hld.f.e.DGW;
          com.tencent.mm.plugin.hld.f.e.eGi();
          AppMethodBeat.o(209888);
          return true;
        }
        paramf = (CheckBoxPreference)paramf;
        paramPreference = com.tencent.mm.plugin.hld.f.e.DGW;
        paramf.setChecked(true);
        paramf = com.tencent.mm.plugin.hld.f.e.DGW;
        paramf = com.tencent.mm.plugin.hld.f.e.DGW;
        com.tencent.mm.plugin.hld.f.e.eGj();
        AppMethodBeat.o(209888);
        return true;
        label2025:
        paramf = "打印敲击数据已开启";
        break label551;
        label2032:
        bool1 = false;
        break label579;
      }
      label2044:
      paramf = "预处理已开启";
      break label382;
      label2051:
      paramf = "自绘键盘已开启";
      break label658;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/HldDebugUI$Companion;", "", "()V", "KEY_AGAIN_GENERATE_USER_DICT", "", "KEY_CAN_PRINT_CLICK_DATA", "KEY_CAN_PRINT_ENGINE_LOG", "KEY_CLEAE_ACTIVE_PROCESS", "KEY_CONFIG_DELETE_KEY", "KEY_DELETE_DICT_DATA", "KEY_ENABLE_EMOJI_CONFIG_CLEAR", "KEY_ENABLE_EMOJI_UNICODE", "KEY_ENABLE_FAULT", "KEY_ENABLE_FAULT_EXCHANGE", "KEY_ENABLE_FAULT_INSERT_AT_MIDDLE", "KEY_ENABLE_FAULT_SKIP", "KEY_ENABLE_FUZZY_SYLLABLES", "KEY_ENABLE_ILINK_LOGIN", "KEY_ENABLE_MOVE_CURSOR", "KEY_ENABLE_PRE_INPUT", "KEY_ENABLE_SELFDRAW_KEYBOARD", "KEY_FORCE_FETCH_DICT", "KEY_REFRESH_CONTACT_DATA", "KEY_SHOW_DICT_INFO", "TAG", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(HldDebugUI paramHldDebugUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(212665);
      this.DFK.finish();
      AppMethodBeat.o(212665);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c DFL;
    
    static
    {
      AppMethodBeat.i(209212);
      DFL = new c();
      AppMethodBeat.o(209212);
    }
    
    public final void run()
    {
      AppMethodBeat.i(209211);
      com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
      com.tencent.mm.plugin.hld.f.l.eHv();
      AppMethodBeat.o(209211);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(HldDebugUI paramHldDebugUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(215689);
      Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
      localObject = com.tencent.mm.plugin.hld.f.l.getKV();
      if (localObject != null) {
        ((MultiProcessMMKV)localObject).encode("key_current_cloud_dicts", new cli().toByteArray());
      }
      localObject = com.tencent.mm.plugin.hld.f.l.DHK;
      localObject = com.tencent.mm.plugin.hld.f.l.getKV();
      if (localObject != null) {
        ((MultiProcessMMKV)localObject).encode("key_new_cloud_dicts", new cli().toByteArray());
      }
      localObject = com.tencent.mm.plugin.hld.f.f.DGX;
      boolean bool = u.deleteDir(com.tencent.mm.plugin.hld.f.f.eGt());
      Context localContext = (Context)this.DFK;
      if (bool) {}
      for (localObject = "字典成功删除";; localObject = "字典删除失败")
      {
        w.makeText(localContext, (CharSequence)localObject, 0).show();
        AppMethodBeat.o(215689);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(ImeSeekBar paramImeSeekBar) {}
    
    public final void run()
    {
      AppMethodBeat.i(209808);
      ImeSeekBar localImeSeekBar = this.DFM;
      com.tencent.mm.plugin.hld.f.e locale = com.tencent.mm.plugin.hld.f.e.DGW;
      localImeSeekBar.setInitSeekSize((int)com.tencent.mm.plugin.hld.f.e.eGq());
      AppMethodBeat.o(209808);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(ImeSeekBar paramImeSeekBar) {}
    
    public final void run()
    {
      AppMethodBeat.i(216194);
      ImeSeekBar localImeSeekBar = this.DFN;
      com.tencent.mm.plugin.hld.f.e locale = com.tencent.mm.plugin.hld.f.e.DGW;
      localImeSeekBar.setInitSeekSize((int)com.tencent.mm.plugin.hld.f.e.eGr());
      AppMethodBeat.o(216194);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class g
    implements f.c
  {
    g(ImeSeekBar paramImeSeekBar1, ImeSeekBar paramImeSeekBar2) {}
    
    public final void g(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(216518);
      if (paramBoolean)
      {
        paramString = com.tencent.mm.plugin.hld.f.e.DGW;
        com.tencent.mm.plugin.hld.f.e.Ob(this.DFM.getCurrentSeekSize());
        paramString = com.tencent.mm.plugin.hld.f.e.DGW;
        com.tencent.mm.plugin.hld.f.e.Oc(this.DFN.getCurrentSeekSize());
      }
      AppMethodBeat.o(216518);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.HldDebugUI
 * JD-Core Version:    0.7.0.1
 */