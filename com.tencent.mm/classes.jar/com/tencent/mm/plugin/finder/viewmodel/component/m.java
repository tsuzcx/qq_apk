package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.g;
import com.tencent.mm.by.c;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.loader.aa;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDebugUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "MENU_CHECK_RELEATED_ID", "", "getMENU_CHECK_RELEATED_ID", "()I", "MENU_CHECK_VIDEO", "getMENU_CHECK_VIDEO", "MENU_COPY_ID", "getMENU_COPY_ID", "MENU_FORWARD_VIDEO", "getMENU_FORWARD_VIDEO", "MENU_INFO_ID", "getMENU_INFO_ID", "MENU_LIKE_TIME", "getMENU_LIKE_TIME", "MENU_LIVE_REC_INFO", "getMENU_LIVE_REC_INFO", "createFinderFeedDialog", "", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "createLiveDebugInfoDialog", "msg", "", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "createMegaVideoDialog", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "isEnableDebugInfo", "", "Companion", "plugin-finder_release"})
public final class m
  extends UIComponent
{
  public static final a BiL;
  public static final String TAG = "MicroMsg.FinderDebugUIC";
  final int BiE;
  final int BiF;
  final int BiG;
  final int BiH;
  final int BiI;
  final int BiJ;
  private final int BiK;
  
  static
  {
    AppMethodBeat.i(286132);
    BiL = new a((byte)0);
    TAG = "MicroMsg.FinderDebugUIC";
    AppMethodBeat.o(286132);
  }
  
  public m(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(286131);
    this.BiE = 1;
    this.BiF = 2;
    this.BiG = 3;
    this.BiH = 4;
    this.BiI = 5;
    this.BiJ = 6;
    this.BiK = 7;
    AppMethodBeat.o(286131);
  }
  
  public static boolean eks()
  {
    AppMethodBeat.i(286130);
    if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (CrashReportFactory.hasDebuger()))
    {
      AppMethodBeat.o(286130);
      return true;
    }
    AppMethodBeat.o(286130);
    return false;
  }
  
  public final void a(final Context paramContext, final BaseFinderFeed paramBaseFinderFeed, final aa paramaa, final com.tencent.mm.view.recyclerview.i parami)
  {
    AppMethodBeat.i(286129);
    p.k(paramContext, "context");
    p.k(paramBaseFinderFeed, "item");
    p.k(parami, "holder");
    e locale = new e(paramContext, 0, false);
    paramBaseFinderFeed.mf();
    Object localObject1 = FeedData.Companion;
    final csg localcsg = (csg)j.lo((List)FeedData.a.t(paramBaseFinderFeed).getMediaList());
    final boolean bool;
    final JSONObject localJSONObject1;
    Object localObject2;
    if (localcsg.mediaType == 4)
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
      localObject1 = localJSONObject2.put("nickname", localObject1).put("feedId", com.tencent.mm.ae.d.Fw(paramBaseFinderFeed.feedObject.getId())).put("signedFeedId", paramBaseFinderFeed.feedObject.getId()).put("feedTime", Util.formatUnixTime(paramBaseFinderFeed.feedObject.getCreateTime() * 1L)).put("videoDuration", localcsg.videoDuration).put("mediaWH", localcsg.width + ':' + localcsg.height).put("mediaRadio", String.valueOf(localcsg.height / kotlin.k.i.aP(1.0F, localcsg.width))).put("description", paramBaseFinderFeed.feedObject.getDescription()).put("isVideo", bool);
      if (paramaa == null) {
        break label683;
      }
    }
    label683:
    for (paramaa = paramaa.ztP;; paramaa = null)
    {
      paramaa = ((JSONObject)localObject1).put("file_format", paramaa).put("username", paramBaseFinderFeed.feedObject.field_username);
      localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
      localObject2 = paramaa.put("isFollow", d.a.aAN(paramBaseFinderFeed.feedObject.field_username)).put("mediaType", paramBaseFinderFeed.feedObject.getMediaType());
      localObject1 = localcsg.url;
      paramaa = (aa)localObject1;
      if (localObject1 == null) {
        paramaa = "";
      }
      localObject2 = ((JSONObject)localObject2).put("mediaId", MD5Util.getMD5String(paramaa)).put("url", localcsg.url).put("thumbUrl", localcsg.thumbUrl).put("thumbUrlToken", localcsg.thumb_url_token).put("fullThumbUrl", localcsg.TzX).put("fullThumbUrlToken", localcsg.TzY).put("coverUrl", localcsg.coverUrl).put("coverUrlToken", localcsg.cover_url_token).put("longUrl", p.I(localcsg.url, Util.nullAsNil(localcsg.url_token))).put("longThumbUrl", p.I(localcsg.thumbUrl, Util.nullAsNil(localcsg.thumb_url_token)));
      localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().debugMessage;
      paramaa = (aa)localObject1;
      if (localObject1 == null) {
        paramaa = "";
      }
      ((JSONObject)localObject2).put("debugMessage", paramaa);
      paramaa = n.bHx("content=" + g.bN(paramBaseFinderFeed.feedObject.getFeedObject()));
      Log.e(TAG, "START####################################################START");
      Log.e(TAG, "long click more button! ".concat(String.valueOf(localJSONObject1)));
      Log.e(TAG, "long click more button allInfo! ".concat(String.valueOf(paramaa)));
      Log.e(TAG, "END  ####################################################  END");
      if (eks())
      {
        locale.a((q.f)new b(this, bool));
        locale.a((q.g)new c(this, paramContext, localJSONObject1, paramBaseFinderFeed, localcsg, paramaa, parami));
        locale.eik();
      }
      AppMethodBeat.o(286129);
      return;
      bool = false;
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDebugUIC$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "createDialogInfo", "", "context", "Landroid/content/Context;", "txt", "plugin-finder_release"})
  public static final class a
  {
    public static void aN(final Context paramContext, String paramString)
    {
      AppMethodBeat.i(268824);
      p.k(paramContext, "context");
      p.k(paramString, "txt");
      TextView localTextView = new TextView(paramContext);
      localTextView.setText((CharSequence)paramString);
      localTextView.setGravity(3);
      localTextView.setTextSize(1, 13.0F);
      localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      localTextView.setTextColor(paramContext.getResources().getColor(b.c.black_color));
      localTextView.setTypeface(Typeface.MONOSPACE);
      int i = paramContext.getResources().getDimensionPixelSize(b.d.SmallestPadding);
      localTextView.setPadding(i, i, i, i);
      localTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
      DialogInterface.OnClickListener localOnClickListener1 = (DialogInterface.OnClickListener)new b(paramString, paramContext);
      DialogInterface.OnClickListener localOnClickListener2 = (DialogInterface.OnClickListener)a.BiM;
      Log.i(m.access$getTAG$cp(), "dialog msg ".concat(String.valueOf(paramString)));
      h.a(paramContext, "视频号测试", (View)localTextView, "copy", "cancel", localOnClickListener1, localOnClickListener2);
      AppMethodBeat.o(268824);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class a
      implements DialogInterface.OnClickListener
    {
      public static final a BiM;
      
      static
      {
        AppMethodBeat.i(291559);
        BiM = new a();
        AppMethodBeat.o(291559);
      }
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(291558);
        paramDialogInterface = m.BiL;
        Log.i(m.access$getTAG$cp(), "onClickCancel");
        AppMethodBeat.o(291558);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class b
      implements DialogInterface.OnClickListener
    {
      b(String paramString, Context paramContext) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(290763);
        paramDialogInterface = m.BiL;
        Log.i(m.access$getTAG$cp(), "onClick1");
        ClipboardHelper.setText((CharSequence)this.BiN);
        Toast.makeText(paramContext, (CharSequence)"copy done", 0).show();
        AppMethodBeat.o(290763);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements q.f
  {
    b(m paramm, boolean paramBoolean) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(267196);
      paramo.b(this.BiO.BiE, (CharSequence)"feed信息", b.i.finder_icons_link);
      paramo.b(this.BiO.BiG, (CharSequence)"强化流检查", b.i.bottomsheet_icon_refresh);
      if (bool)
      {
        paramo.b(this.BiO.BiH, (CharSequence)"VIDEO信息", b.i.bottomsheet_icon_brower);
        paramo.b(this.BiO.BiI, (CharSequence)"转发视频文件", b.i.bottomsheet_icon_transmit);
      }
      paramo.b(this.BiO.BiF, (CharSequence)"拷贝feed全量信息", b.i.bottomsheet_icon_star);
      paramo.b(this.BiO.BiJ, (CharSequence)"拷贝feed点赞信息", b.i.bottomsheet_icon_star);
      AppMethodBeat.o(267196);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class c
    implements q.g
  {
    c(m paramm, Context paramContext, JSONObject paramJSONObject, BaseFinderFeed paramBaseFinderFeed, csg paramcsg, String paramString, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(291953);
      p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      Object localObject1;
      if (paramInt == this.BiO.BiE)
      {
        paramMenuItem = m.BiL;
        paramMenuItem = paramContext;
        localObject1 = localJSONObject1.toString();
        p.j(localObject1, "json.toString()");
        m.a.aN(paramMenuItem, (String)localObject1);
        AppMethodBeat.o(291953);
        return;
      }
      if (paramInt == this.BiO.BiG)
      {
        paramMenuItem = m.BiL;
        m.a.aN(paramContext, "后台配置:" + paramBaseFinderFeed.feedObject.getPosTriggerConfig());
        AppMethodBeat.o(291953);
        return;
      }
      Object localObject2;
      if (paramInt == this.BiO.BiJ)
      {
        paramMenuItem = new StringBuilder("friendLikeCount=" + paramBaseFinderFeed.feedObject.getFeedObject().friendLikeCount + " incFriendLikeCount=" + paramBaseFinderFeed.feedObject.getFeedObject().incFriendLikeCount + '\n');
        localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().likeList;
        p.j(localObject1, "item.feedObject.feedObject.likeList");
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FinderCommentInfo)((Iterator)localObject1).next();
          paramMenuItem.append(((FinderCommentInfo)localObject2).nickname).append("=").append(Util.formatUnixTime(((FinderCommentInfo)localObject2).createtime)).append("\n");
        }
        localObject1 = m.BiL;
        localObject1 = paramContext;
        paramMenuItem = paramMenuItem.toString();
        p.j(paramMenuItem, "ss.toString()");
        m.a.aN((Context)localObject1, paramMenuItem);
        AppMethodBeat.o(291953);
        return;
      }
      if (paramInt == this.BiO.BiH)
      {
        paramMenuItem = localcsg;
        paramMenuItem = com.tencent.mm.plugin.finder.storage.logic.d.AnN.b(paramBaseFinderFeed.mf(), paramMenuItem);
        localObject1 = SightVideoJNI.getSimpleMp4InfoVFS(paramMenuItem.getPath());
        boolean bool = SightVideoJNI.isH265VideoVFS(paramMenuItem.getPath());
        paramMenuItem = "path:" + paramMenuItem.getPath() + " \nsize:" + Util.getSizeKB(u.bBQ(paramMenuItem.getPath())) + '\n' + "mediaId:" + paramMenuItem.ztO.mediaId + '\n' + "url=" + localcsg.url + " \n" + (String)localObject1 + " \nisH265:" + bool;
        localObject1 = m.BiL;
        m.a.aN(paramContext, paramMenuItem);
        AppMethodBeat.o(291953);
        return;
      }
      if (paramInt == this.BiO.BiI)
      {
        paramMenuItem = localcsg;
        Object localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.AnN.b(paramBaseFinderFeed.mf(), paramMenuItem);
        paramMenuItem = "path:" + ((aa)localObject3).getPath() + " \nsize:" + Util.getSizeKB(u.bBQ(((aa)localObject3).getPath())) + '\n' + "mediaId:" + ((aa)localObject3).ztO.mediaId + '\n' + "url=" + localcsg.url;
        localObject1 = new Intent();
        WXFileObject localWXFileObject = new WXFileObject();
        localWXFileObject.setFilePath(((aa)localObject3).getPath());
        localObject2 = new WXMediaMessage();
        ((WXMediaMessage)localObject2).mediaObject = ((WXMediaMessage.IMediaObject)localWXFileObject);
        localObject3 = new q(((aa)localObject3).getPath());
        ((WXMediaMessage)localObject2).title = ((q)localObject3).getName();
        ((WXMediaMessage)localObject2).description = Util.getSizeKB(((q)localObject3).length());
        ((Intent)localObject1).putExtra("Select_Conv_Type", 3);
        ((Intent)localObject1).putExtra("select_is_ret", true);
        ((Intent)localObject1).putExtra("Retr_Msg_Type", 2);
        localObject3 = paramContext;
        if (localObject3 == null)
        {
          paramMenuItem = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
          AppMethodBeat.o(291953);
          throw paramMenuItem;
        }
        c.a((MMFragmentActivity)localObject3, ".ui.transmit.SelectConversationUI", (Intent)localObject1, 1004, (MMFragmentActivity.b)new m.c.a((WXMediaMessage)localObject2, paramMenuItem));
        AppMethodBeat.o(291953);
        return;
      }
      if (paramInt == this.BiO.BiF)
      {
        ClipboardHelper.setText((CharSequence)paramaa);
        Toast.makeText(parami.getContext(), (CharSequence)("debug info " + paramaa), 1).show();
      }
      AppMethodBeat.o(291953);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class d
    implements q.f
  {
    public d(m paramm) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(289574);
      paramo.b(this.BiO.BiE, (CharSequence)"feed信息", b.i.finder_icons_link);
      paramo.b(this.BiO.BiG, (CharSequence)"强化流检查", b.i.bottomsheet_icon_refresh);
      paramo.b(this.BiO.BiH, (CharSequence)"VIDEO信息", b.i.bottomsheet_icon_brower);
      paramo.b(this.BiO.BiI, (CharSequence)"转发视频文件", b.i.bottomsheet_icon_transmit);
      paramo.b(this.BiO.BiF, (CharSequence)"拷贝feed全量信息", b.i.bottomsheet_icon_star);
      paramo.b(this.BiO.BiJ, (CharSequence)"拷贝feed点赞信息", b.i.bottomsheet_icon_star);
      AppMethodBeat.o(289574);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  public static final class e
    implements q.g
  {
    public e(m paramm, Context paramContext, JSONObject paramJSONObject, bs parambs, long paramLong, String paramString, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      AppMethodBeat.i(289414);
      p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == this.BiO.BiE)
      {
        paramMenuItem = m.BiL;
        paramMenuItem = this.$context;
        localObject1 = this.zLc.toString();
        p.j(localObject1, "json.toString()");
        m.a.aN(paramMenuItem, (String)localObject1);
        AppMethodBeat.o(289414);
        return;
      }
      if (paramInt == this.BiO.BiG)
      {
        paramMenuItem = m.BiL;
        m.a.aN(this.$context, "后台配置:" + this.zwd.getFeedObject().posTriggerConfig);
        AppMethodBeat.o(289414);
        return;
      }
      if (paramInt == this.BiO.BiJ)
      {
        localObject1 = new StringBuilder("friendLikeCount=");
        paramMenuItem = this.zwd.xcy;
        if (paramMenuItem != null) {}
        for (paramMenuItem = Integer.valueOf(paramMenuItem.friendLikeCount);; paramMenuItem = null)
        {
          paramMenuItem = new StringBuilder(paramMenuItem);
          localObject1 = m.BiL;
          localObject1 = this.$context;
          paramMenuItem = paramMenuItem.toString();
          p.j(paramMenuItem, "ss.toString()");
          m.a.aN((Context)localObject1, paramMenuItem);
          AppMethodBeat.o(289414);
          return;
        }
      }
      Object localObject3;
      Object localObject4;
      if (paramInt == this.BiO.BiH)
      {
        paramMenuItem = (csg)j.lp((List)this.zwd.dKV());
        if (paramMenuItem != null)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.storage.logic.d.AnN.b(this.xhm, paramMenuItem);
          localObject2 = SightVideoJNI.getSimpleMp4InfoVFS(paramMenuItem.getPath());
          boolean bool = SightVideoJNI.isH265VideoVFS(paramMenuItem.getPath());
          localObject3 = new StringBuilder("path:").append(paramMenuItem.getPath()).append(" \nsize:").append(Util.getSizeKB(u.bBQ(paramMenuItem.getPath()))).append('\n').append("mediaId:").append(paramMenuItem.ztO.mediaId).append('\n').append("url=");
          localObject4 = (csg)j.lp((List)this.zwd.dKV());
          paramMenuItem = (MenuItem)localObject1;
          if (localObject4 != null) {
            paramMenuItem = ((csg)localObject4).url;
          }
          paramMenuItem = paramMenuItem + " \n" + (String)localObject2 + " \nisH265:" + bool;
          localObject1 = m.BiL;
          m.a.aN(this.$context, paramMenuItem);
          AppMethodBeat.o(289414);
          return;
        }
        AppMethodBeat.o(289414);
        return;
      }
      if (paramInt == this.BiO.BiI)
      {
        paramMenuItem = (csg)j.lp((List)this.zwd.dKV());
        if (paramMenuItem != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.AnN.b(this.xhm, paramMenuItem);
          localObject3 = new StringBuilder("path:").append(((aa)localObject1).getPath()).append(" \nsize:").append(Util.getSizeKB(u.bBQ(((aa)localObject1).getPath()))).append('\n').append("mediaId:").append(((aa)localObject1).ztO.mediaId).append('\n').append("url=");
          localObject4 = (csg)j.lp((List)this.zwd.dKV());
          paramMenuItem = (MenuItem)localObject2;
          if (localObject4 != null) {
            paramMenuItem = ((csg)localObject4).url;
          }
          paramMenuItem = paramMenuItem;
          localObject2 = new Intent();
          localObject4 = new WXFileObject();
          ((WXFileObject)localObject4).setFilePath(((aa)localObject1).getPath());
          localObject3 = new WXMediaMessage();
          ((WXMediaMessage)localObject3).mediaObject = ((WXMediaMessage.IMediaObject)localObject4);
          localObject1 = new q(((aa)localObject1).getPath());
          ((WXMediaMessage)localObject3).title = ((q)localObject1).getName();
          ((WXMediaMessage)localObject3).description = Util.getSizeKB(((q)localObject1).length());
          ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject2).putExtra("select_is_ret", true);
          ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
          localObject1 = this.$context;
          if (localObject1 == null)
          {
            paramMenuItem = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
            AppMethodBeat.o(289414);
            throw paramMenuItem;
          }
          c.a((MMFragmentActivity)localObject1, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1004, (MMFragmentActivity.b)new m.e.a((WXMediaMessage)localObject3, paramMenuItem));
          AppMethodBeat.o(289414);
          return;
        }
        AppMethodBeat.o(289414);
        return;
      }
      if (paramInt == this.BiO.BiF)
      {
        ClipboardHelper.setText((CharSequence)this.BiR);
        Toast.makeText(this.tDl.getContext(), (CharSequence)("debug info " + this.BiR), 1).show();
      }
      AppMethodBeat.o(289414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.m
 * JD-Core Version:    0.7.0.1
 */