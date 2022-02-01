package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.m.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.g.b.p;
import d.v;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDebugUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "MENU_CHECK_RELEATED_ID", "", "getMENU_CHECK_RELEATED_ID", "()I", "MENU_CHECK_VIDEO", "getMENU_CHECK_VIDEO", "MENU_COPY_ID", "getMENU_COPY_ID", "MENU_FORWARD_VIDEO", "getMENU_FORWARD_VIDEO", "MENU_INFO_ID", "getMENU_INFO_ID", "MENU_LIKE_TIME", "getMENU_LIKE_TIME", "createDialog", "", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "createDialogInfo", "txt", "", "Companion", "plugin-finder_release"})
public final class FinderDebugUIC
  extends UIComponent
{
  public static final String TAG = "MicroMsg.FinderDebugUIC";
  public static final FinderDebugUIC.a tlD;
  final int tlA;
  final int tlB;
  final int tlC;
  final int tlx;
  final int tly;
  final int tlz;
  
  static
  {
    AppMethodBeat.i(206117);
    tlD = new FinderDebugUIC.a((byte)0);
    TAG = "MicroMsg.FinderDebugUIC";
    AppMethodBeat.o(206117);
  }
  
  public FinderDebugUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(206116);
    this.tlx = 1;
    this.tly = 2;
    this.tlz = 3;
    this.tlA = 4;
    this.tlB = 5;
    this.tlC = 6;
    AppMethodBeat.o(206116);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class b
    implements n.d
  {
    public b(FinderDebugUIC paramFinderDebugUIC, boolean paramBoolean) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(206110);
      paraml.a(this.tlE.tlx, (CharSequence)"feed信息", 2131691484);
      paraml.a(this.tlE.tlz, (CharSequence)"强化流检查", 2131689825);
      if (this.tlF)
      {
        paraml.a(this.tlE.tlA, (CharSequence)"VIDEO信息", 2131689797);
        paraml.a(this.tlE.tlB, (CharSequence)"转发视频文件", 2131689831);
      }
      paraml.a(this.tlE.tly, (CharSequence)"拷贝feed全量信息", 2131689829);
      paraml.a(this.tlE.tlC, (CharSequence)"拷贝feed点赞信息", 2131689829);
      AppMethodBeat.o(206110);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  public static final class c
    implements n.e
  {
    public c(FinderDebugUIC paramFinderDebugUIC, Context paramContext, JSONObject paramJSONObject, BaseFinderFeed paramBaseFinderFeed, long paramLong, String paramString, e parame) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      Object localObject1 = null;
      AppMethodBeat.i(206112);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == this.tlE.tlx)
      {
        paramMenuItem = this.crf;
        localObject1 = this.tlG.toString();
        p.g(localObject1, "json.toString()");
        FinderDebugUIC.au(paramMenuItem, (String)localObject1);
        AppMethodBeat.o(206112);
        return;
      }
      Object localObject2;
      boolean bool;
      if (paramInt == this.tlE.tlz)
      {
        paramMenuItem = this.crf;
        localObject1 = new StringBuilder("后台配置:");
        localObject2 = g.sKQ;
        localObject1 = ((StringBuilder)localObject1).append(g.xo(this.rVf.feedObject.getId())).append(" \n是否触发拉取过:");
        localObject2 = g.sKQ;
        if (!g.xp(this.rTg)) {}
        for (bool = true;; bool = false)
        {
          FinderDebugUIC.au(paramMenuItem, bool);
          AppMethodBeat.o(206112);
          return;
        }
      }
      if (paramInt == this.tlE.tlC)
      {
        paramMenuItem = new StringBuilder("friendLikeCount=" + this.rVf.feedObject.getFeedObject().friendLikeCount + " incFriendLikeCount=" + this.rVf.feedObject.getFeedObject().incFriendLikeCount + '\n');
        localObject1 = this.rVf.feedObject.getFeedObject().likeList;
        p.g(localObject1, "item.feedObject.feedObject.likeList");
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FinderCommentInfo)((Iterator)localObject1).next();
          paramMenuItem.append(((FinderCommentInfo)localObject2).nickname).append("=").append(bu.DA(((FinderCommentInfo)localObject2).createtime)).append("\n");
        }
        localObject1 = this.crf;
        paramMenuItem = paramMenuItem.toString();
        p.g(paramMenuItem, "ss.toString()");
        FinderDebugUIC.au((Context)localObject1, paramMenuItem);
        AppMethodBeat.o(206112);
        return;
      }
      if (paramInt == this.tlE.tlA)
      {
        paramMenuItem = (bvz)j.jm((List)this.rVf.feedObject.getMediaList());
        if (paramMenuItem != null)
        {
          localObject1 = c.sLt;
          paramMenuItem = c.b(paramMenuItem);
          localObject1 = SightVideoJNI.getSimpleMp4InfoVFS(paramMenuItem.getPath());
          bool = SightVideoJNI.isH265VideoVFS(paramMenuItem.getPath());
          localObject2 = new StringBuilder("path:").append(paramMenuItem.getPath()).append(" \nsize:").append(bu.sL(o.aZR(paramMenuItem.getPath()))).append('\n').append("mediaId:").append(paramMenuItem.srx.mediaId).append('\n').append("url=");
          paramMenuItem = (bvz)j.jm((List)this.rVf.feedObject.getMediaList());
          if (paramMenuItem != null) {}
          for (paramMenuItem = paramMenuItem.url;; paramMenuItem = null)
          {
            paramMenuItem = paramMenuItem + " \n" + (String)localObject1 + " \nisH265:" + bool;
            FinderDebugUIC.au(this.crf, paramMenuItem);
            AppMethodBeat.o(206112);
            return;
          }
        }
        AppMethodBeat.o(206112);
        return;
      }
      if (paramInt == this.tlE.tlB)
      {
        paramMenuItem = (bvz)j.jm((List)this.rVf.feedObject.getMediaList());
        if (paramMenuItem != null)
        {
          localObject2 = c.sLt;
          localObject2 = c.b(paramMenuItem);
          Object localObject3 = new StringBuilder("path:").append(((com.tencent.mm.plugin.finder.loader.m)localObject2).getPath()).append(" \nsize:").append(bu.sL(o.aZR(((com.tencent.mm.plugin.finder.loader.m)localObject2).getPath()))).append('\n').append("mediaId:").append(((com.tencent.mm.plugin.finder.loader.m)localObject2).srx.mediaId).append('\n').append("url=");
          Object localObject4 = (bvz)j.jm((List)this.rVf.feedObject.getMediaList());
          paramMenuItem = (MenuItem)localObject1;
          if (localObject4 != null) {
            paramMenuItem = ((bvz)localObject4).url;
          }
          paramMenuItem = paramMenuItem;
          localObject1 = new Intent();
          localObject4 = new WXFileObject();
          ((WXFileObject)localObject4).setFilePath(((com.tencent.mm.plugin.finder.loader.m)localObject2).getPath());
          localObject3 = new WXMediaMessage();
          ((WXMediaMessage)localObject3).mediaObject = ((WXMediaMessage.IMediaObject)localObject4);
          localObject2 = new k(((com.tencent.mm.plugin.finder.loader.m)localObject2).getPath());
          ((WXMediaMessage)localObject3).title = ((k)localObject2).getName();
          ((WXMediaMessage)localObject3).description = bu.sL(((k)localObject2).length());
          ((Intent)localObject1).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject1).putExtra("select_is_ret", true);
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 2);
          localObject2 = this.crf;
          if (localObject2 == null)
          {
            paramMenuItem = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(206112);
            throw paramMenuItem;
          }
          localObject2 = (MMActivity)localObject2;
          localObject4 = com.tencent.mm.plugin.finder.utils.m.sWJ;
          d.a((MMActivity)localObject2, ".ui.transmit.SelectConversationUI", (Intent)localObject1, m.a.cNY(), (MMActivity.a)new FinderDebugUIC.c.a((WXMediaMessage)localObject3, paramMenuItem));
          AppMethodBeat.o(206112);
          return;
        }
        AppMethodBeat.o(206112);
        return;
      }
      if (paramInt == this.tlE.tly)
      {
        paramMenuItem = ak.getContext().getSystemService("clipboard");
        if (paramMenuItem == null)
        {
          paramMenuItem = new v("null cannot be cast to non-null type android.text.ClipboardManager");
          AppMethodBeat.o(206112);
          throw paramMenuItem;
        }
        ((ClipboardManager)paramMenuItem).setText((CharSequence)this.tlH);
        Toast.makeText(this.oTF.getContext(), (CharSequence)("debug info " + this.tlH), 1).show();
      }
      AppMethodBeat.o(206112);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    public static final d tlK;
    
    static
    {
      AppMethodBeat.i(206114);
      tlK = new d();
      AppMethodBeat.o(206114);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(206113);
      paramDialogInterface = FinderDebugUIC.tlD;
      ae.i(FinderDebugUIC.access$getTAG$cp(), "onClickCancel");
      AppMethodBeat.o(206113);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(Context paramContext, String paramString) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(206115);
      paramDialogInterface = FinderDebugUIC.tlD;
      ae.i(FinderDebugUIC.access$getTAG$cp(), "onClick1");
      paramDialogInterface = this.crf.getSystemService("clipboard");
      if (paramDialogInterface == null)
      {
        paramDialogInterface = new v("null cannot be cast to non-null type android.text.ClipboardManager");
        AppMethodBeat.o(206115);
        throw paramDialogInterface;
      }
      ((ClipboardManager)paramDialogInterface).setText((CharSequence)this.tlL);
      Toast.makeText(this.crf, (CharSequence)"copy done", 0).show();
      AppMethodBeat.o(206115);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC
 * JD-Core Version:    0.7.0.1
 */