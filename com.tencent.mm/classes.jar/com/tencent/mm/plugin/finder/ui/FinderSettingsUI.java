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
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ag;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.i.a;
import com.tencent.mm.plugin.finder.upload.action.a.a;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamRefreshPreload;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamRefreshPreload.b;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHotRelatedUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHotRelatedUIC.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout.a;
import d.g.b.v.a;
import d.l;
import d.v;
import d.y;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingsUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "screen", "Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter;", "getResourceId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "plugin-finder_release"})
public final class FinderSettingsUI
  extends MMPreference
{
  final String TAG;
  private com.tencent.mm.ui.base.preference.h rLF;
  
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
    AppMethodBeat.i(203416);
    Object localObject1 = getPreferenceScreen();
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.MMPreferenceAdapter");
      AppMethodBeat.o(203416);
      throw ((Throwable)localObject1);
    }
    this.rLF = ((com.tencent.mm.ui.base.preference.h)localObject1);
    localObject1 = this.rLF;
    if (localObject1 != null)
    {
      localObject2 = new PreferenceTitleCategory((Context)this);
      ((PreferenceTitleCategory)localObject2).setTitle((CharSequence)"新版本");
      localObject3 = y.KTp;
      ((com.tencent.mm.ui.base.preference.h)localObject1).b((Preference)localObject2);
      localObject1 = y.KTp;
    }
    new c((MMPreference)this, "二级评论是否展开", (i)new FinderSettingsUI.k());
    localObject1 = (MMPreference)this;
    Object localObject2 = ah.a.GVe;
    Object localObject3 = (d.g.a.a)FinderSettingsUI.v.rLJ;
    new d((MMPreference)localObject1, "实名点赞", (ah.a)localObject2, new String[] { "默认", "实名点赞", "非实名点赞" }, new int[] { -1, 1, 2 }, (d.g.a.a)localObject3);
    new c((MMPreference)this, "评论全屏方案", (i)new FinderSettingsUI.af());
    new d((MMPreference)this, "圈外分享模式(仅预览)", ah.a.GVD, new String[] { "默认", "允许nickname", "过滤nickname" }, new int[] { -1, 1, 2 });
    new d((MMPreference)this, "附近tab使用瀑布流/卡片流开关", ah.a.GVW, new String[] { "瀑布流", "卡片流", "系统默认" }, new int[] { 1, 2, -1 });
    localObject1 = this.rLF;
    if (localObject1 != null)
    {
      localObject2 = new PreferenceTitleCategory((Context)this);
      ((PreferenceTitleCategory)localObject2).setTitle((CharSequence)"体验相关");
      localObject3 = y.KTp;
      ((com.tencent.mm.ui.base.preference.h)localObject1).b((Preference)localObject2);
      localObject1 = y.KTp;
    }
    new c((MMPreference)this, "关注/点赞折叠改为3条就出查看更多", (i)new FinderSettingsUI.aj());
    new c((MMPreference)this, "开启视频预加载预览View", (i)new ak());
    new d((MMPreference)this, "是否开启手势切Tab", ah.a.GVc, new String[] { "关闭(-1)", "默认(0)", "打开(1)" }, new int[] { -1, 0, 1 });
    new d((MMPreference)this, "切换单Tab", ah.a.GVd, new String[] { "默认", "切换单Tab", "切换多Tab" }, new int[] { 0, 2, 1 });
    new c((MMPreference)this, "显示视频播放基线", (i)new al());
    localObject1 = this.rLF;
    if (localObject1 != null)
    {
      localObject2 = new PreferenceTitleCategory((Context)this);
      ((PreferenceTitleCategory)localObject2).setTitle((CharSequence)"测试");
      localObject3 = y.KTp;
      ((com.tencent.mm.ui.base.preference.h)localObject1).b((Preference)localObject2);
      localObject1 = y.KTp;
    }
    new d((MMPreference)this, "VideoView组件播放模式", ah.a.GVp, new String[] { "SINGLE(1)", "MULTI_INSTANCE_WITHOUT_REUSE(2)", "MULTI_INSTANCE_AND_REUSE(0)", "LAZY(3)", "DEFAULT(2)" }, new int[] { 1, 2, 0, 3, 2 });
    new e((MMPreference)this, "重置最后退出TL时间为0", (j)new FinderSettingsUI.a());
    new e((MMPreference)this, "评论字数限制10,Media字数15,纯文本字数20", (j)new FinderSettingsUI.b());
    new e((MMPreference)this, "最大话题数改为3个", (j)new FinderSettingsUI.c());
    localObject1 = new v.a();
    localObject2 = g.agR();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    ((v.a)localObject1).KUL = ((com.tencent.mm.kernel.e)localObject2).agA().getBoolean(ah.a.GUC, false);
    new e((MMPreference)this, "假菊花Toast" + ((v.a)localObject1).KUL, (j)new d((v.a)localObject1));
    new e((MMPreference)this, "话题最大长度改为10", (j)new FinderSettingsUI.e());
    new e((MMPreference)this, "清理New红点配置", (j)new FinderSettingsUI.f());
    new e((MMPreference)this, "本地配置是否展示NEW", (j)new FinderSettingsUI.g());
    new c((MMPreference)this, "话题推荐打开", (i)new FinderSettingsUI.h());
    new c((MMPreference)this, "自动触发正例反馈", (i)new i());
    new c((MMPreference)this, "打开切换身份评论", (i)new FinderSettingsUI.j());
    new e((MMPreference)this, "重置切换身份评论flag", (j)new FinderSettingsUI.l());
    new c((MMPreference)this, "切换身份评论总是提示", (i)new FinderSettingsUI.m());
    new c((MMPreference)this, "切换身份评论打开", (i)new FinderSettingsUI.n());
    new e((MMPreference)this, "最大at数改为3个", (j)new FinderSettingsUI.o());
    new e((MMPreference)this, "朋友推荐tab-话题推荐调试", (j)new p(this));
    new c((MMPreference)this, "发表feed/评论点赞固定失败", (i)new FinderSettingsUI.q());
    new e((MMPreference)this, "评论点赞重试间隔改为1s", (j)new r());
    new e((MMPreference)this, "清除keybuf/账号数据", (j)new s());
    new e((MMPreference)this, "清除图片视频所有缓存", (j)new t(this));
    new e((MMPreference)this, "清空keybuf", (j)new u());
    new d((MMPreference)this, "RecyclerView滑动速度", ah.a.GUx, new String[] { "默认(0.8)", "0.5倍", "0.6倍", "0.7倍", "0.8倍", "0.9倍", "1倍", "1.3倍" }, new int[] { 80, 50, 60, 70, 80, 90, 100, 130 });
    new d((MMPreference)this, "loadmore假菊花时长", ah.a.GUy, new String[] { "默认(300)", "100", "200", "400", "500", "600", "700", "800", "1000", "3000" }, new int[] { 0, 100, 200, 400, 500, 600, 700, 800, 1000, 3000 });
    new d((MMPreference)this, "refresh假菊花时长", ah.a.GUz, new String[] { "默认(500)", "100", "200", "400", "500", "600", "700", "800", "1000", "3000" }, new int[] { 0, 100, 200, 400, 500, 600, 700, 800, 1000, 3000 });
    new d((MMPreference)this, "自动刷新缓存时间", ah.a.GUA, new String[] { "默认(5min)", "10s", "30s", "1min" }, new int[] { 0, 10000, 30000, 60000 });
    new d((MMPreference)this, "预加载debug轮询时长", ah.a.GUB, new String[] { "默认(20min)", "5s", "10s", "1min" }, new int[] { 0, 5000, 10000, 60000 });
    new e((MMPreference)this, "预加载debug config(1s)", (j)new w());
    new e((MMPreference)this, "把自己改成非白名单用户", (j)new FinderSettingsUI.x());
    new e((MMPreference)this, "把所有feed改为仅自己可见", (j)new y());
    new e((MMPreference)this, "双击与展开教育/收藏红点重置", (j)new z());
    new d((MMPreference)this, "红点不受配置时间限制", ah.a.GUw, new String[] { "默认", "无限制" }, new int[] { 1, 1000000000 });
    new d((MMPreference)this, "后台合成", ah.a.GVU, new String[] { "X实验配置", "否", "是" }, new int[] { -1, 0, 1 });
    new e((MMPreference)this, "发表相机红点重置", (j)new aa());
    new d((MMPreference)this, "只看某个feed", ah.a.GVq, new String[] { "FINDER_FEED_PHOTO", "FINDER_FEED_VIDEO", "FINDER_FEED_MIX_MEDIA", "DEFAULT" }, new int[] { 2, 4, 8, -1 });
    new e((MMPreference)this, "进入视频号Crash", (j)new FinderSettingsUI.ab());
    new e((MMPreference)this, "清空通知lastBuffer", (j)new ac());
    localObject1 = this.rLF;
    if (localObject1 != null)
    {
      localObject2 = new PreferenceTitleCategory((Context)this);
      ((PreferenceTitleCategory)localObject2).setTitle((CharSequence)"其他");
      localObject3 = y.KTp;
      ((com.tencent.mm.ui.base.preference.h)localObject1).b((Preference)localObject2);
      localObject1 = y.KTp;
    }
    new c((MMPreference)this, "输出视频号DEBUG日志", (i)new FinderSettingsUI.ad());
    new e((MMPreference)this, "清理首页文件缓存", (j)new ae());
    new e((MMPreference)this, "查看Finder缓存大小", (j)new ag(this));
    new e((MMPreference)this, "复制finder配置到剪贴板", (j)new ah());
    new d((MMPreference)this, "个人中心用户状态", ah.a.GVV, new String[] { "无发表资格", "有发表资格但未创建账号", "账号处于正常状态", "账号被封禁", "账号审核中", "账号被禁言", "reset" }, new int[] { 1, 2, 3, 4, 5, 6, -1 });
    new e((MMPreference)this, "重置首次获得发表权限标志", (j)new FinderSettingsUI.ai());
    localObject1 = this.rLF;
    if (localObject1 != null)
    {
      ((com.tencent.mm.ui.base.preference.h)localObject1).notifyDataSetChanged();
      localObject1 = y.KTp;
      AppMethodBeat.o(203416);
      return;
    }
    AppMethodBeat.o(203416);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167662);
    super.onCreate(paramBundle);
    setMMTitle("视频号维修厂");
    setBackBtn((MenuItem.OnMenuItemClickListener)new am(this));
    initView();
    AppMethodBeat.o(167662);
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(203417);
    if (!(paramPreference instanceof k)) {}
    for (paramf = null;; paramf = paramPreference)
    {
      paramf = (k)paramf;
      if (paramf != null) {
        paramf.cBs();
      }
      AppMethodBeat.o(203417);
      return true;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$34", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class aa
    implements j
  {
    public final void onClick()
    {
      AppMethodBeat.i(203399);
      Object localObject = g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVt, Integer.valueOf(0));
      localObject = g.ad(PluginFinder.class);
      d.g.b.k.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject).getRedDotManager().Dy(-1);
      AppMethodBeat.o(203399);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$36", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class ac
    implements j
  {
    public final void onClick()
    {
      AppMethodBeat.i(203401);
      Object localObject = ag.qYh;
      ac.i(ag.access$getTAG$cp(), "clearLastBuf");
      localObject = g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVG, "");
      localObject = g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVH, "");
      localObject = g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVF, "");
      localObject = g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVI, Integer.valueOf(0));
      localObject = g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVJ, Integer.valueOf(0));
      localObject = g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVK, Integer.valueOf(0));
      AppMethodBeat.o(203401);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$39", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class ae
    implements j
  {
    public final void onClick()
    {
      AppMethodBeat.i(203404);
      Object localObject = com.tencent.mm.ui.component.a.IrY;
      ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class)).cFK();
      localObject = com.tencent.mm.plugin.finder.storage.data.i.rEV;
      i.a.clearAll();
      AppMethodBeat.o(203404);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$40", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class ag
    implements j
  {
    public final void onClick()
    {
      AppMethodBeat.i(203407);
      Object localObject = p.rQw;
      localObject = p.cDx();
      com.tencent.mm.ui.base.h.Q((Context)this.rLH.getContext(), (String)localObject, "嗯");
      AppMethodBeat.o(203407);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$41", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class ah
    implements j
  {
    public final void onClick()
    {
      AppMethodBeat.i(203408);
      Object localObject1 = new StringBuilder("clicfg_ultron_finder_search_only_contact_android: ");
      Object localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.finder.storage.b.cyO()).append('\n').append("clicfg_ultron_timeline_publish_entrance_switch_android:");
      localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.finder.storage.b.cyP()).append('\n').append("clicfg_ultron_finder_show_reddot_number_attab_android:");
      localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.finder.storage.b.cyQ()).append('\n').append("clicfg_ultron_record_video_max_duration_android:");
      localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.finder.storage.b.cxY().duration).append('\n').append("clicfg_ultron_record_video_min_duration_android:");
      localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.finder.storage.b.cxY().minDuration).append('\n').append("clicfg_ultron_album_video_max_duration_android:");
      localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.finder.storage.b.cxZ().duration).append('\n').append("clicfg_ultron_album_video_min_duration_android:");
      localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject1 = com.tencent.mm.plugin.finder.storage.b.cxZ().minDuration + '\n' + "clicfg_ultron_album_video_max_select_duration_android:" + ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pVh, 300);
      localObject2 = new StringBuilder("MXM_DynaCfg_AV_Item_Key_FinderCommentTextLimit:");
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cyJ()).append('\n').append("MXM_DynaCfg_AV_Item_Key_FinderCommentTextLimit:");
      localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cyK()).append('\n').append("clicfg_ultron_finder_folder_size_dump_interval:");
      localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cyz()).append('\n').append("clicfg_ultron_finder_folder_size_image:");
      localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cyC()).append('\n').append("clicfg_ultron_finder_folder_size_avatar:");
      localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cyD()).append('\n').append("clicfg_ultron_finder_folder_size_cropimg:");
      localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cyE()).append('\n').append("clicfg_ultron_finder_folder_size_video:");
      localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cyF()).append('\n').append("clicfg_ultron_finder_folder_size_tmp:");
      localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cyG()).append('\n').append("clicfg_ultron_finder_folder_size_capture:");
      localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cyH()).append('\n').append("clicfg_ultron_finder_folder_size_posttmp:");
      localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.storage.b.cyI()).append('\n');
      localObject2 = ai.getContext().getSystemService("clipboard");
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.content.ClipboardManager");
        AppMethodBeat.o(203408);
        throw ((Throwable)localObject1);
      }
      ((ClipboardManager)localObject2).setText((CharSequence)localObject1);
      t.makeText(ai.getContext(), (CharSequence)localObject1, 1).show();
      AppMethodBeat.o(203408);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$7", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "setValue", "", "value", "", "plugin-finder_release"})
  public static final class ak
    implements i
  {
    public final boolean cCl()
    {
      AppMethodBeat.i(203412);
      MediaPreloadCore.a locala = MediaPreloadCore.rvo;
      boolean bool = MediaPreloadCore.cwJ();
      AppMethodBeat.o(203412);
      return bool;
    }
    
    public final void lM(boolean paramBoolean)
    {
      AppMethodBeat.i(203413);
      Object localObject = g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVx, Boolean.valueOf(paramBoolean));
      localObject = MediaPreloadCore.rvo;
      MediaPreloadCore.lB(paramBoolean);
      AppMethodBeat.o(203413);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$8", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "setValue", "", "value", "", "plugin-finder_release"})
  public static final class al
    implements i
  {
    public final boolean cCl()
    {
      AppMethodBeat.i(203414);
      TouchMediaPreviewLayout.a locala = TouchMediaPreviewLayout.Jdj;
      boolean bool = TouchMediaPreviewLayout.fvb();
      AppMethodBeat.o(203414);
      return bool;
    }
    
    public final void lM(boolean paramBoolean)
    {
      AppMethodBeat.i(203415);
      TouchMediaPreviewLayout.a locala = TouchMediaPreviewLayout.Jdj;
      TouchMediaPreviewLayout.xY(paramBoolean);
      AppMethodBeat.o(203415);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class am
    implements MenuItem.OnMenuItemClickListener
  {
    am(FinderSettingsUI paramFinderSettingsUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167660);
      this.rLH.finish();
      AppMethodBeat.o(167660);
      return false;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$13", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class d
    implements j
  {
    d(v.a parama) {}
    
    public final void onClick()
    {
      boolean bool = false;
      AppMethodBeat.i(203367);
      Object localObject1 = this.rLG;
      Object localObject2 = g.agR();
      d.g.b.k.g(localObject2, "MMKernel.storage()");
      ((v.a)localObject1).KUL = ((com.tencent.mm.kernel.e)localObject2).agA().getBoolean(ah.a.GUC, false);
      localObject1 = g.agR();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).agA();
      localObject2 = ah.a.GUC;
      if (!this.rLG.KUL) {
        bool = true;
      }
      ((ae)localObject1).set((ah.a)localObject2, Boolean.valueOf(bool));
      AppMethodBeat.o(203367);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$18", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "setValue", "", "value", "", "plugin-finder_release"})
  public static final class i
    implements i
  {
    public final boolean cCl()
    {
      AppMethodBeat.i(203373);
      FinderHotRelatedUIC.a locala = FinderHotRelatedUIC.sea;
      boolean bool = FinderHotRelatedUIC.cFX();
      AppMethodBeat.o(203373);
      return bool;
    }
    
    public final void lM(boolean paramBoolean)
    {
      AppMethodBeat.i(203374);
      FinderHotRelatedUIC.a locala = FinderHotRelatedUIC.sea;
      FinderHotRelatedUIC.mf(paramBoolean);
      AppMethodBeat.o(203374);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$24", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class p
    implements j
  {
    public final void onClick()
    {
      AppMethodBeat.i(203386);
      LinkedList localLinkedList = new LinkedList();
      List localList = d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
      localLinkedList.add("默认方案");
      localLinkedList.add("拿到就显示");
      localLinkedList.add("显示话题推荐空白页");
      com.tencent.mm.ui.base.h.a((Context)this.rLH, "", (List)localLinkedList, localList, "", (h.d)new a(this));
      AppMethodBeat.o(203386);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
    static final class a
      implements h.d
    {
      a(FinderSettingsUI.p paramp) {}
      
      public final void ct(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(203385);
        try
        {
          com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
          com.tencent.mm.plugin.finder.storage.b.Ec(paramInt1);
          AppMethodBeat.o(203385);
          return;
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace(this.rLI.rLH.TAG, (Throwable)localException, "", new Object[0]);
          AppMethodBeat.o(203385);
        }
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$26", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class r
    implements j
  {
    public final void onClick()
    {
      AppMethodBeat.i(203389);
      a.a locala = com.tencent.mm.plugin.finder.upload.action.a.rNF;
      com.tencent.mm.plugin.finder.upload.action.a.cCF();
      AppMethodBeat.o(203389);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$27", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class s
    implements j
  {
    public final void onClick()
    {
      AppMethodBeat.i(203390);
      com.tencent.mm.kernel.e locale = g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.agA().set(ah.a.GUs, "");
      locale = g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.agA().set(ah.a.GUt, "");
      locale = g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.agA().set(ah.a.GTQ, "");
      locale = g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.agA().set(ah.a.GTR, "");
      locale = g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.agA().set(ah.a.GTS, "");
      locale = g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.agA().set(ah.a.GTT, "");
      locale = g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.agA().set(ah.a.GTU, "");
      locale = g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.agA().set(ah.a.GTV, "");
      locale = g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.agA().set(ah.a.GTW, "");
      locale = g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.agA().set(ah.a.GTY, Integer.valueOf(0));
      locale = g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.agA().set(ah.a.GVa, Boolean.FALSE);
      AppMethodBeat.o(203390);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$28", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class t
    implements j
  {
    public final void onClick()
    {
      AppMethodBeat.i(203391);
      Object localObject = p.rQw;
      p.cDq();
      localObject = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
      boolean bool = com.tencent.mm.plugin.finder.storage.logic.c.aPx();
      localObject = this.rLH.TAG;
      StringBuilder localStringBuilder = new StringBuilder("ret=[").append(bool).append("] finderVideoPath=");
      p localp = p.rQw;
      localStringBuilder = localStringBuilder.append(p.cDn()).append(" finderImgPath=");
      localp = p.rQw;
      ac.i((String)localObject, p.cDm());
      t.makeText(ai.getContext(), (CharSequence)"db: ".concat(String.valueOf(bool)), 1).show();
      AppMethodBeat.o(203391);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$29", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class u
    implements j
  {
    public final void onClick()
    {
      AppMethodBeat.i(203392);
      com.tencent.mm.kernel.e locale = g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.agA().set(ah.a.GUs, "");
      locale = g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.agA().set(ah.a.GUt, "");
      locale = g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.agA().set(ah.a.GVa, Boolean.FALSE);
      AppMethodBeat.o(203392);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$30", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class w
    implements j
  {
    public final void onClick()
    {
      AppMethodBeat.i(203395);
      FinderStreamRefreshPreload.b localb = FinderStreamRefreshPreload.scx;
      FinderStreamRefreshPreload.cFQ();
      AppMethodBeat.o(203395);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$32", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class y
    implements j
  {
    public final void onClick()
    {
      AppMethodBeat.i(203397);
      FinderItem.a locala = FinderItem.rDA;
      FinderItem.access$setDebugOnlySelfSee$cp(true);
      AppMethodBeat.o(203397);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$33", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
  public static final class z
    implements j
  {
    public final void onClick()
    {
      AppMethodBeat.i(203398);
      Object localObject = com.tencent.mm.ui.component.a.IrY;
      com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class);
      localObject = g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(FinderHomeTabStateVM.EX(3), Integer.valueOf(0));
      localObject = g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(FinderHomeTabStateVM.EX(1), Integer.valueOf(0));
      localObject = g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(FinderHomeTabStateVM.EX(4), Integer.valueOf(0));
      localObject = g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(FinderHomeTabStateVM.EX(2), Integer.valueOf(0));
      localObject = g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GUp, Integer.valueOf(0));
      localObject = g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GWf, Boolean.FALSE);
      AppMethodBeat.o(203398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingsUI
 * JD-Core Version:    0.7.0.1
 */