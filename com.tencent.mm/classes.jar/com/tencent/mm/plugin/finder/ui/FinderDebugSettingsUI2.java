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
import com.tencent.mm.plugin.finder.cgi.s;
import com.tencent.mm.plugin.finder.extension.reddot.d;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.i.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.pluginsdk.g.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import d.g.b.k;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "adapter", "Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "mDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$ITestMenu;", "finish", "", "getLayoutId", "", "initOnCreate", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "ChoiceAdapter", "ChoiceItem", "ClickItem", "Companion", "ITestMenu", "plugin-finder_release"})
public final class FinderDebugSettingsUI2
  extends MMFinderUI
{
  private static final String TAG = "MicroMsg.FinderSettingsUI";
  public static final FinderDebugSettingsUI2.d rHb;
  private HashMap _$_findViewCache;
  private final LinkedList<e> gFp;
  private ListView gFr;
  private a rHa;
  
  static
  {
    AppMethodBeat.i(203167);
    rHb = new FinderDebugSettingsUI2.d((byte)0);
    TAG = "MicroMsg.FinderSettingsUI";
    AppMethodBeat.o(203167);
  }
  
  public FinderDebugSettingsUI2()
  {
    AppMethodBeat.i(203166);
    this.gFp = new LinkedList();
    AppMethodBeat.o(203166);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203169);
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
    AppMethodBeat.o(203169);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(203161);
    super.finish();
    s locals = s.qXL;
    s.csj();
    AppMethodBeat.o(203161);
  }
  
  public final int getLayoutId()
  {
    return 2131494110;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203162);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.kernel.g.agR();
    k.g(paramBundle, "MMKernel.storage()");
    final boolean bool = paramBundle.agA().getBoolean(ah.a.GVz, false);
    this.gFp.add(new FinderDebugSettingsUI2.c("暗爽模式", " 当前打开：".concat(String.valueOf(bool)), (View.OnClickListener)new f(this)));
    paramBundle = MediaPreloadCore.rvo;
    Object localObject = new FinderDebugSettingsUI2.c("开启视频预加载预览View", " 当前为：".concat(String.valueOf(MediaPreloadCore.cwJ())), (View.OnClickListener)new au(this));
    this.gFp.add(new FinderDebugSettingsUI2.c("清除keybuf/账号数据", "点我", (View.OnClickListener)new q()));
    this.gFp.add(new FinderDebugSettingsUI2.c("清除sdcard数据", "点我", (View.OnClickListener)new ab()));
    this.gFp.add(new FinderDebugSettingsUI2.c("清空keybuf", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.am()));
    this.gFp.add(new FinderDebugSettingsUI2.c("裁剪视频block住", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.ap()));
    this.gFp.add(new FinderDebugSettingsUI2.c("二级评论不展开", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.aq()));
    paramBundle = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.czQ() == 0)
    {
      paramBundle = "默认";
      this.gFp.add(new FinderDebugSettingsUI2.c("朋友推荐tab-话题推荐调试：".concat(String.valueOf(paramBundle)), "点我", (View.OnClickListener)new ar(this)));
      this.gFp.add(new FinderDebugSettingsUI2.c("发表feed/评论点赞固定失败", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.as()));
      this.gFp.add(new FinderDebugSettingsUI2.c("评论点赞重试间隔改为1s", "点我", (View.OnClickListener)new at()));
      this.gFp.add(new FinderDebugSettingsUI2.c("清除视频缓存,db缓存,图片缓存", "点我", (View.OnClickListener)g.rHg));
      this.gFp.add(new FinderDebugSettingsUI2.c("清除所有Finder数据", "点我", (View.OnClickListener)new h(this)));
      this.gFp.add(new FinderDebugSettingsUI2.c("查看Finder缓存大小", "嗯", (View.OnClickListener)new i(this)));
      this.gFp.add(new b("VideoView组件播放模式", ah.a.GVp, new String[] { "SINGLE(1)", "MULTI_INSTANCE_WITHOUT_REUSE(2)", "MULTI_INSTANCE_AND_REUSE(0)", "LAZY(3)", "DEFAULT(2)" }, new int[] { 1, 2, 0, 3, 2 }));
      this.gFp.add(new FinderDebugSettingsUI2.c("评论字数限制10,Media字数15,纯文本字数20", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.j()));
      this.gFp.add(new FinderDebugSettingsUI2.c("最大话题数改为3个", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.k()));
      this.gFp.add(new FinderDebugSettingsUI2.c("话题最大长度改为10", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.l()));
      this.gFp.add(new FinderDebugSettingsUI2.c("话题推荐打开", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.m()));
      this.gFp.add(new FinderDebugSettingsUI2.c("双路录制总是打开", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.n()));
      this.gFp.add(new FinderDebugSettingsUI2.c("打开切换身份评论", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.o()));
      this.gFp.add(new FinderDebugSettingsUI2.c("重置切换身份评论flag", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.p()));
      LinkedList localLinkedList = this.gFp;
      paramBundle = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.czV() <= 1) {
        break label2067;
      }
      paramBundle = "附近tab使用瀑布流";
      label785:
      localLinkedList.add(new FinderDebugSettingsUI2.c(paramBundle, "点我", (View.OnClickListener)new FinderDebugSettingsUI2.r()));
      this.gFp.add(new FinderDebugSettingsUI2.c("切换身份评论总是提示", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.s()));
      this.gFp.add(new FinderDebugSettingsUI2.c("切换身份评论打开", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.t()));
      this.gFp.add(new FinderDebugSettingsUI2.c("最大at数改为3个", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.u()));
      this.gFp.add(new FinderDebugSettingsUI2.c("检查文件清理间隔改为1分钟", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.v()));
      this.gFp.add(new FinderDebugSettingsUI2.c("重置圈外身份", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.w()));
      this.gFp.add(new FinderDebugSettingsUI2.c("复制finder配置到剪贴板", "点我", (View.OnClickListener)new x()));
      this.gFp.add(new FinderDebugSettingsUI2.c("清理首页文件缓存", "点我", (View.OnClickListener)new y()));
      this.gFp.add(new FinderDebugSettingsUI2.c("删除posting目录", "点我", (View.OnClickListener)new z()));
      this.gFp.add(new FinderDebugSettingsUI2.c("发表时删除posting目录", "点我", (View.OnClickListener)new aa()));
      this.gFp.add(new FinderDebugSettingsUI2.c("上传时删除posting目录", "点我", (View.OnClickListener)new ac()));
      this.gFp.add(new FinderDebugSettingsUI2.c("把自己改成非白名单用户", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.ad()));
      this.gFp.add(new FinderDebugSettingsUI2.c("把所有feed改为仅自己可见", "点我", (View.OnClickListener)new ae()));
      this.gFp.add(localObject);
      this.gFp.add(new b("只看某个feed", ah.a.GVq, new String[] { "FINDER_FEED_PHOTO", "FINDER_FEED_VIDEO", "FINDER_FEED_MIX_MEDIA", "DEFAULT" }, new int[] { 2, 4, 8, -1 }));
      this.gFp.add(new FinderDebugSettingsUI2.c("取消假视频", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.af()));
      paramBundle = this.gFp;
      localObject = TouchMediaPreviewLayout.Jdj;
      paramBundle.add(new FinderDebugSettingsUI2.c("显示视频播放基线:", String.valueOf(TouchMediaPreviewLayout.fvb()), (View.OnClickListener)new ag(this)));
      paramBundle = com.tencent.mm.kernel.g.agR();
      k.g(paramBundle, "MMKernel.storage()");
      paramBundle = paramBundle.agA().get(ah.a.GVt, Integer.valueOf(0));
      this.gFp.add(new FinderDebugSettingsUI2.c("发表相机红点重置", String.valueOf(paramBundle), (View.OnClickListener)new ah(this)));
      this.gFp.add(new b("是否启动WhatsNew", ah.a.GVb, new String[] { "关闭(0)", "视频号入口(微博)", "视频号入口(人物)", "地球页(微博)", "地球页(人物)" }, new int[] { 0, 1, 2, 3, 4 }));
      this.gFp.add(new FinderDebugSettingsUI2.c("清理WhatsNew标记", "点我", (View.OnClickListener)new FinderDebugSettingsUI2.ai()));
      this.gFp.add(new b("Timeline拉完显示历史或拉更多", ah.a.GVf, new String[] { "按后台给的", "hardcode显示以下历史", "hardcode显示点击拉更多" }, new int[] { 0, 1, 2 }));
      paramBundle = com.tencent.mm.kernel.g.agR();
      k.g(paramBundle, "MMKernel.storage()");
      bool = paramBundle.agA().getBoolean(ah.a.GVg, false);
      this.gFp.add(new FinderDebugSettingsUI2.c("内部开启别人粉丝数:", String.valueOf(bool), (View.OnClickListener)new aj(this, bool)));
      paramBundle = this.gFp;
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      paramBundle.add(new FinderDebugSettingsUI2.c("是否展示更换地址提示", String.valueOf(com.tencent.mm.plugin.finder.storage.b.czF()), (View.OnClickListener)new ak(this)));
      paramBundle = com.tencent.mm.kernel.g.agR();
      k.g(paramBundle, "MMKernel.storage()");
      if (paramBundle.agA().getInt(ah.a.GVB, 2) != 2) {
        break label2074;
      }
    }
    label2067:
    label2074:
    for (bool = true;; bool = false)
    {
      this.gFp.add(new FinderDebugSettingsUI2.c("TL关注是否使用默认方案(B)", String.valueOf(bool), (View.OnClickListener)new al(this, bool)));
      this.gFp.add(new FinderDebugSettingsUI2.c("重置最后退出TL时间为0", String.valueOf(bool), (View.OnClickListener)new an(this)));
      paramBundle = this.gFp;
      localObject = TouchMediaPreviewLayout.Jdj;
      paramBundle.add(new FinderDebugSettingsUI2.c("手势预览松手弹回", String.valueOf(TouchMediaPreviewLayout.fvc()), (View.OnClickListener)new ao(this)));
      this.gFp.add(new b("是否开启手势切Tab", ah.a.GVc, new String[] { "关闭(-1)", "默认(0)", "打开(1)" }, new int[] { -1, 0, 1 }));
      this.gFp.add(new b("选择分段拍摄器", ah.a.GVO, new String[] { "现网", "开发版" }, new int[] { 0, 1 }));
      this.gFp.add(new b("红点不受配置时间限制", ah.a.GUw, new String[] { "默认", "无限制" }, new int[] { 1, 1000000000 }));
      this.gFp.add(new b("后台合成", ah.a.GVU, new String[] { "X实验配置", "否", "是" }, new int[] { -1, 0, 1 }));
      paramBundle = findViewById(2131300026);
      if (paramBundle != null) {
        break label2079;
      }
      paramBundle = new v("null cannot be cast to non-null type android.widget.ListView");
      AppMethodBeat.o(203162);
      throw paramBundle;
      paramBundle = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.czQ() == 1)
      {
        paramBundle = "拿到就显示";
        break;
      }
      paramBundle = "显示话题推荐空白页";
      break;
      paramBundle = "附近tab使用卡片流";
      break label785;
    }
    label2079:
    this.gFr = ((ListView)paramBundle);
    this.rHa = new a();
    paramBundle = this.gFr;
    if (paramBundle == null) {
      k.fOy();
    }
    localObject = this.rHa;
    if (localObject == null) {
      k.aVY("adapter");
    }
    paramBundle.setAdapter((ListAdapter)localObject);
    setBackBtn((MenuItem.OnMenuItemClickListener)new av(this));
    AppMethodBeat.o(203162);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203163);
    super.onDestroy();
    AppMethodBeat.o(203163);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(203165);
    super.onPause();
    AppMethodBeat.o(203165);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(203164);
    super.onResume();
    AppMethodBeat.o(203164);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-finder_release"})
  public final class a
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(203106);
      int i = FinderDebugSettingsUI2.b(this.rHc).size();
      AppMethodBeat.o(203106);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(203107);
      Object localObject = FinderDebugSettingsUI2.b(this.rHc).get(paramInt);
      k.g(localObject, "selectsList[position]");
      AppMethodBeat.o(203107);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    @SuppressLint({"SetTextI18n"})
    public final View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(203108);
      k.h(paramViewGroup, "parent");
      paramView = new TextView((Context)this.rHc);
      paramViewGroup = getItem(paramInt);
      if (paramViewGroup == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderDebugSettingsUI2.ITestMenu");
        AppMethodBeat.o(203108);
        throw paramView;
      }
      paramViewGroup = (FinderDebugSettingsUI2.e)paramViewGroup;
      paramView.setTag(paramViewGroup);
      paramView.setText((CharSequence)(paramViewGroup.abN() + "->:" + paramViewGroup.value()));
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 50));
      if (paramInt % 2 == 1)
      {
        AppCompatActivity localAppCompatActivity = this.rHc.getContext();
        k.g(localAppCompatActivity, "context");
        paramView.setBackgroundColor(localAppCompatActivity.getResources().getColor(2131099741));
      }
      paramView.setOnClickListener((View.OnClickListener)new a(paramViewGroup, paramView));
      paramView = (View)paramView;
      AppMethodBeat.o(203108);
      return paramView;
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderDebugSettingsUI2.e parame, TextView paramTextView) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(203105);
        this.rHd.cx((View)paramView);
        AppMethodBeat.o(203105);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$29", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class aa
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203138);
      paramView = com.tencent.mm.plugin.finder.upload.g.rNn;
      com.tencent.mm.plugin.finder.upload.g.cCz();
      AppMethodBeat.o(203138);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class ab
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203139);
      paramView = new StringBuilder();
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
      k.g(locale, "MMKernel.storage()");
      com.tencent.mm.vfs.i.deleteDir(locale.getAccPath() + "finder");
      paramView = c.rFo;
      boolean bool = c.aPx();
      t.makeText(ai.getContext(), (CharSequence)"好了 ".concat(String.valueOf(bool)), 1).show();
      AppMethodBeat.o(203139);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$30", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class ac
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203140);
      paramView = com.tencent.mm.plugin.finder.upload.j.rNC;
      com.tencent.mm.plugin.finder.upload.j.cCB();
      AppMethodBeat.o(203140);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$32", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class ae
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203142);
      paramView = FinderItem.rDA;
      FinderItem.access$setDebugOnlySelfSee$cp(true);
      AppMethodBeat.o(203142);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$34", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class ag
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      boolean bool2 = true;
      AppMethodBeat.i(203144);
      k.h(paramView, "v");
      Object localObject = paramView.getTag();
      paramView = (View)localObject;
      if (!(localObject instanceof FinderDebugSettingsUI2.c)) {
        paramView = null;
      }
      paramView = (FinderDebugSettingsUI2.c)paramView;
      if (paramView != null)
      {
        localObject = TouchMediaPreviewLayout.Jdj;
        if (!TouchMediaPreviewLayout.fvb())
        {
          bool1 = true;
          paramView.setValue(String.valueOf(bool1));
        }
      }
      else
      {
        paramView = TouchMediaPreviewLayout.Jdj;
        paramView = TouchMediaPreviewLayout.Jdj;
        if (TouchMediaPreviewLayout.fvb()) {
          break label103;
        }
      }
      label103:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        TouchMediaPreviewLayout.xY(bool1);
        FinderDebugSettingsUI2.a(this.rHc).notifyDataSetChanged();
        AppMethodBeat.o(203144);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ah
    implements View.OnClickListener
  {
    ah(FinderDebugSettingsUI2 paramFinderDebugSettingsUI2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203145);
      Object localObject = com.tencent.mm.kernel.g.agR();
      k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVt, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      k.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject).getRedDotManager().Dy(-1);
      k.g(paramView, "v");
      localObject = paramView.getTag();
      paramView = (View)localObject;
      if (!(localObject instanceof FinderDebugSettingsUI2.c)) {
        paramView = null;
      }
      paramView = (FinderDebugSettingsUI2.c)paramView;
      if (paramView != null) {
        paramView.setValue("0");
      }
      FinderDebugSettingsUI2.a(this.rHc).notifyDataSetChanged();
      AppMethodBeat.o(203145);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$37", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class aj
    implements View.OnClickListener
  {
    aj(boolean paramBoolean) {}
    
    public final void onClick(View paramView)
    {
      boolean bool2 = true;
      AppMethodBeat.i(203147);
      k.h(paramView, "v");
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
        paramView = com.tencent.mm.kernel.g.agR();
        k.g(paramView, "MMKernel.storage()");
        paramView = paramView.agA();
        localObject = ah.a.GVg;
        if (bool) {
          break label118;
        }
      }
      label118:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramView.set((ah.a)localObject, Boolean.valueOf(bool1));
        FinderDebugSettingsUI2.a(this.rHc).notifyDataSetChanged();
        AppMethodBeat.o(203147);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$38", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class ak
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203148);
      k.h(paramView, "v");
      paramView = com.tencent.mm.kernel.g.agR();
      k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GVC, Long.valueOf(0L));
      FinderDebugSettingsUI2.a(this.rHc).notifyDataSetChanged();
      AppMethodBeat.o(203148);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$39", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class al
    implements View.OnClickListener
  {
    al(boolean paramBoolean) {}
    
    public final void onClick(View paramView)
    {
      int i = 1;
      AppMethodBeat.i(203149);
      k.h(paramView, "v");
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
        paramView = com.tencent.mm.kernel.g.agR();
        k.g(paramView, "MMKernel.storage()");
        paramView = paramView.agA();
        localObject = ah.a.GVB;
        if (!bool) {
          break label116;
        }
      }
      for (;;)
      {
        paramView.set((ah.a)localObject, Integer.valueOf(i));
        FinderDebugSettingsUI2.a(this.rHc).notifyDataSetChanged();
        AppMethodBeat.o(203149);
        return;
        bool = false;
        break;
        label116:
        i = 2;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class an
    implements View.OnClickListener
  {
    an(FinderDebugSettingsUI2 paramFinderDebugSettingsUI2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203151);
      paramView = com.tencent.mm.kernel.g.agR();
      k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GUv, Long.valueOf(0L));
      FinderDebugSettingsUI2.a(this.rHc).notifyDataSetChanged();
      AppMethodBeat.o(203151);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$41", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class ao
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203152);
      k.h(paramView, "v");
      Object localObject = TouchMediaPreviewLayout.Jdj;
      localObject = TouchMediaPreviewLayout.Jdj;
      if (!TouchMediaPreviewLayout.fvc()) {}
      for (boolean bool = true;; bool = false)
      {
        TouchMediaPreviewLayout.xZ(bool);
        localObject = paramView.getTag();
        paramView = (View)localObject;
        if (!(localObject instanceof FinderDebugSettingsUI2.c)) {
          paramView = null;
        }
        paramView = (FinderDebugSettingsUI2.c)paramView;
        if (paramView != null)
        {
          localObject = TouchMediaPreviewLayout.Jdj;
          paramView.setValue(String.valueOf(TouchMediaPreviewLayout.fvc()));
        }
        FinderDebugSettingsUI2.a(this.rHc).notifyDataSetChanged();
        AppMethodBeat.o(203152);
        return;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$7", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class ar
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203156);
      paramView = new LinkedList();
      List localList = d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
      paramView.add("默认方案");
      paramView.add("拿到就显示");
      paramView.add("显示话题推荐空白页");
      h.a((Context)this.rHc, "", (List)paramView, localList, "", (h.d)new a(this));
      AppMethodBeat.o(203156);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
    static final class a
      implements h.d
    {
      a(FinderDebugSettingsUI2.ar paramar) {}
      
      public final void ct(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(203155);
        try
        {
          com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
          com.tencent.mm.plugin.finder.storage.b.Ec(paramInt1);
          FinderDebugSettingsUI2.a(this.rHj.rHc).notifyDataSetChanged();
          AppMethodBeat.o(203155);
          return;
        }
        catch (Exception localException)
        {
          FinderDebugSettingsUI2.d locald = FinderDebugSettingsUI2.rHb;
          ac.printErrStackTrace(FinderDebugSettingsUI2.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
          AppMethodBeat.o(203155);
        }
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$9", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class at
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203158);
      paramView = com.tencent.mm.plugin.finder.upload.action.a.rNF;
      com.tencent.mm.plugin.finder.upload.action.a.cCF();
      t.makeText(ai.getContext(), (CharSequence)"好了", 1).show();
      AppMethodBeat.o(203158);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class au
    implements View.OnClickListener
  {
    au(FinderDebugSettingsUI2 paramFinderDebugSettingsUI2) {}
    
    public final void onClick(View paramView)
    {
      boolean bool2 = true;
      AppMethodBeat.i(203159);
      Object localObject = com.tencent.mm.kernel.g.agR();
      k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).agA();
      ah.a locala = ah.a.GVx;
      MediaPreloadCore.a locala1 = MediaPreloadCore.rvo;
      if (!MediaPreloadCore.cwJ())
      {
        bool1 = true;
        ((ae)localObject).set(locala, Boolean.valueOf(bool1));
        k.g(paramView, "v");
        localObject = paramView.getTag();
        paramView = (View)localObject;
        if (!(localObject instanceof FinderDebugSettingsUI2.c)) {
          paramView = null;
        }
        paramView = (FinderDebugSettingsUI2.c)paramView;
        if (paramView != null)
        {
          localObject = MediaPreloadCore.rvo;
          if (MediaPreloadCore.cwJ()) {
            break label151;
          }
          bool1 = true;
          label102:
          paramView.setValue(String.valueOf(bool1));
        }
        paramView = MediaPreloadCore.rvo;
        paramView = MediaPreloadCore.rvo;
        if (MediaPreloadCore.cwJ()) {
          break label156;
        }
      }
      label151:
      label156:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        MediaPreloadCore.lB(bool1);
        FinderDebugSettingsUI2.a(this.rHc).notifyDataSetChanged();
        AppMethodBeat.o(203159);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label102;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class av
    implements MenuItem.OnMenuItemClickListener
  {
    av(FinderDebugSettingsUI2 paramFinderDebugSettingsUI2) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203160);
      this.rHc.finish();
      AppMethodBeat.o(203160);
      return false;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$ChoiceItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-finder_release"})
  public final class b
    implements FinderDebugSettingsUI2.e
  {
    private String gFw;
    ah.a gFx;
    private String[] gFy;
    Object gFz;
    
    public b(ah.a parama, String[] paramArrayOfString, Object paramObject)
    {
      AppMethodBeat.i(203112);
      this.gFw = parama;
      this.gFx = paramArrayOfString;
      this.gFy = paramObject;
      this.gFz = localObject;
      AppMethodBeat.o(203112);
    }
    
    public final String abN()
    {
      return this.gFw;
    }
    
    public final void cx(View paramView)
    {
      AppMethodBeat.i(203111);
      k.h(paramView, "view");
      paramView = new LinkedList();
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      int j = this.gFy.length;
      while (i < j)
      {
        paramView.add(this.gFy[i]);
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      h.a((Context)FinderDebugSettingsUI2.this, "", (List)paramView, (List)localLinkedList, "", (h.d)new a(this));
      AppMethodBeat.o(203111);
    }
    
    public final String value()
    {
      AppMethodBeat.i(203110);
      if ((this.gFz instanceof long[]))
      {
        localObject1 = com.tencent.mm.kernel.g.agR();
        k.g(localObject1, "MMKernel.storage()");
      }
      int k;
      int i;
      int i1;
      int j;
      for (int m = (int)((com.tencent.mm.kernel.e)localObject1).agA().a(this.gFx, 0L);; m = ((com.tencent.mm.kernel.e)localObject1).agA().getInt(this.gFx, 0))
      {
        k = -1;
        localObject2 = this.gFz;
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
        localObject1 = com.tencent.mm.kernel.g.agR();
        k.g(localObject1, "MMKernel.storage()");
      }
      Object localObject2 = this.gFz;
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
      if ((n >= 0) && (n < this.gFy.length))
      {
        localObject1 = this.gFy[n];
        AppMethodBeat.o(203110);
        return localObject1;
      }
      AppMethodBeat.o(203110);
      return "";
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
    static final class a
      implements h.d
    {
      a(FinderDebugSettingsUI2.b paramb) {}
      
      public final void ct(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(203109);
        Object localObject3;
        Object localObject4;
        try
        {
          Object localObject1 = this.rHe.gFz;
          if (!(localObject1 instanceof long[])) {
            break label138;
          }
          localObject1 = com.tencent.mm.kernel.g.agR();
          k.g(localObject1, "MMKernel.storage()");
          localObject1 = ((com.tencent.mm.kernel.e)localObject1).agA();
          localObject3 = this.rHe.gFx;
          localObject4 = this.rHe.gFz;
          if (localObject4 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type kotlin.LongArray");
            AppMethodBeat.o(203109);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          localObject3 = FinderDebugSettingsUI2.rHb;
          ac.printErrStackTrace(FinderDebugSettingsUI2.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
          AppMethodBeat.o(203109);
          return;
        }
        localException.set((ah.a)localObject3, Long.valueOf(((long[])localObject4)[paramInt1]));
        for (;;)
        {
          FinderDebugSettingsUI2.a(this.rHe.rHc).notifyDataSetChanged();
          AppMethodBeat.o(203109);
          return;
          label138:
          if ((localException instanceof int[]))
          {
            Object localObject2 = com.tencent.mm.kernel.g.agR();
            k.g(localObject2, "MMKernel.storage()");
            localObject2 = ((com.tencent.mm.kernel.e)localObject2).agA();
            localObject3 = this.rHe.gFx;
            localObject4 = this.rHe.gFz;
            if (localObject4 == null)
            {
              localObject2 = new v("null cannot be cast to non-null type kotlin.IntArray");
              AppMethodBeat.o(203109);
              throw ((Throwable)localObject2);
            }
            ((ae)localObject2).set((ah.a)localObject3, Integer.valueOf(((int[])localObject4)[paramInt1]));
          }
        }
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$ITestMenu;", "", "showAlert", "", "view", "Landroid/view/View;", "title", "", "value", "plugin-finder_release"})
  public static abstract interface e
  {
    public abstract String abN();
    
    public abstract void cx(View paramView);
    
    public abstract String value();
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderDebugSettingsUI2 paramFinderDebugSettingsUI2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203116);
      Object localObject = com.tencent.mm.kernel.g.agR();
      k.g(localObject, "MMKernel.storage()");
      if (!((com.tencent.mm.kernel.e)localObject).agA().getBoolean(ah.a.GVz, false)) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = com.tencent.mm.kernel.g.agR();
        k.g(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVz, Boolean.valueOf(bool));
        k.g(paramView, "v");
        localObject = paramView.getTag();
        paramView = (View)localObject;
        if (!(localObject instanceof FinderDebugSettingsUI2.c)) {
          paramView = null;
        }
        paramView = (FinderDebugSettingsUI2.c)paramView;
        if (paramView != null) {
          paramView.setValue(String.valueOf(bool));
        }
        FinderDebugSettingsUI2.a(this.rHc).notifyDataSetChanged();
        AppMethodBeat.o(203116);
        return;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    public static final g rHg;
    
    static
    {
      AppMethodBeat.i(203118);
      rHg = new g();
      AppMethodBeat.o(203118);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203117);
      paramView = p.rQw;
      boolean bool1 = com.tencent.mm.vfs.i.deleteDir(p.cDn());
      paramView = c.rFo;
      boolean bool2 = c.aPx();
      paramView = p.rQw;
      boolean bool3 = com.tencent.mm.vfs.i.deleteDir(p.cDm());
      paramView = FinderDebugSettingsUI2.rHb;
      paramView = FinderDebugSettingsUI2.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("ret=[").append(bool1).append(':').append(bool2).append(':').append(bool3).append("] finderVideoPath=");
      p localp = p.rQw;
      localStringBuilder = localStringBuilder.append(p.cDn()).append(" finderImgPath=");
      localp = p.rQw;
      ac.i(paramView, p.cDm());
      t.makeText(ai.getContext(), (CharSequence)("del file " + bool1 + " db: " + bool2 + " img: " + bool3), 1).show();
      AppMethodBeat.o(203117);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderDebugSettingsUI2 paramFinderDebugSettingsUI2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203119);
      paramView = new StringBuilder();
      Object localObject1 = com.tencent.mm.kernel.g.agR();
      k.g(localObject1, "MMKernel.storage()");
      paramView = ((com.tencent.mm.kernel.e)localObject1).getAccPath() + "finder/";
      localObject1 = new StringBuilder();
      Object localObject2 = com.tencent.mm.kernel.g.agR();
      k.g(localObject2, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject2).agv() + "FinderMM029.db";
      boolean bool1 = com.tencent.mm.vfs.i.deleteDir(paramView);
      boolean bool2 = com.tencent.mm.vfs.i.deleteFile((String)localObject1);
      localObject2 = com.tencent.mm.plugin.finder.storage.data.i.rEV;
      i.a.clearAll();
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).resetLastTimelineExitTime();
      localObject2 = com.tencent.mm.ui.component.a.IrY;
      ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class)).cFK();
      localObject2 = FinderDebugSettingsUI2.rHb;
      ac.i(FinderDebugSettingsUI2.access$getTAG$cp(), "ret=[" + bool1 + ':' + bool2 + "] dataFilePath=" + paramView + " dbFilePath=" + (String)localObject1);
      t.makeText(ai.getContext(), (CharSequence)("del file " + bool1 + " db: " + bool2), 1).show();
      if (com.tencent.mm.pluginsdk.g.e.eLw() != null) {
        com.tencent.mm.pluginsdk.g.e.eLw().bz((Context)this.rHc.getContext());
      }
      AppMethodBeat.o(203119);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$12", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class i
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203120);
      paramView = p.rQw;
      paramView = p.cDx();
      h.Q((Context)this.rHc.getContext(), paramView, "嗯");
      AppMethodBeat.o(203120);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class q
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203128);
      paramView = com.tencent.mm.kernel.g.agR();
      k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GUs, "");
      paramView = com.tencent.mm.kernel.g.agR();
      k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GUt, "");
      paramView = com.tencent.mm.kernel.g.agR();
      k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GTQ, "");
      paramView = com.tencent.mm.kernel.g.agR();
      k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GTR, "");
      paramView = com.tencent.mm.kernel.g.agR();
      k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GTS, "");
      paramView = com.tencent.mm.kernel.g.agR();
      k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GTT, "");
      paramView = com.tencent.mm.kernel.g.agR();
      k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GTU, "");
      paramView = com.tencent.mm.kernel.g.agR();
      k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GTV, "");
      paramView = com.tencent.mm.kernel.g.agR();
      k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GTW, "");
      paramView = com.tencent.mm.kernel.g.agR();
      k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GTY, Integer.valueOf(0));
      paramView = com.tencent.mm.kernel.g.agR();
      k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GVa, Boolean.FALSE);
      t.makeText(ai.getContext(), (CharSequence)"好了", 1).show();
      AppMethodBeat.o(203128);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$26", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class x
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203135);
      paramView = new StringBuilder("clicfg_ultron_finder_search_only_contact_android: ");
      Object localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      paramView = paramView.append(com.tencent.mm.plugin.finder.storage.b.cyO()).append('\n').append("clicfg_ultron_timeline_publish_entrance_switch_android:");
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      paramView = paramView.append(com.tencent.mm.plugin.finder.storage.b.cyP()).append('\n').append("clicfg_ultron_finder_show_reddot_number_attab_android:");
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      paramView = paramView.append(com.tencent.mm.plugin.finder.storage.b.cyQ()).append('\n').append("clicfg_ultron_record_video_max_duration_android:");
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      paramView = paramView.append(com.tencent.mm.plugin.finder.storage.b.cxY().duration).append('\n').append("clicfg_ultron_record_video_min_duration_android:");
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      paramView = paramView.append(com.tencent.mm.plugin.finder.storage.b.cxY().minDuration).append('\n').append("clicfg_ultron_album_video_max_duration_android:");
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      paramView = paramView.append(com.tencent.mm.plugin.finder.storage.b.cxZ().duration).append('\n').append("clicfg_ultron_album_video_min_duration_android:");
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      paramView = com.tencent.mm.plugin.finder.storage.b.cxZ().minDuration + '\n' + "clicfg_ultron_album_video_max_select_duration_android:" + ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pVh, 300);
      localObject = new StringBuilder("MXM_DynaCfg_AV_Item_Key_FinderCommentTextLimit:");
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cyJ()).append('\n').append("MXM_DynaCfg_AV_Item_Key_FinderCommentTextLimit:");
      localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cyK()).append('\n').append("clicfg_ultron_finder_folder_size_dump_interval:");
      localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cyz()).append('\n').append("clicfg_ultron_finder_folder_size_image:");
      localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cyC()).append('\n').append("clicfg_ultron_finder_folder_size_avatar:");
      localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cyD()).append('\n').append("clicfg_ultron_finder_folder_size_cropimg:");
      localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cyE()).append('\n').append("clicfg_ultron_finder_folder_size_video:");
      localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cyF()).append('\n').append("clicfg_ultron_finder_folder_size_tmp:");
      localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cyG()).append('\n').append("clicfg_ultron_finder_folder_size_capture:");
      localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cyH()).append('\n').append("clicfg_ultron_finder_folder_size_posttmp:");
      localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cyI()).append('\n');
      localObject = ai.getContext().getSystemService("clipboard");
      if (localObject == null)
      {
        paramView = new v("null cannot be cast to non-null type android.content.ClipboardManager");
        AppMethodBeat.o(203135);
        throw paramView;
      }
      ((ClipboardManager)localObject).setText((CharSequence)paramView);
      t.makeText(ai.getContext(), (CharSequence)paramView, 1).show();
      AppMethodBeat.o(203135);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$27", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class y
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203136);
      paramView = com.tencent.mm.plugin.finder.storage.data.i.rEV;
      i.a.clearAll();
      AppMethodBeat.o(203136);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$28", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class z
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203137);
      paramView = p.rQw;
      com.tencent.mm.vfs.i.cU(p.cDw(), true);
      AppMethodBeat.o(203137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderDebugSettingsUI2
 * JD-Core Version:    0.7.0.1
 */