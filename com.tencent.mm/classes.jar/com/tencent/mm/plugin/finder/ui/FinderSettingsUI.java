package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.f.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHotRelatedUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHotRelatedUIC.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout.a;
import d.g.b.v.a;
import d.v;
import d.y;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingsUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "screen", "Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter;", "getResourceId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "plugin-finder_release"})
public final class FinderSettingsUI
  extends MMPreference
{
  private com.tencent.mm.ui.base.preference.h FJn;
  final String TAG;
  
  public FinderSettingsUI()
  {
    AppMethodBeat.i(167666);
    this.TAG = "MicroMsg.FinderDebugSettingsUI";
    AppMethodBeat.o(167666);
  }
  
  public final int getResourceId()
  {
    return 2131951769;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(199440);
    Object localObject1 = getPreferenceScreen();
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.MMPreferenceAdapter");
      AppMethodBeat.o(199440);
      throw ((Throwable)localObject1);
    }
    this.FJn = ((com.tencent.mm.ui.base.preference.h)localObject1);
    localObject1 = this.FJn;
    if (localObject1 != null)
    {
      localObject2 = new PreferenceTitleCategory((Context)this);
      ((PreferenceTitleCategory)localObject2).setTitle((CharSequence)"新版本");
      ((com.tencent.mm.ui.base.preference.h)localObject1).b((Preference)localObject2);
    }
    new e((MMPreference)this, "二级评论是否展开", (j)new k());
    localObject1 = (MMPreference)this;
    Object localObject2 = ae.a.LBi;
    d.g.a.a locala = (d.g.a.a)v.KZK;
    new f((MMPreference)localObject1, "实名点赞", (ae.a)localObject2, new String[] { "默认", "实名点赞", "非实名点赞" }, new int[] { -1, 1, 2 }, locala);
    new e((MMPreference)this, "评论全屏方案", (j)new af());
    new f((MMPreference)this, "圈外分享模式(仅预览)", ae.a.Fxn, new String[] { "默认", "允许nickname", "过滤nickname" }, new int[] { -1, 1, 2 });
    new f((MMPreference)this, "附近tab使用瀑布流/卡片流开关", ae.a.LBy, new String[] { "瀑布流", "卡片流", "系统默认" }, new int[] { 1, 2, -1 });
    localObject1 = this.FJn;
    if (localObject1 != null)
    {
      localObject2 = new PreferenceTitleCategory((Context)this);
      ((PreferenceTitleCategory)localObject2).setTitle((CharSequence)"体验相关");
      ((com.tencent.mm.ui.base.preference.h)localObject1).b((Preference)localObject2);
    }
    new e((MMPreference)this, "关注/点赞折叠改为3条就出查看更多", (j)new ag());
    new e((MMPreference)this, "开启视频预加载预览View", (j)new FinderSettingsUI.ah());
    new f((MMPreference)this, "是否开启手势切Tab", ae.a.LBg, new String[] { "关闭(-1)", "默认(0)", "打开(1)" }, new int[] { -1, 0, 1 });
    new f((MMPreference)this, "切换单Tab", ae.a.LBh, new String[] { "默认", "切换单Tab", "切换多Tab" }, new int[] { 0, 2, 1 });
    new e((MMPreference)this, "显示视频播放基线", (j)new ai());
    localObject1 = this.FJn;
    if (localObject1 != null)
    {
      localObject2 = new PreferenceTitleCategory((Context)this);
      ((PreferenceTitleCategory)localObject2).setTitle((CharSequence)"测试");
      ((com.tencent.mm.ui.base.preference.h)localObject1).b((Preference)localObject2);
    }
    new f((MMPreference)this, "VideoView组件播放模式", ae.a.FwZ, new String[] { "SINGLE(1)", "MULTI_INSTANCE_WITHOUT_REUSE(2)", "MULTI_INSTANCE_AND_REUSE(0)", "LAZY(3)", "DEFAULT(2)" }, new int[] { 1, 2, 0, 3, 2 });
    new g((MMPreference)this, "重置最后退出TL时间为0", (k)new a());
    new g((MMPreference)this, "评论字数限制10,Media字数15,纯文本字数20", (k)new b());
    new g((MMPreference)this, "最大话题数改为3个", (k)new FinderSettingsUI.c());
    localObject1 = new v.a();
    localObject2 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    ((v.a)localObject1).Jhs = ((com.tencent.mm.kernel.e)localObject2).afk().getBoolean(ae.a.LAT, false);
    new g((MMPreference)this, "假菊花Toast" + ((v.a)localObject1).Jhs, (k)new d((v.a)localObject1));
    new g((MMPreference)this, "话题最大长度改为10", (k)new e());
    new e((MMPreference)this, "话题推荐打开", (j)new f());
    new e((MMPreference)this, "自动触发正例反馈", (j)new g());
    new e((MMPreference)this, "打开切换身份评论", (j)new h());
    new g((MMPreference)this, "重置切换身份评论flag", (k)new i());
    new e((MMPreference)this, "切换身份评论总是提示", (j)new j());
    new e((MMPreference)this, "切换身份评论打开", (j)new l());
    new g((MMPreference)this, "最大at数改为3个", (k)new m());
    new g((MMPreference)this, "朋友推荐tab-话题推荐调试", (k)new n(this));
    new e((MMPreference)this, "发表feed/评论点赞固定失败", (j)new o());
    new g((MMPreference)this, "评论点赞重试间隔改为1s", (k)new FinderSettingsUI.p());
    new g((MMPreference)this, "清除keybuf/账号数据", (k)new q());
    new g((MMPreference)this, "清除图片视频所有缓存", (k)new r(this));
    new g((MMPreference)this, "清空keybuf", (k)new s());
    new f((MMPreference)this, "RecyclerView滑动速度", ae.a.LAR, new String[] { "默认(0.8)", "0.5倍", "0.6倍", "0.7倍", "0.8倍", "0.9倍", "1倍", "1.3倍" }, new int[] { 80, 50, 60, 70, 80, 90, 100, 130 });
    new f((MMPreference)this, "假菊花时长", ae.a.LAS, new String[] { "默认(300)", "100", "200", "400", "500", "600", "700", "800", "1000", "3000" }, new int[] { 0, 100, 200, 400, 500, 600, 700, 800, 1000, 3000 });
    new g((MMPreference)this, "把自己改成非白名单用户", (k)new t());
    new g((MMPreference)this, "把所有feed改为仅自己可见", (k)new u());
    new g((MMPreference)this, "双击与展开教育/收藏红点重置", (k)new FinderSettingsUI.w());
    new f((MMPreference)this, "红点不受配置时间限制", ae.a.Fwu, new String[] { "默认", "无限制" }, new int[] { 1, 1000000000 });
    new f((MMPreference)this, "后台合成", ae.a.LBw, new String[] { "X实验配置", "否", "是" }, new int[] { -1, 0, 1 });
    new g((MMPreference)this, "发表相机红点重置", (k)new x());
    new f((MMPreference)this, "只看某个feed", ae.a.Fxa, new String[] { "FINDER_FEED_PHOTO", "FINDER_FEED_VIDEO", "FINDER_FEED_MIX_MEDIA", "DEFAULT" }, new int[] { 2, 4, 8, -1 });
    new g((MMPreference)this, "进入视频号Crash", (k)new y());
    new g((MMPreference)this, "清空通知lastBuffer", (k)new z());
    localObject1 = this.FJn;
    if (localObject1 != null)
    {
      localObject2 = new PreferenceTitleCategory((Context)this);
      ((PreferenceTitleCategory)localObject2).setTitle((CharSequence)"其他");
      ((com.tencent.mm.ui.base.preference.h)localObject1).b((Preference)localObject2);
    }
    new e((MMPreference)this, "输出视频号DEBUG日志", (j)new FinderSettingsUI.aa());
    new g((MMPreference)this, "清理首页文件缓存", (k)new ab());
    new g((MMPreference)this, "查看Finder缓存大小", (k)new ac(this));
    new g((MMPreference)this, "复制finder配置到剪贴板", (k)new ad());
    new f((MMPreference)this, "个人中心用户状态", ae.a.LBx, new String[] { "无发表资格", "有发表资格但未创建账号", "账号处于正常状态", "账号被封禁", "账号审核中", "账号被禁言", "reset" }, new int[] { 1, 2, 3, 4, 5, 6, -1 });
    new g((MMPreference)this, "重置首次获得发表权限标志", (k)new ae());
    localObject1 = this.FJn;
    if (localObject1 != null)
    {
      ((com.tencent.mm.ui.base.preference.h)localObject1).notifyDataSetChanged();
      AppMethodBeat.o(199440);
      return;
    }
    AppMethodBeat.o(199440);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167662);
    super.onCreate(paramBundle);
    setMMTitle("视频号维修厂");
    setBackBtn((MenuItem.OnMenuItemClickListener)new ao(this));
    initView();
    AppMethodBeat.o(167662);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(199441);
    if (!(paramPreference instanceof l)) {}
    for (paramf = null;; paramf = paramPreference)
    {
      paramf = (l)paramf;
      if (paramf != null) {
        paramf.fVl();
      }
      AppMethodBeat.o(199441);
      return true;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$10", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class a
    implements k
  {
    public final void onClick()
    {
      AppMethodBeat.i(199391);
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.Fwt, Long.valueOf(0L));
      AppMethodBeat.o(199391);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$36", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class ab
    implements k
  {
    public final void onClick()
    {
      AppMethodBeat.i(199428);
      Object localObject = com.tencent.mm.ui.component.a.LCX;
      ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class)).fXi();
      localObject = com.tencent.mm.plugin.finder.storage.data.f.qKv;
      f.a.clearAll();
      AppMethodBeat.o(199428);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$37", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class ac
    implements k
  {
    public final void onClick()
    {
      AppMethodBeat.i(199429);
      Object localObject = com.tencent.mm.plugin.finder.utils.k.qTp;
      localObject = com.tencent.mm.plugin.finder.utils.k.cse();
      com.tencent.mm.ui.base.h.R((Context)this.qPT.getContext(), (String)localObject, "嗯");
      AppMethodBeat.o(199429);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$38", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class ad
    implements k
  {
    public final void onClick()
    {
      AppMethodBeat.i(199430);
      Object localObject1 = new StringBuilder("clicfg_ultron_finder_search_only_contact_android: ");
      Object localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.finder.storage.b.cpr()).append('\n').append("clicfg_ultron_timeline_publish_entrance_switch_android:");
      localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.finder.storage.b.cps()).append('\n').append("clicfg_ultron_finder_show_reddot_number_attab_android:");
      localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.finder.storage.b.cpt()).append('\n').append("clicfg_ultron_record_video_max_duration_android:");
      localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.finder.storage.b.coB().duration).append('\n').append("clicfg_ultron_record_video_min_duration_android:");
      localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.finder.storage.b.coB().minDuration).append('\n').append("clicfg_ultron_album_video_max_duration_android:");
      localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.finder.storage.b.coC().duration).append('\n').append("clicfg_ultron_album_video_min_duration_android:");
      localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject1 = com.tencent.mm.plugin.finder.storage.b.coC().minDuration + '\n' + "clicfg_ultron_album_video_max_select_duration_android:" + ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pru, 300);
      localObject2 = new StringBuilder("MXM_DynaCfg_AV_Item_Key_FinderCommentTextLimit:");
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cpm()).append('\n').append("MXM_DynaCfg_AV_Item_Key_FinderCommentTextLimit:");
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cpn()).append('\n').append("clicfg_ultron_finder_folder_size_dump_interval:");
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cpc()).append('\n').append("clicfg_ultron_finder_folder_size_image:");
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cpf()).append('\n').append("clicfg_ultron_finder_folder_size_avatar:");
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cpg()).append('\n').append("clicfg_ultron_finder_folder_size_cropimg:");
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cph()).append('\n').append("clicfg_ultron_finder_folder_size_video:");
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cpi()).append('\n').append("clicfg_ultron_finder_folder_size_tmp:");
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cpj()).append('\n').append("clicfg_ultron_finder_folder_size_capture:");
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cpk()).append('\n').append("clicfg_ultron_finder_folder_size_posttmp:");
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cpl()).append('\n');
      localObject2 = aj.getContext().getSystemService("clipboard");
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.content.ClipboardManager");
        AppMethodBeat.o(199430);
        throw ((Throwable)localObject1);
      }
      ((ClipboardManager)localObject2).setText((CharSequence)localObject1);
      t.makeText(aj.getContext(), (CharSequence)localObject1, 1).show();
      AppMethodBeat.o(199430);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$39", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class ae
    implements k
  {
    public final void onClick()
    {
      AppMethodBeat.i(199431);
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.LBu, Boolean.FALSE);
      AppMethodBeat.o(199431);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$4", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "setValue", "", "value", "", "plugin-finder_release"})
  public static final class af
    implements j
  {
    public final boolean fVE()
    {
      AppMethodBeat.i(199432);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.fUo() == 1)
      {
        AppMethodBeat.o(199432);
        return true;
      }
      AppMethodBeat.o(199432);
      return false;
    }
    
    public final void yJ(boolean paramBoolean)
    {
      AppMethodBeat.i(199433);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        com.tencent.mm.plugin.finder.storage.b.aht(i);
        AppMethodBeat.o(199433);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$6", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "setValue", "", "value", "", "plugin-finder_release"})
  public static final class ag
    implements j
  {
    public final boolean fVE()
    {
      AppMethodBeat.i(199434);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.fUF() == 3)
      {
        AppMethodBeat.o(199434);
        return true;
      }
      AppMethodBeat.o(199434);
      return false;
    }
    
    public final void yJ(boolean paramBoolean)
    {
      AppMethodBeat.i(199435);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (paramBoolean) {}
      for (int i = 3;; i = 20)
      {
        com.tencent.mm.plugin.finder.storage.b.ahw(i);
        AppMethodBeat.o(199435);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$8", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "setValue", "", "value", "", "plugin-finder_release"})
  public static final class ai
    implements j
  {
    public final boolean fVE()
    {
      AppMethodBeat.i(199438);
      TouchMediaPreviewLayout.a locala = TouchMediaPreviewLayout.HCM;
      boolean bool = TouchMediaPreviewLayout.ffg();
      AppMethodBeat.o(199438);
      return bool;
    }
    
    public final void yJ(boolean paramBoolean)
    {
      AppMethodBeat.i(199439);
      TouchMediaPreviewLayout.a locala = TouchMediaPreviewLayout.HCM;
      TouchMediaPreviewLayout.wR(paramBoolean);
      AppMethodBeat.o(199439);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class ao
    implements MenuItem.OnMenuItemClickListener
  {
    ao(FinderSettingsUI paramFinderSettingsUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167660);
      this.qPT.finish();
      AppMethodBeat.o(167660);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$11", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class b
    implements k
  {
    public final void onClick()
    {
      AppMethodBeat.i(199392);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.cpp();
      AppMethodBeat.o(199392);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$13", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class d
    implements k
  {
    d(v.a parama) {}
    
    public final void onClick()
    {
      boolean bool = false;
      AppMethodBeat.i(199394);
      Object localObject1 = this.KZI;
      Object localObject2 = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject2, "MMKernel.storage()");
      ((v.a)localObject1).Jhs = ((com.tencent.mm.kernel.e)localObject2).afk().getBoolean(ae.a.LAT, false);
      localObject1 = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).afk();
      localObject2 = ae.a.LAT;
      if (!this.KZI.Jhs) {
        bool = true;
      }
      ((ab)localObject1).set((ae.a)localObject2, Boolean.valueOf(bool));
      AppMethodBeat.o(199394);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$14", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class e
    implements k
  {
    public final void onClick()
    {
      AppMethodBeat.i(199395);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.cpM();
      AppMethodBeat.o(199395);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$15", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "setValue", "", "value", "", "plugin-finder_release"})
  public static final class f
    implements j
  {
    public final boolean fVE()
    {
      AppMethodBeat.i(199396);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.fUk() > 0)
      {
        AppMethodBeat.o(199396);
        return true;
      }
      AppMethodBeat.o(199396);
      return false;
    }
    
    public final void yJ(boolean paramBoolean)
    {
      AppMethodBeat.i(199397);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        com.tencent.mm.plugin.finder.storage.b.ahs(i);
        AppMethodBeat.o(199397);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$16", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "setValue", "", "value", "", "plugin-finder_release"})
  public static final class g
    implements j
  {
    public final boolean fVE()
    {
      AppMethodBeat.i(199398);
      FinderHotRelatedUIC.a locala = FinderHotRelatedUIC.Lix;
      boolean bool = FinderHotRelatedUIC.fXo();
      AppMethodBeat.o(199398);
      return bool;
    }
    
    public final void yJ(boolean paramBoolean)
    {
      AppMethodBeat.i(199399);
      FinderHotRelatedUIC.a locala = FinderHotRelatedUIC.Lix;
      FinderHotRelatedUIC.yT(paramBoolean);
      AppMethodBeat.o(199399);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$17", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "setValue", "", "value", "", "plugin-finder_release"})
  public static final class h
    implements j
  {
    public final boolean fVE()
    {
      AppMethodBeat.i(199400);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      boolean bool = com.tencent.mm.plugin.finder.storage.b.fUm();
      AppMethodBeat.o(199400);
      return bool;
    }
    
    public final void yJ(boolean paramBoolean)
    {
      AppMethodBeat.i(199401);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.yH(paramBoolean);
      AppMethodBeat.o(199401);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$18", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class i
    implements k
  {
    public final void onClick()
    {
      AppMethodBeat.i(199402);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.le(true);
      AppMethodBeat.o(199402);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$19", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "setValue", "", "value", "", "plugin-finder_release"})
  public static final class j
    implements j
  {
    public final boolean fVE()
    {
      AppMethodBeat.i(199403);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      boolean bool = com.tencent.mm.plugin.finder.storage.b.fUl();
      AppMethodBeat.o(199403);
      return bool;
    }
    
    public final void yJ(boolean paramBoolean)
    {
      AppMethodBeat.i(199404);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.yG(paramBoolean);
      AppMethodBeat.o(199404);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$2", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "setValue", "", "value", "", "plugin-finder_release"})
  public static final class k
    implements j
  {
    public final boolean fVE()
    {
      AppMethodBeat.i(199405);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      boolean bool = com.tencent.mm.plugin.finder.storage.b.fUA();
      AppMethodBeat.o(199405);
      return bool;
    }
    
    public final void yJ(boolean paramBoolean)
    {
      AppMethodBeat.i(199406);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.yI(paramBoolean);
      AppMethodBeat.o(199406);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$20", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "setValue", "", "value", "", "plugin-finder_release"})
  public static final class l
    implements j
  {
    public final boolean fVE()
    {
      AppMethodBeat.i(199407);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      boolean bool = com.tencent.mm.plugin.finder.storage.b.fUm();
      AppMethodBeat.o(199407);
      return bool;
    }
    
    public final void yJ(boolean paramBoolean)
    {
      AppMethodBeat.i(199408);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.yH(paramBoolean);
      AppMethodBeat.o(199408);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$21", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class m
    implements k
  {
    public final void onClick()
    {
      AppMethodBeat.i(199409);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.fUi();
      AppMethodBeat.o(199409);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$22", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class n
    implements k
  {
    public final void onClick()
    {
      AppMethodBeat.i(199411);
      LinkedList localLinkedList = new LinkedList();
      List localList = d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
      localLinkedList.add("默认方案");
      localLinkedList.add("拿到就显示");
      localLinkedList.add("显示话题推荐空白页");
      com.tencent.mm.ui.base.h.a((Context)this.qPT, "", (List)localLinkedList, localList, "", (h.d)new FinderSettingsUI.n.a(this));
      AppMethodBeat.o(199411);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$23", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "setValue", "", "value", "", "plugin-finder_release"})
  public static final class o
    implements j
  {
    public final boolean fVE()
    {
      AppMethodBeat.i(199412);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      boolean bool1 = com.tencent.mm.plugin.finder.storage.b.coX();
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      boolean bool2 = com.tencent.mm.plugin.finder.storage.b.coX();
      AppMethodBeat.o(199412);
      return bool1 | bool2;
    }
    
    public final void yJ(boolean paramBoolean)
    {
      AppMethodBeat.i(199413);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.ld(paramBoolean);
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.ld(paramBoolean);
      AppMethodBeat.o(199413);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$25", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class q
    implements k
  {
    public final void onClick()
    {
      AppMethodBeat.i(199415);
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.Fwq, "");
      locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.Fwr, "");
      locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.FvW, "");
      locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.FvX, "");
      locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.FvY, "");
      locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.FvZ, "");
      locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.Fwa, "");
      locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.Fwb, "");
      locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.Fwc, "");
      locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.Fwe, Integer.valueOf(0));
      locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.FwM, Boolean.FALSE);
      AppMethodBeat.o(199415);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$26", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class r
    implements k
  {
    public final void onClick()
    {
      AppMethodBeat.i(199416);
      Object localObject = com.tencent.mm.plugin.finder.utils.k.qTp;
      com.tencent.mm.plugin.finder.utils.k.eJc();
      localObject = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
      boolean bool = com.tencent.mm.plugin.finder.storage.logic.c.aIG();
      localObject = this.qPT.TAG;
      StringBuilder localStringBuilder = new StringBuilder("ret=[").append(bool).append("] finderVideoPath=");
      com.tencent.mm.plugin.finder.utils.k localk = com.tencent.mm.plugin.finder.utils.k.qTp;
      localStringBuilder = localStringBuilder.append(com.tencent.mm.plugin.finder.utils.k.crW()).append(" finderImgPath=");
      localk = com.tencent.mm.plugin.finder.utils.k.qTp;
      ad.i((String)localObject, com.tencent.mm.plugin.finder.utils.k.crV());
      t.makeText(aj.getContext(), (CharSequence)"db: ".concat(String.valueOf(bool)), 1).show();
      AppMethodBeat.o(199416);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$27", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class s
    implements k
  {
    public final void onClick()
    {
      AppMethodBeat.i(199417);
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.Fwq, "");
      locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.Fwr, "");
      locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.FwM, Boolean.FALSE);
      AppMethodBeat.o(199417);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$28", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class t
    implements k
  {
    public final void onClick()
    {
      AppMethodBeat.i(199418);
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).closeFinderEntryForDebug();
      AppMethodBeat.o(199418);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$29", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class u
    implements k
  {
    public final void onClick()
    {
      AppMethodBeat.i(199419);
      FinderItem.a locala = FinderItem.qJU;
      FinderItem.access$setDebugOnlySelfSee$cp(true);
      AppMethodBeat.o(199419);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class v
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final v KZK;
    
    static
    {
      AppMethodBeat.i(199421);
      KZK = new v();
      AppMethodBeat.o(199421);
    }
    
    v()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$31", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class x
    implements k
  {
    public final void onClick()
    {
      AppMethodBeat.i(199423);
      Object localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fxd, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject).getRedDotManager().ahg(-1);
      AppMethodBeat.o(199423);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$32", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class y
    implements k
  {
    public final void onClick()
    {
      AppMethodBeat.i(199424);
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.fUK();
      AppMethodBeat.o(199424);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$33", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class z
    implements k
  {
    public final void onClick()
    {
      AppMethodBeat.i(199425);
      Object localObject = s.qpl;
      ad.i(s.access$getTAG$cp(), "clearLastBuf");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.LBl, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.LBm, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.LBk, "");
      AppMethodBeat.o(199425);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingsUI
 * JD-Core Version:    0.7.0.1
 */