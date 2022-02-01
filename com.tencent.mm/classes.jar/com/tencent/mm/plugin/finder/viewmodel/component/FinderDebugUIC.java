package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.g.a.ib;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDebugUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "MENU_CHECK_RELEATED_ID", "", "getMENU_CHECK_RELEATED_ID", "()I", "MENU_CHECK_VIDEO", "getMENU_CHECK_VIDEO", "MENU_COPY_ID", "getMENU_COPY_ID", "MENU_FORWARD_VIDEO", "getMENU_FORWARD_VIDEO", "MENU_INFO_ID", "getMENU_INFO_ID", "MENU_LIKE_TIME", "getMENU_LIKE_TIME", "MENU_LIVE_REC_INFO", "getMENU_LIVE_REC_INFO", "createFinderFeedDialog", "", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "createLiveDebugInfoDialog", "msg", "", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "createMegaVideoDialog", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "isEnableDebugInfo", "", "Companion", "plugin-finder_release"})
public final class FinderDebugUIC
  extends UIComponent
{
  public static final String TAG = "MicroMsg.FinderDebugUIC";
  public static final a wvw;
  final int wvp;
  final int wvq;
  final int wvr;
  final int wvs;
  final int wvt;
  final int wvu;
  final int wvv;
  
  static
  {
    AppMethodBeat.i(255464);
    wvw = new a((byte)0);
    TAG = "MicroMsg.FinderDebugUIC";
    AppMethodBeat.o(255464);
  }
  
  public FinderDebugUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255463);
    this.wvp = 1;
    this.wvq = 2;
    this.wvr = 3;
    this.wvs = 4;
    this.wvt = 5;
    this.wvu = 6;
    this.wvv = 7;
    AppMethodBeat.o(255463);
  }
  
  public static boolean dHZ()
  {
    AppMethodBeat.i(255462);
    if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (CrashReportFactory.hasDebuger()))
    {
      AppMethodBeat.o(255462);
      return true;
    }
    AppMethodBeat.o(255462);
    return false;
  }
  
  public final void a(final Context paramContext, final BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.plugin.finder.loader.s params, final com.tencent.mm.view.recyclerview.h paramh)
  {
    AppMethodBeat.i(255461);
    p.h(paramContext, "context");
    p.h(paramBaseFinderFeed, "item");
    p.h(paramh, "holder");
    e locale = new e(paramContext, 0, false);
    final long l = paramBaseFinderFeed.lT();
    cjl localcjl = (cjl)kotlin.a.j.ks((List)paramBaseFinderFeed.feedObject.getMediaList());
    final boolean bool;
    final JSONObject localJSONObject1;
    Object localObject1;
    Object localObject2;
    if (localcjl.mediaType == 4)
    {
      bool = true;
      localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = localJSONObject1.put("tag", "ClickMoreDebug");
      localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().contact;
      if (localObject1 != null)
      {
        localObject2 = ((FinderContact)localObject1).nickname;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localObject1 = localJSONObject2.put("nickname", localObject1).put("feedId", com.tencent.mm.ac.d.zs(paramBaseFinderFeed.feedObject.getId())).put("signedFeedId", paramBaseFinderFeed.feedObject.getId()).put("feedTime", Util.formatUnixTime(paramBaseFinderFeed.feedObject.getCreateTime() * 1L)).put("videoDuration", localcjl.videoDuration).put("mediaWH", localcjl.width + ':' + localcjl.height).put("mediaRadio", String.valueOf(localcjl.height / kotlin.k.j.aI(1.0F, localcjl.width))).put("description", paramBaseFinderFeed.feedObject.getDescription()).put("isVideo", bool);
      if (params == null) {
        break label676;
      }
    }
    label676:
    for (params = params.uIx;; params = null)
    {
      params = ((JSONObject)localObject1).put("file_format", params).put("username", paramBaseFinderFeed.feedObject.field_username);
      localObject1 = com.tencent.mm.plugin.finder.api.c.tsp;
      localObject2 = params.put("isFollow", c.a.asJ(paramBaseFinderFeed.feedObject.field_username)).put("mediaType", paramBaseFinderFeed.feedObject.getMediaType());
      params = (cjl)kotlin.a.j.kt((List)paramBaseFinderFeed.feedObject.getMediaList());
      if (params != null)
      {
        localObject1 = params.url;
        params = (com.tencent.mm.plugin.finder.loader.s)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        params = "";
      }
      localObject2 = ((JSONObject)localObject2).put("mediaId", MD5Util.getMD5String(params)).put("url", localcjl.url).put("thumbUrl", localcjl.thumbUrl).put("thumbUrlToken", localcjl.thumb_url_token).put("coverUrl", localcjl.coverUrl).put("coverUrlToken", localcjl.cover_url_token).put("longUrl", p.I(localcjl.url, Util.nullAsNil(localcjl.url_token))).put("longThumbUrl", p.I(localcjl.thumbUrl, Util.nullAsNil(localcjl.thumb_url_token)));
      localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().debugMessage;
      params = (com.tencent.mm.plugin.finder.loader.s)localObject1;
      if (localObject1 == null) {
        params = "";
      }
      ((JSONObject)localObject2).put("debugMessage", params);
      params = n.buv("content=" + g.bN(paramBaseFinderFeed.feedObject.getFeedObject()));
      Log.e(TAG, "START####################################################START");
      Log.e(TAG, "long click more button! ".concat(String.valueOf(localJSONObject1)));
      Log.e(TAG, "long click more button allInfo! ".concat(String.valueOf(params)));
      Log.e(TAG, "END  ####################################################  END");
      if (dHZ())
      {
        locale.a((o.f)new b(this, bool));
        locale.a((o.g)new c(this, paramContext, localJSONObject1, paramBaseFinderFeed, l, params, paramh));
        locale.dGm();
      }
      AppMethodBeat.o(255461);
      return;
      bool = false;
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDebugUIC$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "createDialogInfo", "", "context", "Landroid/content/Context;", "txt", "plugin-finder_release"})
  public static final class a
  {
    public static void aG(final Context paramContext, String paramString)
    {
      AppMethodBeat.i(255452);
      p.h(paramContext, "context");
      p.h(paramString, "txt");
      TextView localTextView = new TextView(paramContext);
      localTextView.setText((CharSequence)paramString);
      localTextView.setGravity(3);
      localTextView.setTextSize(1, 13.0F);
      localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      localTextView.setTextColor(paramContext.getResources().getColor(2131100044));
      localTextView.setTypeface(Typeface.MONOSPACE);
      int i = paramContext.getResources().getDimensionPixelSize(2131165593);
      localTextView.setPadding(i, i, i, i);
      localTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
      DialogInterface.OnClickListener localOnClickListener1 = (DialogInterface.OnClickListener)new b(paramString, paramContext);
      DialogInterface.OnClickListener localOnClickListener2 = (DialogInterface.OnClickListener)a.wvx;
      Log.i(FinderDebugUIC.access$getTAG$cp(), "dialog msg ".concat(String.valueOf(paramString)));
      com.tencent.mm.ui.base.h.a(paramContext, "视频号测试", (View)localTextView, "copy", "cancel", localOnClickListener1, localOnClickListener2);
      AppMethodBeat.o(255452);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class a
      implements DialogInterface.OnClickListener
    {
      public static final a wvx;
      
      static
      {
        AppMethodBeat.i(255450);
        wvx = new a();
        AppMethodBeat.o(255450);
      }
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(255449);
        paramDialogInterface = FinderDebugUIC.wvw;
        Log.i(FinderDebugUIC.access$getTAG$cp(), "onClickCancel");
        AppMethodBeat.o(255449);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class b
      implements DialogInterface.OnClickListener
    {
      b(String paramString, Context paramContext) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(255451);
        paramDialogInterface = FinderDebugUIC.wvw;
        Log.i(FinderDebugUIC.access$getTAG$cp(), "onClick1");
        ClipboardHelper.setText((CharSequence)this.wvy);
        Toast.makeText(paramContext, (CharSequence)"copy done", 0).show();
        AppMethodBeat.o(255451);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements o.f
  {
    b(FinderDebugUIC paramFinderDebugUIC, boolean paramBoolean) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(255453);
      paramm.b(this.wvz.wvp, (CharSequence)"feed信息", 2131690256);
      paramm.b(this.wvz.wvr, (CharSequence)"强化流检查", 2131689838);
      if (bool)
      {
        paramm.b(this.wvz.wvs, (CharSequence)"VIDEO信息", 2131689809);
        paramm.b(this.wvz.wvt, (CharSequence)"转发视频文件", 2131689844);
      }
      paramm.b(this.wvz.wvq, (CharSequence)"拷贝feed全量信息", 2131689842);
      paramm.b(this.wvz.wvu, (CharSequence)"拷贝feed点赞信息", 2131689842);
      AppMethodBeat.o(255453);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class c
    implements o.g
  {
    c(FinderDebugUIC paramFinderDebugUIC, Context paramContext, JSONObject paramJSONObject, BaseFinderFeed paramBaseFinderFeed, long paramLong, String paramString, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
    {
      Object localObject1 = null;
      AppMethodBeat.i(255455);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == this.wvz.wvp)
      {
        paramMenuItem = FinderDebugUIC.wvw;
        paramMenuItem = paramContext;
        localObject1 = localJSONObject1.toString();
        p.g(localObject1, "json.toString()");
        FinderDebugUIC.a.aG(paramMenuItem, (String)localObject1);
        AppMethodBeat.o(255455);
        return;
      }
      Object localObject2;
      boolean bool;
      if (paramInt == this.wvz.wvr)
      {
        paramMenuItem = FinderDebugUIC.wvw;
        paramMenuItem = paramContext;
        localObject1 = new StringBuilder("后台配置:");
        localObject2 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.finder.storage.data.h.FI(paramBaseFinderFeed.feedObject.getId())).append(" \n是否触发拉取过:");
        localObject2 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
        if (!com.tencent.mm.plugin.finder.storage.data.h.FJ(l)) {}
        for (bool = true;; bool = false)
        {
          FinderDebugUIC.a.aG(paramMenuItem, bool);
          AppMethodBeat.o(255455);
          return;
        }
      }
      if (paramInt == this.wvz.wvu)
      {
        paramMenuItem = new StringBuilder("friendLikeCount=" + paramBaseFinderFeed.feedObject.getFeedObject().friendLikeCount + " incFriendLikeCount=" + paramBaseFinderFeed.feedObject.getFeedObject().incFriendLikeCount + '\n');
        localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().likeList;
        p.g(localObject1, "item.feedObject.feedObject.likeList");
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FinderCommentInfo)((Iterator)localObject1).next();
          paramMenuItem.append(((FinderCommentInfo)localObject2).nickname).append("=").append(Util.formatUnixTime(((FinderCommentInfo)localObject2).createtime)).append("\n");
        }
        localObject1 = FinderDebugUIC.wvw;
        localObject1 = paramContext;
        paramMenuItem = paramMenuItem.toString();
        p.g(paramMenuItem, "ss.toString()");
        FinderDebugUIC.a.aG((Context)localObject1, paramMenuItem);
        AppMethodBeat.o(255455);
        return;
      }
      if (paramInt == this.wvz.wvs)
      {
        paramMenuItem = (cjl)kotlin.a.j.kt((List)paramBaseFinderFeed.feedObject.getMediaList());
        if (paramMenuItem != null)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.storage.logic.d.vGR.b(paramBaseFinderFeed.lT(), paramMenuItem);
          localObject1 = SightVideoJNI.getSimpleMp4InfoVFS(paramMenuItem.getPath());
          bool = SightVideoJNI.isH265VideoVFS(paramMenuItem.getPath());
          localObject2 = new StringBuilder("path:").append(paramMenuItem.getPath()).append(" \nsize:").append(Util.getSizeKB(com.tencent.mm.vfs.s.boW(paramMenuItem.getPath()))).append('\n').append("mediaId:").append(paramMenuItem.uIw.mediaId).append('\n').append("url=");
          paramMenuItem = (cjl)kotlin.a.j.kt((List)paramBaseFinderFeed.feedObject.getMediaList());
          if (paramMenuItem != null) {}
          for (paramMenuItem = paramMenuItem.url;; paramMenuItem = null)
          {
            paramMenuItem = paramMenuItem + " \n" + (String)localObject1 + " \nisH265:" + bool;
            localObject1 = FinderDebugUIC.wvw;
            FinderDebugUIC.a.aG(paramContext, paramMenuItem);
            AppMethodBeat.o(255455);
            return;
          }
        }
        AppMethodBeat.o(255455);
        return;
      }
      if (paramInt == this.wvz.wvt)
      {
        paramMenuItem = (cjl)kotlin.a.j.kt((List)paramBaseFinderFeed.feedObject.getMediaList());
        if (paramMenuItem != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR.b(paramBaseFinderFeed.lT(), paramMenuItem);
          Object localObject3 = new StringBuilder("path:").append(((com.tencent.mm.plugin.finder.loader.s)localObject2).getPath()).append(" \nsize:").append(Util.getSizeKB(com.tencent.mm.vfs.s.boW(((com.tencent.mm.plugin.finder.loader.s)localObject2).getPath()))).append('\n').append("mediaId:").append(((com.tencent.mm.plugin.finder.loader.s)localObject2).uIw.mediaId).append('\n').append("url=");
          Object localObject4 = (cjl)kotlin.a.j.kt((List)paramBaseFinderFeed.feedObject.getMediaList());
          paramMenuItem = (MenuItem)localObject1;
          if (localObject4 != null) {
            paramMenuItem = ((cjl)localObject4).url;
          }
          paramMenuItem = paramMenuItem;
          localObject1 = new Intent();
          localObject4 = new WXFileObject();
          ((WXFileObject)localObject4).setFilePath(((com.tencent.mm.plugin.finder.loader.s)localObject2).getPath());
          localObject3 = new WXMediaMessage();
          ((WXMediaMessage)localObject3).mediaObject = ((WXMediaMessage.IMediaObject)localObject4);
          localObject2 = new o(((com.tencent.mm.plugin.finder.loader.s)localObject2).getPath());
          ((WXMediaMessage)localObject3).title = ((o)localObject2).getName();
          ((WXMediaMessage)localObject3).description = Util.getSizeKB(((o)localObject2).length());
          ((Intent)localObject1).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject1).putExtra("select_is_ret", true);
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 2);
          localObject2 = paramContext;
          if (localObject2 == null)
          {
            paramMenuItem = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
            AppMethodBeat.o(255455);
            throw paramMenuItem;
          }
          com.tencent.mm.br.c.a((MMFragmentActivity)localObject2, ".ui.transmit.SelectConversationUI", (Intent)localObject1, 1004, (MMFragmentActivity.b)new a((WXMediaMessage)localObject3, paramMenuItem));
          AppMethodBeat.o(255455);
          return;
        }
        AppMethodBeat.o(255455);
        return;
      }
      if (paramInt == this.wvz.wvq)
      {
        ClipboardHelper.setText((CharSequence)paramh);
        Toast.makeText(this.qhp.getContext(), (CharSequence)("debug info " + paramh), 1).show();
      }
      AppMethodBeat.o(255455);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class a
      implements MMFragmentActivity.b
    {
      a(WXMediaMessage paramWXMediaMessage, String paramString) {}
      
      public final void d(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(255454);
        if (paramInt2 == -1)
        {
          paramIntent = paramIntent.getStringExtra("Select_Conv_User");
          p.g(paramIntent, "toUsers");
          paramIntent = (CharSequence)paramIntent;
          paramIntent = new k(",").q(paramIntent, 0);
          Object localObject;
          if (!paramIntent.isEmpty())
          {
            localObject = paramIntent.listIterator(paramIntent.size());
            if (((ListIterator)localObject).hasPrevious()) {
              if (((CharSequence)((ListIterator)localObject).previous()).length() == 0)
              {
                paramInt1 = 1;
                label99:
                if (paramInt1 != 0) {
                  break label158;
                }
              }
            }
          }
          for (paramIntent = kotlin.a.j.b((Iterable)paramIntent, ((ListIterator)localObject).nextIndex() + 1);; paramIntent = (List)v.SXr)
          {
            paramIntent = ((Collection)paramIntent).toArray(new String[0]);
            if (paramIntent != null) {
              break label170;
            }
            paramIntent = new t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(255454);
            throw paramIntent;
            paramInt1 = 0;
            break label99;
            label158:
            break;
          }
          label170:
          paramIntent = Util.stringsToList((String[])paramIntent);
          p.g(paramIntent, "toUserList");
          paramIntent = ((Iterable)paramIntent).iterator();
          while (paramIntent.hasNext())
          {
            localObject = (String)paramIntent.next();
            ib localib = new ib();
            localib.dMF.dCE = this.wvD;
            localib.dMF.username = ((String)localObject);
            localib.dMF.dMG = 4;
            localib.dMF.dMH = paramMenuItem;
            EventCenter.instance.publish((IEvent)localib);
          }
        }
        AppMethodBeat.o(255454);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class d
    implements o.f
  {
    public d(FinderDebugUIC paramFinderDebugUIC) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(255456);
      paramm.b(this.wvz.wvp, (CharSequence)"feed信息", 2131690256);
      paramm.b(this.wvz.wvv, (CharSequence)"推荐信息", 2131690256);
      AppMethodBeat.o(255456);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  public static final class e
    implements o.g
  {
    public e(FinderDebugUIC paramFinderDebugUIC, Context paramContext, String paramString1, String paramString2) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(255457);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == this.wvz.wvp)
      {
        paramMenuItem = FinderDebugUIC.wvw;
        FinderDebugUIC.a.aG(this.$context, this.wvE);
        AppMethodBeat.o(255457);
        return;
      }
      if (paramInt == this.wvz.wvv)
      {
        paramMenuItem = FinderDebugUIC.wvw;
        FinderDebugUIC.a.aG(this.$context, this.uhA);
      }
      AppMethodBeat.o(255457);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class f
    implements o.f
  {
    public f(FinderDebugUIC paramFinderDebugUIC) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(255458);
      paramm.b(this.wvz.wvp, (CharSequence)"feed信息", 2131690256);
      paramm.b(this.wvz.wvr, (CharSequence)"强化流检查", 2131689838);
      paramm.b(this.wvz.wvs, (CharSequence)"VIDEO信息", 2131689809);
      paramm.b(this.wvz.wvt, (CharSequence)"转发视频文件", 2131689844);
      paramm.b(this.wvz.wvq, (CharSequence)"拷贝feed全量信息", 2131689842);
      paramm.b(this.wvz.wvu, (CharSequence)"拷贝feed点赞信息", 2131689842);
      AppMethodBeat.o(255458);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  public static final class g
    implements o.g
  {
    public g(FinderDebugUIC paramFinderDebugUIC, Context paramContext, JSONObject paramJSONObject, long paramLong, bm parambm, String paramString, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      AppMethodBeat.i(255460);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == this.wvz.wvp)
      {
        paramMenuItem = FinderDebugUIC.wvw;
        paramMenuItem = this.$context;
        localObject1 = this.wvB.toString();
        p.g(localObject1, "json.toString()");
        FinderDebugUIC.a.aG(paramMenuItem, (String)localObject1);
        AppMethodBeat.o(255460);
        return;
      }
      boolean bool;
      if (paramInt == this.wvz.wvr)
      {
        paramMenuItem = FinderDebugUIC.wvw;
        paramMenuItem = this.$context;
        localObject1 = new StringBuilder("后台配置:");
        localObject2 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.finder.storage.data.h.FI(this.txv)).append(" \n是否触发拉取过:");
        localObject2 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
        if (!com.tencent.mm.plugin.finder.storage.data.h.FJ(this.txv)) {}
        for (bool = true;; bool = false)
        {
          FinderDebugUIC.a.aG(paramMenuItem, bool);
          AppMethodBeat.o(255460);
          return;
        }
      }
      if (paramInt == this.wvz.wvu)
      {
        localObject1 = new StringBuilder("friendLikeCount=");
        paramMenuItem = this.uKq.tuP;
        if (paramMenuItem != null) {}
        for (paramMenuItem = Integer.valueOf(paramMenuItem.friendLikeCount);; paramMenuItem = null)
        {
          paramMenuItem = new StringBuilder(paramMenuItem);
          localObject1 = FinderDebugUIC.wvw;
          localObject1 = this.$context;
          paramMenuItem = paramMenuItem.toString();
          p.g(paramMenuItem, "ss.toString()");
          FinderDebugUIC.a.aG((Context)localObject1, paramMenuItem);
          AppMethodBeat.o(255460);
          return;
        }
      }
      Object localObject3;
      Object localObject4;
      if (paramInt == this.wvz.wvs)
      {
        paramMenuItem = (cjl)kotlin.a.j.kt((List)this.uKq.dkV());
        if (paramMenuItem != null)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.storage.logic.d.vGR.b(this.txv, paramMenuItem);
          localObject2 = SightVideoJNI.getSimpleMp4InfoVFS(paramMenuItem.getPath());
          bool = SightVideoJNI.isH265VideoVFS(paramMenuItem.getPath());
          localObject3 = new StringBuilder("path:").append(paramMenuItem.getPath()).append(" \nsize:").append(Util.getSizeKB(com.tencent.mm.vfs.s.boW(paramMenuItem.getPath()))).append('\n').append("mediaId:").append(paramMenuItem.uIw.mediaId).append('\n').append("url=");
          localObject4 = (cjl)kotlin.a.j.kt((List)this.uKq.dkV());
          paramMenuItem = (MenuItem)localObject1;
          if (localObject4 != null) {
            paramMenuItem = ((cjl)localObject4).url;
          }
          paramMenuItem = paramMenuItem + " \n" + (String)localObject2 + " \nisH265:" + bool;
          localObject1 = FinderDebugUIC.wvw;
          FinderDebugUIC.a.aG(this.$context, paramMenuItem);
          AppMethodBeat.o(255460);
          return;
        }
        AppMethodBeat.o(255460);
        return;
      }
      if (paramInt == this.wvz.wvt)
      {
        paramMenuItem = (cjl)kotlin.a.j.kt((List)this.uKq.dkV());
        if (paramMenuItem != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.vGR.b(this.txv, paramMenuItem);
          localObject3 = new StringBuilder("path:").append(((com.tencent.mm.plugin.finder.loader.s)localObject1).getPath()).append(" \nsize:").append(Util.getSizeKB(com.tencent.mm.vfs.s.boW(((com.tencent.mm.plugin.finder.loader.s)localObject1).getPath()))).append('\n').append("mediaId:").append(((com.tencent.mm.plugin.finder.loader.s)localObject1).uIw.mediaId).append('\n').append("url=");
          localObject4 = (cjl)kotlin.a.j.kt((List)this.uKq.dkV());
          paramMenuItem = (MenuItem)localObject2;
          if (localObject4 != null) {
            paramMenuItem = ((cjl)localObject4).url;
          }
          paramMenuItem = paramMenuItem;
          localObject2 = new Intent();
          localObject4 = new WXFileObject();
          ((WXFileObject)localObject4).setFilePath(((com.tencent.mm.plugin.finder.loader.s)localObject1).getPath());
          localObject3 = new WXMediaMessage();
          ((WXMediaMessage)localObject3).mediaObject = ((WXMediaMessage.IMediaObject)localObject4);
          localObject1 = new o(((com.tencent.mm.plugin.finder.loader.s)localObject1).getPath());
          ((WXMediaMessage)localObject3).title = ((o)localObject1).getName();
          ((WXMediaMessage)localObject3).description = Util.getSizeKB(((o)localObject1).length());
          ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject2).putExtra("select_is_ret", true);
          ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
          localObject1 = this.$context;
          if (localObject1 == null)
          {
            paramMenuItem = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
            AppMethodBeat.o(255460);
            throw paramMenuItem;
          }
          com.tencent.mm.br.c.a((MMFragmentActivity)localObject1, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1004, (MMFragmentActivity.b)new a((WXMediaMessage)localObject3, paramMenuItem));
          AppMethodBeat.o(255460);
          return;
        }
        AppMethodBeat.o(255460);
        return;
      }
      if (paramInt == this.wvz.wvq)
      {
        ClipboardHelper.setText((CharSequence)this.wvC);
        Toast.makeText(this.qhp.getContext(), (CharSequence)("debug info " + this.wvC), 1).show();
      }
      AppMethodBeat.o(255460);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class a
      implements MMFragmentActivity.b
    {
      a(WXMediaMessage paramWXMediaMessage, String paramString) {}
      
      public final void d(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(255459);
        if (paramInt2 == -1)
        {
          paramIntent = paramIntent.getStringExtra("Select_Conv_User");
          p.g(paramIntent, "toUsers");
          paramIntent = (CharSequence)paramIntent;
          paramIntent = new k(",").q(paramIntent, 0);
          Object localObject;
          if (!paramIntent.isEmpty())
          {
            localObject = paramIntent.listIterator(paramIntent.size());
            if (((ListIterator)localObject).hasPrevious()) {
              if (((CharSequence)((ListIterator)localObject).previous()).length() == 0)
              {
                paramInt1 = 1;
                label99:
                if (paramInt1 != 0) {
                  break label158;
                }
              }
            }
          }
          for (paramIntent = kotlin.a.j.b((Iterable)paramIntent, ((ListIterator)localObject).nextIndex() + 1);; paramIntent = (List)v.SXr)
          {
            paramIntent = ((Collection)paramIntent).toArray(new String[0]);
            if (paramIntent != null) {
              break label170;
            }
            paramIntent = new t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(255459);
            throw paramIntent;
            paramInt1 = 0;
            break label99;
            label158:
            break;
          }
          label170:
          paramIntent = Util.stringsToList((String[])paramIntent);
          p.g(paramIntent, "toUserList");
          paramIntent = ((Iterable)paramIntent).iterator();
          while (paramIntent.hasNext())
          {
            localObject = (String)paramIntent.next();
            ib localib = new ib();
            localib.dMF.dCE = this.wvD;
            localib.dMF.username = ((String)localObject);
            localib.dMF.dMG = 4;
            localib.dMF.dMH = paramMenuItem;
            EventCenter.instance.publish((IEvent)localib);
          }
        }
        AppMethodBeat.o(255459);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC
 * JD-Core Version:    0.7.0.1
 */