package com.tencent.mm.plugin.finder.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.data.f;
import com.tencent.mm.plugin.finder.storage.data.f.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.pluginsdk.g.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.vfs.i;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "adapter", "Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "mDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$ITestMenu;", "finish", "", "getLayoutId", "", "initOnCreate", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "ChoiceAdapter", "ChoiceItem", "ClickItem", "Companion", "ITestMenu", "plugin-finder_release"})
public final class FinderDebugSettingsUI2
  extends MMFinderUI
{
  public static final d KYf;
  private static final String TAG = "MicroMsg.FinderSettingsUI";
  private a KYe;
  private HashMap _$_findViewCache;
  private ListView izP;
  private final LinkedList<e> qPR;
  
  static
  {
    AppMethodBeat.i(199197);
    KYf = new d((byte)0);
    TAG = "MicroMsg.FinderSettingsUI";
    AppMethodBeat.o(199197);
  }
  
  public FinderDebugSettingsUI2()
  {
    AppMethodBeat.i(199196);
    this.qPR = new LinkedList();
    AppMethodBeat.o(199196);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199199);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(199199);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(199191);
    super.finish();
    com.tencent.mm.plugin.finder.cgi.j localj = com.tencent.mm.plugin.finder.cgi.j.qoO;
    com.tencent.mm.plugin.finder.cgi.j.cky();
    AppMethodBeat.o(199191);
  }
  
  public final int getLayoutId()
  {
    return 2131494110;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(199192);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(paramBundle, "MMKernel.storage()");
    final boolean bool = paramBundle.afk().getBoolean(ae.a.Fxj, false);
    this.qPR.add(new c("暗爽模式", " 当前打开：".concat(String.valueOf(bool)), (View.OnClickListener)new f(this)));
    paramBundle = MediaPreloadCore.KTA;
    Object localObject = new c("开启视频预加载预览View", " 当前为：".concat(String.valueOf(MediaPreloadCore.fTP())), (View.OnClickListener)new au(this));
    this.qPR.add(new c("清除keybuf/账号数据", "点我", (View.OnClickListener)new q()));
    this.qPR.add(new c("清除sdcard数据", "点我", (View.OnClickListener)new ab()));
    this.qPR.add(new c("清空keybuf", "点我", (View.OnClickListener)new am()));
    this.qPR.add(new c("裁剪视频block住", "点我", (View.OnClickListener)new ap()));
    this.qPR.add(new c("二级评论不展开", "点我", (View.OnClickListener)new aq()));
    paramBundle = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.fUt() == 0)
    {
      paramBundle = "默认";
      this.qPR.add(new c("朋友推荐tab-话题推荐调试：".concat(String.valueOf(paramBundle)), "点我", (View.OnClickListener)new ar(this)));
      this.qPR.add(new c("发表feed/评论点赞固定失败", "点我", (View.OnClickListener)new as()));
      this.qPR.add(new c("评论点赞重试间隔改为1s", "点我", (View.OnClickListener)new at()));
      this.qPR.add(new c("清除视频缓存,db缓存,图片缓存", "点我", (View.OnClickListener)g.KYj));
      this.qPR.add(new c("清除所有Finder数据", "点我", (View.OnClickListener)new h(this)));
      this.qPR.add(new c("查看Finder缓存大小", "嗯", (View.OnClickListener)new i(this)));
      this.qPR.add(new b("VideoView组件播放模式", ae.a.FwZ, new String[] { "SINGLE(1)", "MULTI_INSTANCE_WITHOUT_REUSE(2)", "MULTI_INSTANCE_AND_REUSE(0)", "LAZY(3)", "DEFAULT(2)" }, new int[] { 1, 2, 0, 3, 2 }));
      this.qPR.add(new c("评论字数限制10,Media字数15,纯文本字数20", "点我", (View.OnClickListener)new j()));
      this.qPR.add(new c("最大话题数改为3个", "点我", (View.OnClickListener)new k()));
      this.qPR.add(new c("话题最大长度改为10", "点我", (View.OnClickListener)new l()));
      this.qPR.add(new c("话题推荐打开", "点我", (View.OnClickListener)new m()));
      this.qPR.add(new c("双路录制总是打开", "点我", (View.OnClickListener)new n()));
      this.qPR.add(new c("打开切换身份评论", "点我", (View.OnClickListener)new o()));
      this.qPR.add(new c("重置切换身份评论flag", "点我", (View.OnClickListener)new p()));
      LinkedList localLinkedList = this.qPR;
      paramBundle = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.fUy() <= 1) {
        break label2073;
      }
      paramBundle = "附近tab使用瀑布流";
      label788:
      localLinkedList.add(new c(paramBundle, "点我", (View.OnClickListener)new r()));
      this.qPR.add(new c("切换身份评论总是提示", "点我", (View.OnClickListener)new s()));
      this.qPR.add(new c("切换身份评论打开", "点我", (View.OnClickListener)new t()));
      this.qPR.add(new c("最大at数改为3个", "点我", (View.OnClickListener)new u()));
      this.qPR.add(new c("检查文件清理间隔改为1分钟", "点我", (View.OnClickListener)new v()));
      this.qPR.add(new c("重置圈外身份", "点我", (View.OnClickListener)new w()));
      this.qPR.add(new c("复制finder配置到剪贴板", "点我", (View.OnClickListener)new x()));
      this.qPR.add(new c("清理首页文件缓存", "点我", (View.OnClickListener)new y()));
      this.qPR.add(new c("删除posting目录", "点我", (View.OnClickListener)new z()));
      this.qPR.add(new c("发表时删除posting目录", "点我", (View.OnClickListener)new aa()));
      this.qPR.add(new c("上传时删除posting目录", "点我", (View.OnClickListener)new ac()));
      this.qPR.add(new c("把自己改成非白名单用户", "点我", (View.OnClickListener)new ad()));
      this.qPR.add(new c("把所有feed改为仅自己可见", "点我", (View.OnClickListener)new ae()));
      this.qPR.add(localObject);
      this.qPR.add(new b("只看某个feed", ae.a.Fxa, new String[] { "FINDER_FEED_PHOTO", "FINDER_FEED_VIDEO", "FINDER_FEED_MIX_MEDIA", "DEFAULT" }, new int[] { 2, 4, 8, -1 }));
      this.qPR.add(new c("取消假视频", "点我", (View.OnClickListener)new af()));
      paramBundle = this.qPR;
      localObject = TouchMediaPreviewLayout.HCM;
      paramBundle.add(new c("显示视频播放基线:", String.valueOf(TouchMediaPreviewLayout.ffg()), (View.OnClickListener)new ag(this)));
      paramBundle = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramBundle, "MMKernel.storage()");
      paramBundle = paramBundle.afk().get(ae.a.Fxd, Integer.valueOf(0));
      this.qPR.add(new c("发表相机红点重置", String.valueOf(paramBundle), (View.OnClickListener)new ah(this)));
      this.qPR.add(new b("是否启动WhatsNew", ae.a.FwN, new String[] { "关闭(0)", "视频号入口(微博)", "视频号入口(人物)", "地球页(微博)", "地球页(人物)" }, new int[] { 0, 1, 2, 3, 4 }));
      this.qPR.add(new c("清理WhatsNew标记", "点我", (View.OnClickListener)new ai()));
      this.qPR.add(new b("Timeline拉完显示历史或拉更多", ae.a.FwO, new String[] { "按后台给的", "hardcode显示以下历史", "hardcode显示点击拉更多" }, new int[] { 0, 1, 2 }));
      paramBundle = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramBundle, "MMKernel.storage()");
      bool = paramBundle.afk().getBoolean(ae.a.FwQ, false);
      this.qPR.add(new c("内部开启别人粉丝数:", String.valueOf(bool), (View.OnClickListener)new aj(this, bool)));
      paramBundle = this.qPR;
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      paramBundle.add(new c("是否展示更换地址提示", String.valueOf(com.tencent.mm.plugin.finder.storage.b.cqe()), (View.OnClickListener)new ak(this)));
      paramBundle = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramBundle, "MMKernel.storage()");
      if (paramBundle.afk().getInt(ae.a.Fxl, 2) != 2) {
        break label2080;
      }
    }
    label2073:
    label2080:
    for (bool = true;; bool = false)
    {
      this.qPR.add(new c("TL关注是否使用默认方案(B)", String.valueOf(bool), (View.OnClickListener)new al(this, bool)));
      this.qPR.add(new c("重置最后退出TL时间为0", String.valueOf(bool), (View.OnClickListener)new an(this)));
      paramBundle = this.qPR;
      localObject = TouchMediaPreviewLayout.HCM;
      paramBundle.add(new c("手势预览松手弹回", String.valueOf(TouchMediaPreviewLayout.gal()), (View.OnClickListener)new ao(this)));
      this.qPR.add(new b("是否开启手势切Tab", ae.a.LBg, new String[] { "关闭(-1)", "默认(0)", "打开(1)" }, new int[] { -1, 0, 1 }));
      this.qPR.add(new b("选择分段拍摄器", ae.a.LBq, new String[] { "现网", "开发版" }, new int[] { 0, 1 }));
      this.qPR.add(new b("红点不受配置时间限制", ae.a.Fwu, new String[] { "默认", "无限制" }, new int[] { 1, 1000000000 }));
      this.qPR.add(new b("后台合成", ae.a.LBw, new String[] { "X实验配置", "否", "是" }, new int[] { -1, 0, 1 }));
      paramBundle = findViewById(2131300026);
      if (paramBundle != null) {
        break label2085;
      }
      paramBundle = new v("null cannot be cast to non-null type android.widget.ListView");
      AppMethodBeat.o(199192);
      throw paramBundle;
      paramBundle = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.fUt() == 1)
      {
        paramBundle = "拿到就显示";
        break;
      }
      paramBundle = "显示话题推荐空白页";
      break;
      paramBundle = "附近tab使用卡片流";
      break label788;
    }
    label2085:
    this.izP = ((ListView)paramBundle);
    this.KYe = new a();
    paramBundle = this.izP;
    if (paramBundle == null) {
      d.g.b.k.fvU();
    }
    localObject = this.KYe;
    if (localObject == null) {
      d.g.b.k.aPZ("adapter");
    }
    paramBundle.setAdapter((ListAdapter)localObject);
    setBackBtn((MenuItem.OnMenuItemClickListener)new av(this));
    AppMethodBeat.o(199192);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(199193);
    super.onDestroy();
    AppMethodBeat.o(199193);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(199195);
    super.onPause();
    AppMethodBeat.o(199195);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(199194);
    super.onResume();
    AppMethodBeat.o(199194);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-finder_release"})
  public final class a
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(199136);
      int i = FinderDebugSettingsUI2.b(this.KYg).size();
      AppMethodBeat.o(199136);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(199137);
      Object localObject = FinderDebugSettingsUI2.b(this.KYg).get(paramInt);
      d.g.b.k.g(localObject, "selectsList[position]");
      AppMethodBeat.o(199137);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    @SuppressLint({"SetTextI18n"})
    public final View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(199138);
      d.g.b.k.h(paramViewGroup, "parent");
      paramView = new TextView((Context)this.KYg);
      paramViewGroup = getItem(paramInt);
      if (paramViewGroup == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderDebugSettingsUI2.ITestMenu");
        AppMethodBeat.o(199138);
        throw paramView;
      }
      paramViewGroup = (FinderDebugSettingsUI2.e)paramViewGroup;
      paramView.setTag(paramViewGroup);
      paramView.setText((CharSequence)(paramViewGroup.aaO() + "->:" + paramViewGroup.value()));
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 50));
      if (paramInt % 2 == 1)
      {
        AppCompatActivity localAppCompatActivity = this.KYg.getContext();
        d.g.b.k.g(localAppCompatActivity, "context");
        paramView.setBackgroundColor(localAppCompatActivity.getResources().getColor(2131099741));
      }
      paramView.setOnClickListener((View.OnClickListener)new a(paramViewGroup, paramView));
      paramView = (View)paramView;
      AppMethodBeat.o(199138);
      return paramView;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderDebugSettingsUI2.e parame, TextView paramTextView) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(199135);
        this.KYh.dT((View)paramView);
        AppMethodBeat.o(199135);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$29", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class aa
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199168);
      paramView = com.tencent.mm.plugin.finder.upload.g.qRm;
      com.tencent.mm.plugin.finder.upload.g.crE();
      AppMethodBeat.o(199168);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class ab
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199169);
      paramView = new StringBuilder();
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      i.deleteDir(locale.getAccPath() + "finder");
      paramView = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
      boolean bool = com.tencent.mm.plugin.finder.storage.logic.c.aIG();
      t.makeText(aj.getContext(), (CharSequence)"好了 ".concat(String.valueOf(bool)), 1).show();
      AppMethodBeat.o(199169);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$30", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class ac
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199170);
      paramView = com.tencent.mm.plugin.finder.upload.j.qRB;
      com.tencent.mm.plugin.finder.upload.j.crG();
      AppMethodBeat.o(199170);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$31", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class ad
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199171);
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).closeFinderEntryForDebug();
      AppMethodBeat.o(199171);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$32", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class ae
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199172);
      paramView = FinderItem.qJU;
      FinderItem.access$setDebugOnlySelfSee$cp(true);
      AppMethodBeat.o(199172);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$33", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class af
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199173);
      paramView = d.qJI;
      d.cqm();
      AppMethodBeat.o(199173);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$34", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class ag
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      boolean bool2 = true;
      AppMethodBeat.i(199174);
      d.g.b.k.h(paramView, "v");
      Object localObject = paramView.getTag();
      paramView = (View)localObject;
      if (!(localObject instanceof FinderDebugSettingsUI2.c)) {
        paramView = null;
      }
      paramView = (FinderDebugSettingsUI2.c)paramView;
      if (paramView != null)
      {
        localObject = TouchMediaPreviewLayout.HCM;
        if (!TouchMediaPreviewLayout.ffg())
        {
          bool1 = true;
          paramView.setValue(String.valueOf(bool1));
        }
      }
      else
      {
        paramView = TouchMediaPreviewLayout.HCM;
        paramView = TouchMediaPreviewLayout.HCM;
        if (TouchMediaPreviewLayout.ffg()) {
          break label103;
        }
      }
      label103:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        TouchMediaPreviewLayout.wR(bool1);
        FinderDebugSettingsUI2.a(this.KYg).notifyDataSetChanged();
        AppMethodBeat.o(199174);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ah
    implements View.OnClickListener
  {
    ah(FinderDebugSettingsUI2 paramFinderDebugSettingsUI2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199175);
      Object localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fxd, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject).getRedDotManager().ahg(-1);
      d.g.b.k.g(paramView, "v");
      localObject = paramView.getTag();
      paramView = (View)localObject;
      if (!(localObject instanceof FinderDebugSettingsUI2.c)) {
        paramView = null;
      }
      paramView = (FinderDebugSettingsUI2.c)paramView;
      if (paramView != null) {
        paramView.setValue("0");
      }
      FinderDebugSettingsUI2.a(this.KYg).notifyDataSetChanged();
      AppMethodBeat.o(199175);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$36", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class ai
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199176);
      paramView = com.tencent.mm.plugin.finder.view.whatnews.a.qZx;
      com.tencent.mm.plugin.finder.view.whatnews.a.ctk();
      t.makeText(aj.getContext(), (CharSequence)"清理成功，重启生效", 1).show();
      AppMethodBeat.o(199176);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$37", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class aj
    implements View.OnClickListener
  {
    aj(boolean paramBoolean) {}
    
    public final void onClick(View paramView)
    {
      boolean bool2 = true;
      AppMethodBeat.i(199177);
      d.g.b.k.h(paramView, "v");
      Object localObject = paramView.getTag();
      paramView = (View)localObject;
      if (!(localObject instanceof FinderDebugSettingsUI2.c)) {
        paramView = null;
      }
      paramView = (FinderDebugSettingsUI2.c)paramView;
      if (paramView != null)
      {
        if (!bool)
        {
          bool1 = true;
          paramView.setValue(String.valueOf(bool1));
        }
      }
      else
      {
        paramView = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramView, "MMKernel.storage()");
        paramView = paramView.afk();
        localObject = ae.a.FwQ;
        if (bool) {
          break label118;
        }
      }
      label118:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramView.set((ae.a)localObject, Boolean.valueOf(bool1));
        FinderDebugSettingsUI2.a(this.KYg).notifyDataSetChanged();
        AppMethodBeat.o(199177);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$38", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class ak
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199178);
      d.g.b.k.h(paramView, "v");
      paramView = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.Fxm, Long.valueOf(0L));
      FinderDebugSettingsUI2.a(this.KYg).notifyDataSetChanged();
      AppMethodBeat.o(199178);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$39", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class al
    implements View.OnClickListener
  {
    al(boolean paramBoolean) {}
    
    public final void onClick(View paramView)
    {
      int i = 1;
      AppMethodBeat.i(199179);
      d.g.b.k.h(paramView, "v");
      Object localObject = paramView.getTag();
      paramView = (View)localObject;
      if (!(localObject instanceof FinderDebugSettingsUI2.c)) {
        paramView = null;
      }
      paramView = (FinderDebugSettingsUI2.c)paramView;
      boolean bool;
      if (paramView != null)
      {
        if (!bool)
        {
          bool = true;
          paramView.setValue(String.valueOf(bool));
        }
      }
      else
      {
        paramView = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramView, "MMKernel.storage()");
        paramView = paramView.afk();
        localObject = ae.a.Fxl;
        if (!bool) {
          break label116;
        }
      }
      for (;;)
      {
        paramView.set((ae.a)localObject, Integer.valueOf(i));
        FinderDebugSettingsUI2.a(this.KYg).notifyDataSetChanged();
        AppMethodBeat.o(199179);
        return;
        bool = false;
        break;
        label116:
        i = 2;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$4", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class am
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199180);
      paramView = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.Fwq, "");
      paramView = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.Fwr, "");
      t.makeText(aj.getContext(), (CharSequence)"好了", 1).show();
      AppMethodBeat.o(199180);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class an
    implements View.OnClickListener
  {
    an(FinderDebugSettingsUI2 paramFinderDebugSettingsUI2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199181);
      paramView = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.Fwt, Long.valueOf(0L));
      FinderDebugSettingsUI2.a(this.KYg).notifyDataSetChanged();
      AppMethodBeat.o(199181);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$41", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class ao
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199182);
      d.g.b.k.h(paramView, "v");
      Object localObject = TouchMediaPreviewLayout.HCM;
      localObject = TouchMediaPreviewLayout.HCM;
      if (!TouchMediaPreviewLayout.gal()) {}
      for (boolean bool = true;; bool = false)
      {
        TouchMediaPreviewLayout.zi(bool);
        localObject = paramView.getTag();
        paramView = (View)localObject;
        if (!(localObject instanceof FinderDebugSettingsUI2.c)) {
          paramView = null;
        }
        paramView = (FinderDebugSettingsUI2.c)paramView;
        if (paramView != null)
        {
          localObject = TouchMediaPreviewLayout.HCM;
          paramView.setValue(String.valueOf(TouchMediaPreviewLayout.gal()));
        }
        FinderDebugSettingsUI2.a(this.KYg).notifyDataSetChanged();
        AppMethodBeat.o(199182);
        return;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$5", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class ap
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199183);
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.coZ();
      AppMethodBeat.o(199183);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$6", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class aq
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199184);
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.yI(false);
      AppMethodBeat.o(199184);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$7", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class ar
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199186);
      paramView = new LinkedList();
      List localList = d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
      paramView.add("默认方案");
      paramView.add("拿到就显示");
      paramView.add("显示话题推荐空白页");
      h.a((Context)this.KYg, "", (List)paramView, localList, "", (h.d)new a(this));
      AppMethodBeat.o(199186);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
    static final class a
      implements h.d
    {
      a(FinderDebugSettingsUI2.ar paramar) {}
      
      public final void cv(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(199185);
        try
        {
          com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
          com.tencent.mm.plugin.finder.storage.b.ahu(paramInt1);
          FinderDebugSettingsUI2.a(this.KYm.KYg).notifyDataSetChanged();
          AppMethodBeat.o(199185);
          return;
        }
        catch (Exception localException)
        {
          FinderDebugSettingsUI2.d locald = FinderDebugSettingsUI2.KYf;
          ad.printErrStackTrace(FinderDebugSettingsUI2.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
          AppMethodBeat.o(199185);
        }
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$8", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class as
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199187);
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.ld(true);
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.cpb();
      t.makeText(aj.getContext(), (CharSequence)"好了", 1).show();
      AppMethodBeat.o(199187);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$9", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class at
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199188);
      paramView = com.tencent.mm.plugin.finder.upload.action.a.qRF;
      com.tencent.mm.plugin.finder.upload.action.a.crK();
      t.makeText(aj.getContext(), (CharSequence)"好了", 1).show();
      AppMethodBeat.o(199188);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class au
    implements View.OnClickListener
  {
    au(FinderDebugSettingsUI2 paramFinderDebugSettingsUI2) {}
    
    public final void onClick(View paramView)
    {
      boolean bool2 = true;
      AppMethodBeat.i(199189);
      Object localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).afk();
      ae.a locala = ae.a.Fxh;
      MediaPreloadCore.a locala1 = MediaPreloadCore.KTA;
      if (!MediaPreloadCore.fTP())
      {
        bool1 = true;
        ((ab)localObject).set(locala, Boolean.valueOf(bool1));
        d.g.b.k.g(paramView, "v");
        localObject = paramView.getTag();
        paramView = (View)localObject;
        if (!(localObject instanceof FinderDebugSettingsUI2.c)) {
          paramView = null;
        }
        paramView = (FinderDebugSettingsUI2.c)paramView;
        if (paramView != null)
        {
          localObject = MediaPreloadCore.KTA;
          if (MediaPreloadCore.fTP()) {
            break label151;
          }
          bool1 = true;
          label102:
          paramView.setValue(String.valueOf(bool1));
        }
        paramView = MediaPreloadCore.KTA;
        paramView = MediaPreloadCore.KTA;
        if (MediaPreloadCore.fTP()) {
          break label156;
        }
      }
      label151:
      label156:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        MediaPreloadCore.yD(bool1);
        FinderDebugSettingsUI2.a(this.KYg).notifyDataSetChanged();
        AppMethodBeat.o(199189);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label102;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class av
    implements MenuItem.OnMenuItemClickListener
  {
    av(FinderDebugSettingsUI2 paramFinderDebugSettingsUI2) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(199190);
      this.KYg.finish();
      AppMethodBeat.o(199190);
      return false;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$ChoiceItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-finder_release"})
  public final class b
    implements FinderDebugSettingsUI2.e
  {
    private String qPW;
    ae.a qPX;
    private String[] qPY;
    Object qPZ;
    
    public b(ae.a parama, String[] paramArrayOfString, Object paramObject)
    {
      AppMethodBeat.i(199142);
      this.qPW = parama;
      this.qPX = paramArrayOfString;
      this.qPY = paramObject;
      this.qPZ = localObject;
      AppMethodBeat.o(199142);
    }
    
    public final String aaO()
    {
      return this.qPW;
    }
    
    public final void dT(View paramView)
    {
      AppMethodBeat.i(199141);
      d.g.b.k.h(paramView, "view");
      paramView = new LinkedList();
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      int j = this.qPY.length;
      while (i < j)
      {
        paramView.add(this.qPY[i]);
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      h.a((Context)FinderDebugSettingsUI2.this, "", (List)paramView, (List)localLinkedList, "", (h.d)new a(this));
      AppMethodBeat.o(199141);
    }
    
    public final String value()
    {
      AppMethodBeat.i(199140);
      if ((this.qPZ instanceof long[]))
      {
        localObject1 = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(localObject1, "MMKernel.storage()");
      }
      int k;
      int i;
      int i1;
      int j;
      for (int m = (int)((com.tencent.mm.kernel.e)localObject1).afk().a(this.qPX, 0L);; m = ((com.tencent.mm.kernel.e)localObject1).afk().getInt(this.qPX, 0))
      {
        k = -1;
        localObject2 = this.qPZ;
        localObject1 = localObject2;
        if (!(localObject2 instanceof int[])) {
          localObject1 = null;
        }
        localObject1 = (int[])localObject1;
        i = k;
        if (localObject1 == null) {
          break;
        }
        i1 = localObject1.length;
        n = 0;
        j = 0;
        for (;;)
        {
          i = k;
          if (n >= i1) {
            break;
          }
          if (localObject1[n] == m) {
            k = j;
          }
          n += 1;
          j += 1;
        }
        localObject1 = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(localObject1, "MMKernel.storage()");
      }
      Object localObject2 = this.qPZ;
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof long[])) {
        localObject1 = null;
      }
      localObject1 = (long[])localObject1;
      if (localObject1 != null)
      {
        i1 = localObject1.length;
        k = 0;
        n = 0;
        j = i;
        i = n;
        for (;;)
        {
          n = j;
          if (k >= i1) {
            break;
          }
          if ((int)localObject1[k] == m) {
            j = i;
          }
          k += 1;
          i += 1;
        }
      }
      int n = i;
      if ((n >= 0) && (n < this.qPY.length))
      {
        localObject1 = this.qPY[n];
        AppMethodBeat.o(199140);
        return localObject1;
      }
      AppMethodBeat.o(199140);
      return "";
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
    static final class a
      implements h.d
    {
      a(FinderDebugSettingsUI2.b paramb) {}
      
      public final void cv(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(199139);
        Object localObject3;
        Object localObject4;
        try
        {
          Object localObject1 = this.KYi.qPZ;
          if (!(localObject1 instanceof long[])) {
            break label138;
          }
          localObject1 = com.tencent.mm.kernel.g.afB();
          d.g.b.k.g(localObject1, "MMKernel.storage()");
          localObject1 = ((com.tencent.mm.kernel.e)localObject1).afk();
          localObject3 = this.KYi.qPX;
          localObject4 = this.KYi.qPZ;
          if (localObject4 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type kotlin.LongArray");
            AppMethodBeat.o(199139);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          localObject3 = FinderDebugSettingsUI2.KYf;
          ad.printErrStackTrace(FinderDebugSettingsUI2.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
          AppMethodBeat.o(199139);
          return;
        }
        localException.set((ae.a)localObject3, Long.valueOf(((long[])localObject4)[paramInt1]));
        for (;;)
        {
          FinderDebugSettingsUI2.a(this.KYi.KYg).notifyDataSetChanged();
          AppMethodBeat.o(199139);
          return;
          label138:
          if ((localException instanceof int[]))
          {
            Object localObject2 = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(localObject2, "MMKernel.storage()");
            localObject2 = ((com.tencent.mm.kernel.e)localObject2).afk();
            localObject3 = this.KYi.qPX;
            localObject4 = this.KYi.qPZ;
            if (localObject4 == null)
            {
              localObject2 = new v("null cannot be cast to non-null type kotlin.IntArray");
              AppMethodBeat.o(199139);
              throw ((Throwable)localObject2);
            }
            ((ab)localObject2).set((ae.a)localObject3, Integer.valueOf(((int[])localObject4)[paramInt1]));
          }
        }
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$ClickItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$ITestMenu;", "title", "", "value", "clickEvent", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "getClickEvent", "()Landroid/view/View$OnClickListener;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getValue", "setValue", "showAlert", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class c
    implements FinderDebugSettingsUI2.e
  {
    private final View.OnClickListener qQb;
    private String title;
    private String value;
    
    public c(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(199145);
      this.title = paramString1;
      this.value = paramString2;
      this.qQb = paramOnClickListener;
      AppMethodBeat.o(199145);
    }
    
    public final String aaO()
    {
      return this.title;
    }
    
    public final void dT(View paramView)
    {
      AppMethodBeat.i(199143);
      d.g.b.k.h(paramView, "view");
      this.qQb.onClick(paramView);
      t.makeText(aj.getContext(), (CharSequence)"ClickItem Done", 1).show();
      AppMethodBeat.o(199143);
    }
    
    public final void setValue(String paramString)
    {
      AppMethodBeat.i(199144);
      d.g.b.k.h(paramString, "<set-?>");
      this.value = paramString;
      AppMethodBeat.o(199144);
    }
    
    public final String value()
    {
      return this.value;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class d {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$ITestMenu;", "", "showAlert", "", "view", "Landroid/view/View;", "title", "", "value", "plugin-finder_release"})
  public static abstract interface e
  {
    public abstract String aaO();
    
    public abstract void dT(View paramView);
    
    public abstract String value();
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderDebugSettingsUI2 paramFinderDebugSettingsUI2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199146);
      Object localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      if (!((com.tencent.mm.kernel.e)localObject).afk().getBoolean(ae.a.Fxj, false)) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fxj, Boolean.valueOf(bool));
        d.g.b.k.g(paramView, "v");
        localObject = paramView.getTag();
        paramView = (View)localObject;
        if (!(localObject instanceof FinderDebugSettingsUI2.c)) {
          paramView = null;
        }
        paramView = (FinderDebugSettingsUI2.c)paramView;
        if (paramView != null) {
          paramView.setValue(String.valueOf(bool));
        }
        FinderDebugSettingsUI2.a(this.KYg).notifyDataSetChanged();
        AppMethodBeat.o(199146);
        return;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    public static final g KYj;
    
    static
    {
      AppMethodBeat.i(199148);
      KYj = new g();
      AppMethodBeat.o(199148);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199147);
      paramView = com.tencent.mm.plugin.finder.utils.k.qTp;
      boolean bool1 = i.deleteDir(com.tencent.mm.plugin.finder.utils.k.crW());
      paramView = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
      boolean bool2 = com.tencent.mm.plugin.finder.storage.logic.c.aIG();
      paramView = com.tencent.mm.plugin.finder.utils.k.qTp;
      boolean bool3 = i.deleteDir(com.tencent.mm.plugin.finder.utils.k.crV());
      paramView = FinderDebugSettingsUI2.KYf;
      paramView = FinderDebugSettingsUI2.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("ret=[").append(bool1).append(':').append(bool2).append(':').append(bool3).append("] finderVideoPath=");
      com.tencent.mm.plugin.finder.utils.k localk = com.tencent.mm.plugin.finder.utils.k.qTp;
      localStringBuilder = localStringBuilder.append(com.tencent.mm.plugin.finder.utils.k.crW()).append(" finderImgPath=");
      localk = com.tencent.mm.plugin.finder.utils.k.qTp;
      ad.i(paramView, com.tencent.mm.plugin.finder.utils.k.crV());
      t.makeText(aj.getContext(), (CharSequence)("del file " + bool1 + " db: " + bool2 + " img: " + bool3), 1).show();
      AppMethodBeat.o(199147);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderDebugSettingsUI2 paramFinderDebugSettingsUI2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199149);
      paramView = new StringBuilder();
      Object localObject1 = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      paramView = ((com.tencent.mm.kernel.e)localObject1).getAccPath() + "finder/";
      localObject1 = new StringBuilder();
      Object localObject2 = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject2, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject2).aff() + "FinderMM029.db";
      boolean bool1 = i.deleteDir(paramView);
      boolean bool2 = i.deleteFile((String)localObject1);
      localObject2 = f.qKv;
      f.a.clearAll();
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).resetLastTimelineExitTime();
      localObject2 = com.tencent.mm.ui.component.a.LCX;
      ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class)).fXi();
      localObject2 = FinderDebugSettingsUI2.KYf;
      ad.i(FinderDebugSettingsUI2.access$getTAG$cp(), "ret=[" + bool1 + ':' + bool2 + "] dataFilePath=" + paramView + " dbFilePath=" + (String)localObject1);
      t.makeText(aj.getContext(), (CharSequence)("del file " + bool1 + " db: " + bool2), 1).show();
      if (com.tencent.mm.pluginsdk.g.e.ewc() != null) {
        com.tencent.mm.pluginsdk.g.e.ewc().bw((Context)this.KYg.getContext());
      }
      AppMethodBeat.o(199149);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$12", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class i
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199150);
      paramView = com.tencent.mm.plugin.finder.utils.k.qTp;
      paramView = com.tencent.mm.plugin.finder.utils.k.cse();
      h.R((Context)this.KYg.getContext(), paramView, "嗯");
      AppMethodBeat.o(199150);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$13", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class j
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199151);
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.cpp();
      AppMethodBeat.o(199151);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$14", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class k
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199152);
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.cpK();
      AppMethodBeat.o(199152);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$15", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class l
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199153);
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.cpM();
      AppMethodBeat.o(199153);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$16", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class m
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199154);
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.ahs(1);
      AppMethodBeat.o(199154);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$17", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class n
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199155);
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.cqf();
      AppMethodBeat.o(199155);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$18", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class o
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199156);
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.yH(true);
      AppMethodBeat.o(199156);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$19", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class p
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199157);
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.le(true);
      AppMethodBeat.o(199157);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class q
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199158);
      paramView = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.Fwq, "");
      paramView = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.Fwr, "");
      paramView = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.FvW, "");
      paramView = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.FvX, "");
      paramView = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.FvY, "");
      paramView = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.FvZ, "");
      paramView = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.Fwa, "");
      paramView = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.Fwb, "");
      paramView = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.Fwc, "");
      paramView = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.Fwe, Integer.valueOf(0));
      paramView = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.FwM, Boolean.FALSE);
      t.makeText(aj.getContext(), (CharSequence)"好了", 1).show();
      AppMethodBeat.o(199158);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$20", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class r
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199159);
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.fUy() > 1)
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
        com.tencent.mm.plugin.finder.storage.b.ahv(1);
        AppMethodBeat.o(199159);
        return;
      }
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.ahv(2);
      AppMethodBeat.o(199159);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$21", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class s
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199160);
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.yG(true);
      AppMethodBeat.o(199160);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$22", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class t
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199161);
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.yH(true);
      AppMethodBeat.o(199161);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$23", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class u
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199162);
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.fUi();
      AppMethodBeat.o(199162);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$24", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class v
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199163);
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.cpd();
      AppMethodBeat.o(199163);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$25", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class w
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199164);
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).resetConfig();
      AppMethodBeat.o(199164);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$26", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class x
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199165);
      paramView = new StringBuilder("clicfg_ultron_finder_search_only_contact_android: ");
      Object localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      paramView = paramView.append(com.tencent.mm.plugin.finder.storage.b.cpr()).append('\n').append("clicfg_ultron_timeline_publish_entrance_switch_android:");
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      paramView = paramView.append(com.tencent.mm.plugin.finder.storage.b.cps()).append('\n').append("clicfg_ultron_finder_show_reddot_number_attab_android:");
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      paramView = paramView.append(com.tencent.mm.plugin.finder.storage.b.cpt()).append('\n').append("clicfg_ultron_record_video_max_duration_android:");
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      paramView = paramView.append(com.tencent.mm.plugin.finder.storage.b.coB().duration).append('\n').append("clicfg_ultron_record_video_min_duration_android:");
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      paramView = paramView.append(com.tencent.mm.plugin.finder.storage.b.coB().minDuration).append('\n').append("clicfg_ultron_album_video_max_duration_android:");
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      paramView = paramView.append(com.tencent.mm.plugin.finder.storage.b.coC().duration).append('\n').append("clicfg_ultron_album_video_min_duration_android:");
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      paramView = com.tencent.mm.plugin.finder.storage.b.coC().minDuration + '\n' + "clicfg_ultron_album_video_max_select_duration_android:" + ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pru, 300);
      localObject = new StringBuilder("MXM_DynaCfg_AV_Item_Key_FinderCommentTextLimit:");
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cpm()).append('\n').append("MXM_DynaCfg_AV_Item_Key_FinderCommentTextLimit:");
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cpn()).append('\n').append("clicfg_ultron_finder_folder_size_dump_interval:");
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cpc()).append('\n').append("clicfg_ultron_finder_folder_size_image:");
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cpf()).append('\n').append("clicfg_ultron_finder_folder_size_avatar:");
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cpg()).append('\n').append("clicfg_ultron_finder_folder_size_cropimg:");
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cph()).append('\n').append("clicfg_ultron_finder_folder_size_video:");
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cpi()).append('\n').append("clicfg_ultron_finder_folder_size_tmp:");
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cpj()).append('\n').append("clicfg_ultron_finder_folder_size_capture:");
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cpk()).append('\n').append("clicfg_ultron_finder_folder_size_posttmp:");
      localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cpl()).append('\n');
      localObject = aj.getContext().getSystemService("clipboard");
      if (localObject == null)
      {
        paramView = new v("null cannot be cast to non-null type android.content.ClipboardManager");
        AppMethodBeat.o(199165);
        throw paramView;
      }
      ((ClipboardManager)localObject).setText((CharSequence)paramView);
      t.makeText(aj.getContext(), (CharSequence)paramView, 1).show();
      AppMethodBeat.o(199165);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$27", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class y
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199166);
      paramView = f.qKv;
      f.a.clearAll();
      AppMethodBeat.o(199166);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$28", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class z
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199167);
      paramView = com.tencent.mm.plugin.finder.utils.k.qTp;
      i.cO(com.tencent.mm.plugin.finder.utils.k.csd(), true);
      AppMethodBeat.o(199167);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderDebugSettingsUI2
 * JD-Core Version:    0.7.0.1
 */