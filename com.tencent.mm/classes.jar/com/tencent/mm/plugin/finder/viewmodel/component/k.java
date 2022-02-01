package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.jk;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.loader.v;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.preload.model.b;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.tools.a;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy.b;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.findersdk.a.aa;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.vfs.y;
import com.tencent.mm.view.recyclerview.j;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.g.b.ah.f;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDebugUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderDebugUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "MENU_CHECK_RELEATED_ID", "", "getMENU_CHECK_RELEATED_ID", "()I", "MENU_CHECK_VIDEO", "getMENU_CHECK_VIDEO", "MENU_COPY_ID", "getMENU_COPY_ID", "MENU_FORWARD_VIDEO", "getMENU_FORWARD_VIDEO", "MENU_INFO_ID", "getMENU_INFO_ID", "MENU_LIKE_TIME", "getMENU_LIKE_TIME", "MENU_LIVE_REC_INFO", "getMENU_LIVE_REC_INFO", "MENU_SELECTED_SPEC", "getMENU_SELECTED_SPEC", "MENU_VIDEO_PLAY_INFO", "getMENU_VIDEO_PLAY_INFO", "createFinderFeedDialog", "", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "createLiveDebugInfoDialog", "msg", "", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "createMegaVideoDialog", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "handleShowVideoInfo", "isEnableDebugInfo", "", "showSelectedSpecDialog", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feedObject", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends UIComponent
  implements aa
{
  public static final k.a GNm;
  private static final String TAG;
  private final int GNn;
  private final int GNo;
  private final int GNp;
  private final int GNq;
  private final int GNr;
  private final int GNs;
  private final int GNt;
  private final int GNu;
  private final int GNv;
  
  static
  {
    AppMethodBeat.i(337922);
    GNm = new k.a((byte)0);
    TAG = "MicroMsg.FinderDebugUIC";
    AppMethodBeat.o(337922);
  }
  
  public k(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337779);
    this.GNn = 1;
    this.GNo = 2;
    this.GNp = 3;
    this.GNq = 4;
    this.GNr = 5;
    this.GNs = 6;
    this.GNt = 7;
    this.GNu = 8;
    this.GNv = 9;
    AppMethodBeat.o(337779);
  }
  
  private final void I(j paramj)
  {
    AppMethodBeat.i(337809);
    paramj = (FinderVideoLayout)paramj.caK.findViewById(e.e.finder_banner_video_layout);
    Object localObject1;
    Object localObject2;
    int i;
    if ((paramj.getVideoView() instanceof FinderThumbPlayerProxy))
    {
      paramj = paramj.getVideoView();
      if (paramj == null)
      {
        paramj = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy");
        AppMethodBeat.o(337809);
        throw paramj;
      }
      localObject1 = ((FinderThumbPlayerProxy)paramj).Gpf;
      paramj = new StringBuilder();
      paramj.append(kotlin.g.b.s.X("position:", Integer.valueOf(((FinderThumbPlayerProxy.b)localObject1).position))).append("\n");
      paramj.append(kotlin.g.b.s.X("decodeType:", ((FinderThumbPlayerProxy.b)localObject1).Gpn)).append("\n");
      paramj.append(kotlin.g.b.s.X("preloadType:", ((FinderThumbPlayerProxy.b)localObject1).Gpo)).append("\n");
      paramj.append(kotlin.g.b.s.X("firstFrameTime:", Long.valueOf(((FinderThumbPlayerProxy.b)localObject1).Fqp))).append("\n");
      paramj.append(kotlin.g.b.s.X("viewType:", ((FinderThumbPlayerProxy.b)localObject1).viewType)).append("\n");
      paramj.append(kotlin.g.b.s.X("specType:", ((FinderThumbPlayerProxy.b)localObject1).Gpq)).append("\n");
      localObject2 = (kotlin.u)((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMediaPreloadModel().EVz.get(((FinderThumbPlayerProxy.b)localObject1).mediaId);
      if (localObject2 != null) {
        break label304;
      }
      i = 0;
    }
    for (;;)
    {
      paramj.append(kotlin.g.b.s.X("preloadMaxBitRate:", Integer.valueOf(i))).append("\n");
      paramj.append(kotlin.g.b.s.X("videoBitRate:", Long.valueOf(((FinderThumbPlayerProxy.b)localObject1).Gpr))).append("\n");
      localObject1 = a.FNQ;
      localObject1 = (Context)getContext();
      paramj = paramj.toString();
      kotlin.g.b.s.s(paramj, "debugInfoStr.toString()");
      a.aF((Context)localObject1, paramj);
      AppMethodBeat.o(337809);
      return;
      label304:
      localObject2 = (Long)((kotlin.u)localObject2).aiuN;
      if (localObject2 == null) {
        i = 0;
      } else {
        i = (int)((Long)localObject2).longValue();
      }
    }
  }
  
  private static final String J(j paramj)
  {
    AppMethodBeat.i(337902);
    paramj = (FinderVideoLayout)paramj.caK.findViewById(e.e.finder_banner_video_layout);
    if ((paramj.getVideoView() instanceof FinderThumbPlayerProxy))
    {
      paramj = paramj.getVideoView();
      if (paramj == null)
      {
        paramj = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy");
        AppMethodBeat.o(337902);
        throw paramj;
      }
      paramj = kotlin.g.b.s.X("目前播放档位: ", ((FinderThumbPlayerProxy)paramj).Gpf.Gpq);
      AppMethodBeat.o(337902);
      return paramj;
    }
    AppMethodBeat.o(337902);
    return "档位选择";
  }
  
  public static void a(Context paramContext, dji paramdji, FinderObject paramFinderObject, j paramj)
  {
    AppMethodBeat.i(337793);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramdji, "video");
    kotlin.g.b.s.u(paramFinderObject, "feedObject");
    kotlin.g.b.s.u(paramj, "holder");
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    Object localObject1 = paramdji.aaPs;
    kotlin.g.b.s.s(localObject1, "video.hdr_spec");
    Object localObject3 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      boz localboz = (boz)((Iterator)localObject3).next();
      localObject2 = localboz.hVy;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "unknown-hdr";
      }
      localLinkedList1.add(localObject1);
      kotlin.g.b.s.s(localboz, "it");
      localLinkedList2.add(com.tencent.mm.plugin.finder.preload.model.c.b(localboz));
    }
    paramdji = paramdji.spec;
    kotlin.g.b.s.s(paramdji, "video.spec");
    Object localObject2 = ((Iterable)paramdji).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (boz)((Iterator)localObject2).next();
      localObject1 = ((boz)localObject3).hVy;
      paramdji = (dji)localObject1;
      if (localObject1 == null) {
        paramdji = "unknown-sdr";
      }
      localLinkedList1.add(paramdji);
      kotlin.g.b.s.s(localObject3, "it");
      localLinkedList2.add(com.tencent.mm.plugin.finder.preload.model.c.b((boz)localObject3));
    }
    paramdji = new ah.f();
    localObject1 = a.FNQ;
    paramdji.aqH = a.a(paramContext, (List)localLinkedList2, J(paramj), new k..ExternalSyntheticLambda0(localLinkedList1, paramj, paramdji), 24);
    paramj = TAG;
    localObject1 = new StringBuilder("handleSelectSpec feedId:").append(com.tencent.mm.ae.d.hF(paramFinderObject.id)).append(" desc:");
    paramContext = paramFinderObject.objectDesc;
    if (paramContext == null) {
      paramContext = "";
    }
    for (;;)
    {
      Log.i(paramj, o.aBv(paramContext));
      AppMethodBeat.o(337793);
      return;
      paramdji = paramContext.description;
      paramContext = paramdji;
      if (paramdji == null) {
        paramContext = "";
      }
    }
  }
  
  private static final void a(WXMediaMessage paramWXMediaMessage, String paramString, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(337832);
    kotlin.g.b.s.u(paramWXMediaMessage, "$wxmsg");
    kotlin.g.b.s.u(paramString, "$msg");
    if (paramInt2 == -1)
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      kotlin.g.b.s.checkNotNull(paramIntent);
      paramIntent = (CharSequence)paramIntent;
      paramIntent = new kotlin.n.k(",").o(paramIntent, 0);
      Object localObject;
      if (!paramIntent.isEmpty())
      {
        localObject = paramIntent.listIterator(paramIntent.size());
        if (((ListIterator)localObject).hasPrevious()) {
          if (((CharSequence)((ListIterator)localObject).previous()).length() == 0)
          {
            paramInt1 = 1;
            label124:
            if (paramInt1 != 0) {
              break label190;
            }
          }
        }
      }
      for (paramIntent = p.c((Iterable)paramIntent, ((ListIterator)localObject).nextIndex() + 1);; paramIntent = (List)ab.aivy)
      {
        paramIntent = ((Collection)paramIntent).toArray(new String[0]);
        if (paramIntent != null) {
          break label203;
        }
        paramWXMediaMessage = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(337832);
        throw paramWXMediaMessage;
        paramInt1 = 0;
        break label124;
        label190:
        break;
      }
      label203:
      paramIntent = Util.stringsToList((String[])paramIntent);
      kotlin.g.b.s.s(paramIntent, "toUserList");
      paramIntent = ((Iterable)paramIntent).iterator();
      while (paramIntent.hasNext())
      {
        localObject = (String)paramIntent.next();
        jk localjk = new jk();
        localjk.hKY.hzF = paramWXMediaMessage;
        localjk.hKY.username = ((String)localObject);
        localjk.hKY.hKZ = 4;
        localjk.hKY.hLa = paramString;
        localjk.publish();
      }
    }
    AppMethodBeat.o(337832);
  }
  
  private static final void a(k paramk, Context paramContext, JSONObject paramJSONObject, BaseFinderFeed paramBaseFinderFeed, dji paramdji, j paramj, String paramString, long paramLong, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(337857);
    kotlin.g.b.s.u(paramk, "this$0");
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramJSONObject, "$json");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    kotlin.g.b.s.u(paramdji, "$firstMedia");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramString, "$allInfo");
    paramInt = paramMenuItem.getItemId();
    if (paramInt == paramk.GNn)
    {
      paramk = a.FNQ;
      paramk = paramJSONObject.toString();
      kotlin.g.b.s.s(paramk, "json.toString()");
      a.aF(paramContext, paramk);
      AppMethodBeat.o(337857);
      return;
    }
    if (paramInt == paramk.GNp)
    {
      paramk = a.FNQ;
      a.aF(paramContext, kotlin.g.b.s.X("后台配置:", paramBaseFinderFeed.feedObject.getPosTriggerConfig()));
      AppMethodBeat.o(337857);
      return;
    }
    if (paramInt == paramk.GNu)
    {
      a(paramContext, paramdji, paramBaseFinderFeed.feedObject.getFeedObject(), paramj);
      AppMethodBeat.o(337857);
      return;
    }
    if (paramInt == paramk.GNv)
    {
      paramk.I(paramj);
      AppMethodBeat.o(337857);
      return;
    }
    if (paramInt == paramk.GNs)
    {
      paramk = new StringBuilder("friendLikeCount=" + paramBaseFinderFeed.feedObject.getFeedObject().friendLikeCount + " incFriendLikeCount=" + paramBaseFinderFeed.feedObject.getFeedObject().incFriendLikeCount + '\n');
      paramJSONObject = paramBaseFinderFeed.feedObject.getFeedObject().likeList;
      kotlin.g.b.s.s(paramJSONObject, "item.feedObject.feedObject.likeList");
      paramJSONObject = ((Iterable)paramJSONObject).iterator();
      while (paramJSONObject.hasNext())
      {
        paramBaseFinderFeed = (FinderCommentInfo)paramJSONObject.next();
        paramk.append(paramBaseFinderFeed.nickname).append("=").append(Util.formatUnixTime(paramBaseFinderFeed.createtime)).append("\n");
      }
      paramJSONObject = a.FNQ;
      paramk = paramk.toString();
      kotlin.g.b.s.s(paramk, "ss.toString()");
      a.aF(paramContext, paramk);
      AppMethodBeat.o(337857);
      return;
    }
    if (paramInt == paramk.GNq)
    {
      paramk = com.tencent.mm.plugin.finder.storage.logic.e.FNF.b(paramLong, paramdji);
      paramJSONObject = SightVideoJNI.getSimpleMp4InfoVFS(paramk.getPath());
      boolean bool = SightVideoJNI.isH265VideoVFS(paramk.getPath());
      paramk = "path:" + paramk.getPath() + " \nsize:" + Util.getSizeKB(y.bEl(paramk.getPath())) + "\nmediaId:" + paramk.ExE.mediaId + "\nurl=" + paramdji.url + " \n" + paramJSONObject + " \nisH265:" + bool;
      paramJSONObject = a.FNQ;
      a.aF(paramContext, paramk);
      AppMethodBeat.o(337857);
      return;
    }
    if (paramInt == paramk.GNr)
    {
      paramk = com.tencent.mm.plugin.finder.storage.logic.e.FNF.b(paramBaseFinderFeed.bZA(), paramdji);
      paramJSONObject = "path:" + paramk.getPath() + " \nsize:" + Util.getSizeKB(y.bEl(paramk.getPath())) + "\nmediaId:" + paramk.ExE.mediaId + "\nurl=" + paramdji.url;
      paramBaseFinderFeed = new Intent();
      paramj = new WXFileObject();
      paramj.setFilePath(paramk.getPath());
      paramdji = new WXMediaMessage();
      paramdji.mediaObject = ((WXMediaMessage.IMediaObject)paramj);
      paramk = new com.tencent.mm.vfs.u(paramk.getPath());
      paramdji.title = paramk.getName();
      paramdji.description = Util.getSizeKB(paramk.length());
      paramBaseFinderFeed.putExtra("Select_Conv_Type", 3);
      paramBaseFinderFeed.putExtra("select_is_ret", true);
      paramBaseFinderFeed.putExtra("Retr_Msg_Type", 2);
      com.tencent.mm.br.c.a((MMFragmentActivity)paramContext, ".ui.transmit.SelectConversationUI", paramBaseFinderFeed, 1004, new k..ExternalSyntheticLambda1(paramdji, paramJSONObject));
      AppMethodBeat.o(337857);
      return;
    }
    if (paramInt == paramk.GNo)
    {
      ClipboardHelper.setText((CharSequence)paramString);
      Toast.makeText(paramj.context, (CharSequence)kotlin.g.b.s.X("debug info ", paramString), 1).show();
    }
    AppMethodBeat.o(337857);
  }
  
  private static final void a(k paramk, Context paramContext, JSONObject paramJSONObject, ca paramca, j paramj, String paramString, long paramLong, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(337895);
    kotlin.g.b.s.u(paramk, "this$0");
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramJSONObject, "$json");
    kotlin.g.b.s.u(paramca, "$item");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramString, "$allInfo");
    paramInt = paramMenuItem.getItemId();
    if (paramInt == paramk.GNn)
    {
      paramk = a.FNQ;
      paramk = paramJSONObject.toString();
      kotlin.g.b.s.s(paramk, "json.toString()");
      a.aF(paramContext, paramk);
      AppMethodBeat.o(337895);
      return;
    }
    if (paramInt == paramk.GNp)
    {
      paramk = a.FNQ;
      a.aF(paramContext, kotlin.g.b.s.X("后台配置:", paramca.getFeedObject().posTriggerConfig));
      AppMethodBeat.o(337895);
      return;
    }
    if (paramInt == paramk.GNu)
    {
      paramk = (dji)p.oL((List)paramca.eDE());
      if (paramk != null)
      {
        a(paramContext, paramk, paramca.getFeedObject(), paramj);
        AppMethodBeat.o(337895);
      }
    }
    else
    {
      if (paramInt == paramk.GNv)
      {
        paramk.I(paramj);
        AppMethodBeat.o(337895);
        return;
      }
      if (paramInt == paramk.GNs)
      {
        paramk = paramca.ABK;
        if (paramk == null) {}
        for (paramk = null;; paramk = Integer.valueOf(paramk.friendLikeCount))
        {
          paramk = new StringBuilder(kotlin.g.b.s.X("friendLikeCount=", paramk));
          paramJSONObject = a.FNQ;
          paramk = paramk.toString();
          kotlin.g.b.s.s(paramk, "ss.toString()");
          a.aF(paramContext, paramk);
          AppMethodBeat.o(337895);
          return;
        }
      }
      if (paramInt == paramk.GNq)
      {
        paramk = (dji)p.oL((List)paramca.eDE());
        if (paramk != null)
        {
          paramk = com.tencent.mm.plugin.finder.storage.logic.e.FNF.b(paramLong, paramk);
          paramJSONObject = SightVideoJNI.getSimpleMp4InfoVFS(paramk.getPath());
          boolean bool = SightVideoJNI.isH265VideoVFS(paramk.getPath());
          paramj = new StringBuilder("path:").append(paramk.getPath()).append(" \nsize:").append(Util.getSizeKB(y.bEl(paramk.getPath()))).append("\nmediaId:").append(paramk.ExE.mediaId).append("\nurl=");
          paramk = (dji)p.oL((List)paramca.eDE());
          if (paramk == null) {}
          for (paramk = null;; paramk = paramk.url)
          {
            paramk = paramk + " \n" + paramJSONObject + " \nisH265:" + bool;
            paramJSONObject = a.FNQ;
            a.aF(paramContext, paramk);
            AppMethodBeat.o(337895);
            return;
          }
        }
      }
      else if (paramInt == paramk.GNr)
      {
        paramk = (dji)p.oL((List)paramca.eDE());
        if (paramk != null)
        {
          paramJSONObject = com.tencent.mm.plugin.finder.storage.logic.e.FNF.b(paramLong, paramk);
          paramj = new StringBuilder("path:").append(paramJSONObject.getPath()).append(" \nsize:").append(Util.getSizeKB(y.bEl(paramJSONObject.getPath()))).append("\nmediaId:").append(paramJSONObject.ExE.mediaId).append("\nurl=");
          paramk = (dji)p.oL((List)paramca.eDE());
          if (paramk == null) {}
          for (paramk = null;; paramk = paramk.url)
          {
            paramk = paramk;
            paramca = new Intent();
            paramString = new WXFileObject();
            paramString.setFilePath(paramJSONObject.getPath());
            paramj = new WXMediaMessage();
            paramj.mediaObject = ((WXMediaMessage.IMediaObject)paramString);
            paramJSONObject = new com.tencent.mm.vfs.u(paramJSONObject.getPath());
            paramj.title = paramJSONObject.getName();
            paramj.description = Util.getSizeKB(paramJSONObject.length());
            paramca.putExtra("Select_Conv_Type", 3);
            paramca.putExtra("select_is_ret", true);
            paramca.putExtra("Retr_Msg_Type", 2);
            com.tencent.mm.br.c.a((MMFragmentActivity)paramContext, ".ui.transmit.SelectConversationUI", paramca, 1004, new k..ExternalSyntheticLambda2(paramj, paramk));
            AppMethodBeat.o(337895);
            return;
          }
        }
      }
      else if (paramInt == paramk.GNo)
      {
        ClipboardHelper.setText((CharSequence)paramString);
        Toast.makeText(paramj.context, (CharSequence)kotlin.g.b.s.X("debug info ", paramString), 1).show();
      }
    }
    AppMethodBeat.o(337895);
  }
  
  private static final void a(k paramk, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(337868);
    kotlin.g.b.s.u(paramk, "this$0");
    params.a(paramk.GNn, (CharSequence)"feed信息", e.g.finder_icons_link);
    params.a(paramk.GNp, (CharSequence)"强化流检查", e.g.bottomsheet_icon_refresh);
    params.a(paramk.GNu, (CharSequence)"指定档位", e.g.bottomsheet_icon_refresh);
    params.a(paramk.GNv, (CharSequence)"播放信息", e.g.bottomsheet_icon_refresh);
    params.a(paramk.GNq, (CharSequence)"VIDEO信息", e.g.bottomsheet_icon_brower);
    params.a(paramk.GNr, (CharSequence)"转发视频文件", e.g.bottomsheet_icon_transmit);
    params.a(paramk.GNo, (CharSequence)"拷贝feed全量信息", e.g.bottomsheet_icon_star);
    params.a(paramk.GNs, (CharSequence)"拷贝feed点赞信息", e.g.bottomsheet_icon_star);
    AppMethodBeat.o(337868);
  }
  
  private static final void a(k paramk, boolean paramBoolean, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(337819);
    kotlin.g.b.s.u(paramk, "this$0");
    params.a(paramk.GNn, (CharSequence)"feed信息", e.g.finder_icons_link);
    params.a(paramk.GNp, (CharSequence)"强化流检查", e.g.bottomsheet_icon_refresh);
    params.a(paramk.GNu, (CharSequence)"指定档位", e.g.bottomsheet_icon_refresh);
    params.a(paramk.GNv, (CharSequence)"播放信息", e.g.bottomsheet_icon_refresh);
    if (paramBoolean)
    {
      params.a(paramk.GNq, (CharSequence)"VIDEO信息", e.g.bottomsheet_icon_brower);
      params.a(paramk.GNr, (CharSequence)"转发视频文件", e.g.bottomsheet_icon_transmit);
    }
    params.a(paramk.GNo, (CharSequence)"拷贝feed全量信息", e.g.bottomsheet_icon_star);
    params.a(paramk.GNs, (CharSequence)"拷贝feed点赞信息", e.g.bottomsheet_icon_star);
    AppMethodBeat.o(337819);
  }
  
  private static final void a(LinkedList paramLinkedList, j paramj, ah.f paramf, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(337916);
    kotlin.g.b.s.u(paramLinkedList, "$specStringList");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramf, "$dialog");
    paramLinkedList = paramLinkedList.get(paramInt);
    kotlin.g.b.s.s(paramLinkedList, "specStringList[which]");
    paramLinkedList = (String)paramLinkedList;
    Log.i(TAG, kotlin.g.b.s.X("onClickOk spec:", paramLinkedList));
    paramDialogInterface = bm.GlZ;
    bm.fio();
    paramDialogInterface = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
    com.tencent.mm.plugin.finder.storage.logic.e.bwy();
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMediaPreloadModel().azl(paramLinkedList);
    FinderVideoLayout localFinderVideoLayout = (FinderVideoLayout)paramj.caK.findViewById(e.e.finder_banner_video_layout);
    if (localFinderVideoLayout.GqA == null)
    {
      Log.w(localFinderVideoLayout.getFTPPTag(), "retryFindSpecPlay return for playInfo null");
      paramLinkedList = (com.tencent.mm.ui.widget.a.e)paramf.aqH;
      if (paramLinkedList != null) {
        paramLinkedList.setTitle((CharSequence)J(paramj));
      }
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMediaPreloadModel().azl("");
      AppMethodBeat.o(337916);
      return;
    }
    paramLinkedList = localFinderVideoLayout.GqA;
    kotlin.g.b.s.checkNotNull(paramLinkedList);
    paramLinkedList = paramLinkedList.mediaList;
    paramDialogInterface = localFinderVideoLayout.GqA;
    kotlin.g.b.s.checkNotNull(paramDialogInterface);
    paramLinkedList = paramLinkedList.get(paramDialogInterface.position);
    kotlin.g.b.s.s(paramLinkedList, "playInfo!!.mediaList[playInfo!!.position]");
    Object localObject = (dji)paramLinkedList;
    paramLinkedList = localFinderVideoLayout.GqA;
    kotlin.g.b.s.checkNotNull(paramLinkedList);
    long l = paramLinkedList.feed.getId();
    paramDialogInterface = ((dji)localObject).mediaId;
    paramLinkedList = paramDialogInterface;
    if (paramDialogInterface == null) {
      paramLinkedList = "";
    }
    paramDialogInterface = localFinderVideoLayout.a(l, paramLinkedList, (dji)localObject);
    paramLinkedList = localFinderVideoLayout.GqA;
    kotlin.g.b.s.checkNotNull(paramLinkedList);
    localObject = paramLinkedList.feed;
    String str = paramDialogInterface.aUt();
    paramLinkedList = localFinderVideoLayout.GqA;
    kotlin.g.b.s.checkNotNull(paramLinkedList);
    paramInt = paramLinkedList.position;
    LinkedList localLinkedList = localFinderVideoLayout.mediaList;
    paramLinkedList = localFinderVideoLayout.GqA;
    kotlin.g.b.s.checkNotNull(paramLinkedList);
    boolean bool = paramLinkedList.hJv;
    if (paramDialogInterface.ExE.aaPf) {}
    for (paramLinkedList = paramDialogInterface.ExE.EDC;; paramLinkedList = null)
    {
      localFinderVideoLayout.GqA = new FinderVideoLayout.b((FeedData)localObject, str, paramDialogInterface, paramInt, localLinkedList, bool, true, paramLinkedList, (byte)0);
      localFinderVideoLayout.getRetryBtn().performClick();
      break;
    }
  }
  
  private static final void b(WXMediaMessage paramWXMediaMessage, String paramString, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(337875);
    kotlin.g.b.s.u(paramWXMediaMessage, "$wxmsg");
    kotlin.g.b.s.u(paramString, "$msg");
    if (paramInt2 == -1)
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      kotlin.g.b.s.checkNotNull(paramIntent);
      paramIntent = (CharSequence)paramIntent;
      paramIntent = new kotlin.n.k(",").o(paramIntent, 0);
      Object localObject;
      if (!paramIntent.isEmpty())
      {
        localObject = paramIntent.listIterator(paramIntent.size());
        if (((ListIterator)localObject).hasPrevious()) {
          if (((CharSequence)((ListIterator)localObject).previous()).length() == 0)
          {
            paramInt1 = 1;
            label124:
            if (paramInt1 != 0) {
              break label190;
            }
          }
        }
      }
      for (paramIntent = p.c((Iterable)paramIntent, ((ListIterator)localObject).nextIndex() + 1);; paramIntent = (List)ab.aivy)
      {
        paramIntent = ((Collection)paramIntent).toArray(new String[0]);
        if (paramIntent != null) {
          break label203;
        }
        paramWXMediaMessage = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(337875);
        throw paramWXMediaMessage;
        paramInt1 = 0;
        break label124;
        label190:
        break;
      }
      label203:
      paramIntent = Util.stringsToList((String[])paramIntent);
      kotlin.g.b.s.s(paramIntent, "toUserList");
      paramIntent = ((Iterable)paramIntent).iterator();
      while (paramIntent.hasNext())
      {
        localObject = (String)paramIntent.next();
        jk localjk = new jk();
        localjk.hKY.hzF = paramWXMediaMessage;
        localjk.hKY.username = ((String)localObject);
        localjk.hKY.hKZ = 4;
        localjk.hKY.hLa = paramString;
        localjk.publish();
      }
    }
    AppMethodBeat.o(337875);
  }
  
  public final void a(Context paramContext, BaseFinderFeed paramBaseFinderFeed, v paramv, j paramj)
  {
    AppMethodBeat.i(338001);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramBaseFinderFeed, "item");
    kotlin.g.b.s.u(paramj, "holder");
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(paramContext, 0, false);
    long l = paramBaseFinderFeed.bZA();
    Object localObject1 = FeedData.Companion;
    dji localdji = (dji)p.oK((List)FeedData.a.l(paramBaseFinderFeed).getMediaList());
    boolean bool;
    JSONObject localJSONObject1;
    label125:
    Object localObject2;
    if (localdji.mediaType == 4)
    {
      bool = true;
      localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = localJSONObject1.put("tag", "ClickMoreDebug");
      localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().contact;
      if (localObject1 != null) {
        break label685;
      }
      localObject1 = "";
      localObject1 = localJSONObject2.put("nickname", localObject1).put("feedId", com.tencent.mm.ae.d.hF(paramBaseFinderFeed.feedObject.getId())).put("signedFeedId", paramBaseFinderFeed.feedObject.getId()).put("feedTime", Util.formatUnixTime(paramBaseFinderFeed.feedObject.getCreateTime() * 1L)).put("videoDuration", localdji.videoDuration).put("mediaWH", localdji.width + ':' + localdji.height).put("mediaRadio", String.valueOf(localdji.height / kotlin.k.k.bt(1.0F, localdji.width))).put("description", paramBaseFinderFeed.feedObject.getDescription()).put("isVideo", bool);
      if (paramv != null) {
        break label709;
      }
      paramv = null;
      label284:
      localObject1 = ((JSONObject)localObject1).put("file_format", paramv).put("username", paramBaseFinderFeed.feedObject.field_username);
      paramv = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject2 = paramBaseFinderFeed.feedObject.field_username;
      paramv = paramBaseFinderFeed.feedObject.getBizInfo();
      if (paramv != null) {
        break label717;
      }
    }
    label685:
    label709:
    label717:
    for (paramv = null;; paramv = paramv.ADE)
    {
      localObject2 = ((JSONObject)localObject1).put("isFollow", d.a.a((String)localObject2, paramv, false, false, 12)).put("mediaType", paramBaseFinderFeed.feedObject.getMediaType());
      localObject1 = localdji.url;
      paramv = (v)localObject1;
      if (localObject1 == null) {
        paramv = "";
      }
      localObject2 = ((JSONObject)localObject2).put("mediaId", MD5Util.getMD5String(paramv)).put("url", localdji.url).put("thumbUrl", localdji.thumbUrl).put("thumbUrlToken", localdji.thumb_url_token).put("fullThumbUrl", localdji.aaPi).put("fullThumbUrlToken", localdji.aaPj).put("coverUrl", localdji.coverUrl).put("coverUrlToken", localdji.cover_url_token).put("longUrl", kotlin.g.b.s.X(localdji.url, Util.nullAsNil(localdji.url_token))).put("longThumbUrl", kotlin.g.b.s.X(localdji.thumbUrl, Util.nullAsNil(localdji.thumb_url_token)));
      localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().debugMessage;
      paramv = (v)localObject1;
      if (localObject1 == null) {
        paramv = "";
      }
      ((JSONObject)localObject2).put("debugMessage", paramv);
      paramv = n.bJB(kotlin.g.b.s.X("content=", com.tencent.mm.ae.f.dg(paramBaseFinderFeed.feedObject.getFeedObject())));
      Log.e(TAG, "START####################################################START");
      Log.e(TAG, kotlin.g.b.s.X("long click more button! ", localJSONObject1));
      Log.e(TAG, kotlin.g.b.s.X("long click more button allInfo! ", paramv));
      Log.e(TAG, "END  ####################################################  END");
      if (fnk())
      {
        localf.Vtg = new k..ExternalSyntheticLambda4(this, bool);
        localf.GAC = new k..ExternalSyntheticLambda5(this, paramContext, localJSONObject1, paramBaseFinderFeed, localdji, paramj, paramv, l);
        localf.dDn();
      }
      AppMethodBeat.o(338001);
      return;
      bool = false;
      break;
      localObject2 = ((FinderContact)localObject1).nickname;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label125;
      }
      localObject1 = "";
      break label125;
      paramv = paramv.ExF;
      break label284;
    }
  }
  
  public final void a(Context paramContext, ca paramca, v paramv, j paramj)
  {
    AppMethodBeat.i(338014);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramca, "item");
    kotlin.g.b.s.u(paramj, "holder");
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(paramContext, 0, false);
    long l = paramca.bZA();
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = localJSONObject.put("tag", "ClickMoreDebug").put("feedId", com.tencent.mm.ae.d.hF(l)).put("signedFeedId", l);
    Object localObject2 = paramca.ABK;
    int i;
    if (localObject2 == null)
    {
      i = 0;
      localObject2 = ((JSONObject)localObject1).put("feedTime", Util.formatUnixTime(i * 1L));
      localObject1 = (dji)p.oL((List)paramca.eDE());
      if (localObject1 != null) {
        break label558;
      }
      localObject1 = null;
      label142:
      localObject1 = ((JSONObject)localObject2).put("videoDuration", localObject1).put("isMegaVideo", true);
      if (paramv != null) {
        break label571;
      }
      paramv = null;
      label167:
      localObject2 = ((JSONObject)localObject1).put("file_format", paramv);
      paramv = paramca.contact;
      if (paramv != null) {
        break label579;
      }
      paramv = "";
      label191:
      localObject1 = ((JSONObject)localObject2).put("username", paramv);
      paramv = com.tencent.mm.plugin.finder.api.d.AwY;
      paramv = paramca.contact;
      if (paramv != null) {
        break label600;
      }
      paramv = null;
      label217:
      paramv = ((JSONObject)localObject1).put("isFollow", d.a.a(paramv, null, false, false, 14));
      localObject1 = (dji)p.oL((List)paramca.eDE());
      if (localObject1 != null) {
        break label608;
      }
      i = 0;
      label258:
      localObject2 = paramv.put("mediaType", i);
      paramv = (dji)p.oL((List)paramca.eDE());
      if (paramv != null) {
        break label618;
      }
      paramv = "";
      label291:
      localObject1 = ((JSONObject)localObject2).put("mediaId", MD5Util.getMD5String(paramv));
      paramv = (dji)p.oL((List)paramca.eDE());
      if (paramv != null) {
        break label639;
      }
      paramv = null;
      label325:
      localObject1 = ((JSONObject)localObject1).put("url", paramv);
      paramv = (dji)p.oL((List)paramca.eDE());
      if (paramv != null) {
        break label657;
      }
      paramv = null;
      label356:
      localObject1 = ((JSONObject)localObject1).put("thumbUrl", paramv);
      paramv = (dji)p.oL((List)paramca.eDE());
      if (paramv != null) {
        break label675;
      }
      paramv = null;
      label387:
      localObject2 = ((JSONObject)localObject1).put("coverUrl", paramv).put("description", paramca.eDE());
      paramv = paramca.ABK;
      if (paramv != null) {
        break label693;
      }
      paramv = "";
    }
    for (;;)
    {
      ((JSONObject)localObject2).put("debugMessage", paramv);
      localObject1 = paramca.ABK;
      paramv = (v)localObject1;
      if (localObject1 == null) {
        paramv = new dne();
      }
      paramv = n.bJB(kotlin.g.b.s.X("content=", com.tencent.mm.ae.f.dg(paramv)));
      Log.e(TAG, kotlin.g.b.s.X("long click more button! ", localJSONObject));
      Log.e(TAG, kotlin.g.b.s.X("long click more button allInfo! ", paramv));
      if (fnk())
      {
        localf.Vtg = new k..ExternalSyntheticLambda3(this);
        localf.GAC = new k..ExternalSyntheticLambda6(this, paramContext, localJSONObject, paramca, paramj, paramv, l);
        localf.dDn();
      }
      AppMethodBeat.o(338014);
      return;
      i = ((dne)localObject2).createTime;
      break;
      label558:
      localObject1 = Integer.valueOf(((dji)localObject1).videoDuration);
      break label142;
      label571:
      paramv = paramv.ExF;
      break label167;
      label579:
      localObject1 = paramv.username;
      paramv = (v)localObject1;
      if (localObject1 != null) {
        break label191;
      }
      paramv = "";
      break label191;
      label600:
      paramv = paramv.username;
      break label217;
      label608:
      i = ((dji)localObject1).mediaType;
      break label258;
      label618:
      localObject1 = paramv.url;
      paramv = (v)localObject1;
      if (localObject1 != null) {
        break label291;
      }
      paramv = "";
      break label291;
      label639:
      paramv = kotlin.g.b.s.X(paramv.url, Util.nullAsNil(paramv.url_token));
      break label325;
      label657:
      paramv = kotlin.g.b.s.X(paramv.thumbUrl, Util.nullAsNil(paramv.thumb_url_token));
      break label356;
      label675:
      paramv = kotlin.g.b.s.X(paramv.coverUrl, Util.nullAsNil(paramv.cover_url_token));
      break label387;
      label693:
      localObject1 = paramv.debugMessage;
      paramv = (v)localObject1;
      if (localObject1 == null) {
        paramv = "";
      }
    }
  }
  
  public final boolean fnk()
  {
    AppMethodBeat.i(338021);
    if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (CrashReportFactory.hasDebuger()))
    {
      AppMethodBeat.o(338021);
      return true;
    }
    AppMethodBeat.o(338021);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.k
 * JD-Core Version:    0.7.0.1
 */