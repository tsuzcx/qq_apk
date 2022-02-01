package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.hn;
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
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.g.b.p;
import d.n.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDebugUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "MENU_CHECK_RELEATED_ID", "", "getMENU_CHECK_RELEATED_ID", "()I", "MENU_CHECK_VIDEO", "getMENU_CHECK_VIDEO", "MENU_COPY_ID", "getMENU_COPY_ID", "MENU_FORWARD_VIDEO", "getMENU_FORWARD_VIDEO", "MENU_INFO_ID", "getMENU_INFO_ID", "MENU_LIKE_TIME", "getMENU_LIKE_TIME", "createDialog", "", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "createDialogInfo", "txt", "", "Companion", "plugin-finder_release"})
public final class FinderDebugUIC
  extends UIComponent
{
  public static final String TAG = "MicroMsg.FinderDebugUIC";
  public static final a taP;
  final int taJ;
  final int taK;
  final int taL;
  final int taM;
  final int taN;
  final int taO;
  
  static
  {
    AppMethodBeat.i(205507);
    taP = new a((byte)0);
    TAG = "MicroMsg.FinderDebugUIC";
    AppMethodBeat.o(205507);
  }
  
  public FinderDebugUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(205506);
    this.taJ = 1;
    this.taK = 2;
    this.taL = 3;
    this.taM = 4;
    this.taN = 5;
    this.taO = 6;
    AppMethodBeat.o(205506);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDebugUIC$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class b
    implements n.d
  {
    public b(FinderDebugUIC paramFinderDebugUIC, boolean paramBoolean) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(205500);
      paraml.a(this.taQ.taJ, (CharSequence)"feed信息", 2131691484);
      paraml.a(this.taQ.taL, (CharSequence)"强化流检查", 2131689825);
      if (this.taR)
      {
        paraml.a(this.taQ.taM, (CharSequence)"VIDEO信息", 2131689797);
        paraml.a(this.taQ.taN, (CharSequence)"转发视频文件", 2131689831);
      }
      paraml.a(this.taQ.taK, (CharSequence)"拷贝feed全量信息", 2131689829);
      paraml.a(this.taQ.taO, (CharSequence)"拷贝feed点赞信息", 2131689829);
      AppMethodBeat.o(205500);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  public static final class c
    implements n.e
  {
    public c(FinderDebugUIC paramFinderDebugUIC, Context paramContext, String paramString1, BaseFinderFeed paramBaseFinderFeed, long paramLong, String paramString2, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
    {
      Object localObject1 = null;
      AppMethodBeat.i(205502);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == this.taQ.taJ)
      {
        FinderDebugUIC.as(this.cqB, this.taS);
        AppMethodBeat.o(205502);
        return;
      }
      Object localObject2;
      boolean bool;
      if (paramInt == this.taQ.taL)
      {
        paramMenuItem = this.cqB;
        localObject1 = new StringBuilder("后台配置:");
        localObject2 = g.szT;
        localObject1 = ((StringBuilder)localObject1).append(g.wX(this.rMR.feedObject.getId())).append(" \n是否触发拉取过:");
        localObject2 = g.szT;
        if (!g.wY(this.rKU)) {}
        for (bool = true;; bool = false)
        {
          FinderDebugUIC.as(paramMenuItem, bool);
          AppMethodBeat.o(205502);
          return;
        }
      }
      if (paramInt == this.taQ.taO)
      {
        paramMenuItem = new StringBuilder("friendLikeCount=" + this.rMR.feedObject.getFeedObject().friendLikeCount + " incFriendLikeCount=" + this.rMR.feedObject.getFeedObject().incFriendLikeCount + '\n');
        localObject1 = this.rMR.feedObject.getFeedObject().likeList;
        p.g(localObject1, "item.feedObject.feedObject.likeList");
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FinderCommentInfo)((Iterator)localObject1).next();
          paramMenuItem.append(((FinderCommentInfo)localObject2).nickname).append("=").append(bt.Dc(((FinderCommentInfo)localObject2).createtime)).append("\n");
        }
        localObject1 = this.cqB;
        paramMenuItem = paramMenuItem.toString();
        p.g(paramMenuItem, "ss.toString()");
        FinderDebugUIC.as((Context)localObject1, paramMenuItem);
        AppMethodBeat.o(205502);
        return;
      }
      if (paramInt == this.taQ.taM)
      {
        paramMenuItem = (bvf)j.jd((List)this.rMR.feedObject.getMediaList());
        if (paramMenuItem != null)
        {
          localObject1 = c.sAv;
          paramMenuItem = c.b(paramMenuItem);
          localObject1 = SightVideoJNI.getSimpleMp4InfoVFS(paramMenuItem.getPath());
          bool = SightVideoJNI.isH265VideoVFS(paramMenuItem.getPath());
          localObject2 = new StringBuilder("path:").append(paramMenuItem.getPath()).append(" \nsize:").append(bt.sy(i.aYo(paramMenuItem.getPath()))).append('\n').append("mediaId:").append(paramMenuItem.siC.mediaId).append('\n').append("url=");
          paramMenuItem = (bvf)j.jd((List)this.rMR.feedObject.getMediaList());
          if (paramMenuItem != null) {}
          for (paramMenuItem = paramMenuItem.url;; paramMenuItem = null)
          {
            paramMenuItem = paramMenuItem + " \n" + (String)localObject1 + " \nisH265:" + bool;
            FinderDebugUIC.as(this.cqB, paramMenuItem);
            AppMethodBeat.o(205502);
            return;
          }
        }
        AppMethodBeat.o(205502);
        return;
      }
      if (paramInt == this.taQ.taN)
      {
        paramMenuItem = (bvf)j.jd((List)this.rMR.feedObject.getMediaList());
        if (paramMenuItem != null)
        {
          localObject2 = c.sAv;
          localObject2 = c.b(paramMenuItem);
          Object localObject3 = new StringBuilder("path:").append(((com.tencent.mm.plugin.finder.loader.m)localObject2).getPath()).append(" \nsize:").append(bt.sy(i.aYo(((com.tencent.mm.plugin.finder.loader.m)localObject2).getPath()))).append('\n').append("mediaId:").append(((com.tencent.mm.plugin.finder.loader.m)localObject2).siC.mediaId).append('\n').append("url=");
          Object localObject4 = (bvf)j.jd((List)this.rMR.feedObject.getMediaList());
          paramMenuItem = (MenuItem)localObject1;
          if (localObject4 != null) {
            paramMenuItem = ((bvf)localObject4).url;
          }
          paramMenuItem = paramMenuItem;
          localObject1 = new Intent();
          localObject4 = new WXFileObject();
          ((WXFileObject)localObject4).setFilePath(((com.tencent.mm.plugin.finder.loader.m)localObject2).getPath());
          localObject3 = new WXMediaMessage();
          ((WXMediaMessage)localObject3).mediaObject = ((WXMediaMessage.IMediaObject)localObject4);
          localObject2 = new com.tencent.mm.vfs.e(((com.tencent.mm.plugin.finder.loader.m)localObject2).getPath());
          ((WXMediaMessage)localObject3).title = ((com.tencent.mm.vfs.e)localObject2).getName();
          ((WXMediaMessage)localObject3).description = bt.sy(((com.tencent.mm.vfs.e)localObject2).length());
          ((Intent)localObject1).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject1).putExtra("select_is_ret", true);
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 2);
          localObject2 = this.cqB;
          if (localObject2 == null)
          {
            paramMenuItem = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(205502);
            throw paramMenuItem;
          }
          localObject2 = (MMActivity)localObject2;
          localObject4 = com.tencent.mm.plugin.finder.utils.m.sLy;
          d.a((MMActivity)localObject2, ".ui.transmit.SelectConversationUI", (Intent)localObject1, m.a.cLs(), (MMActivity.a)new a((WXMediaMessage)localObject3, paramMenuItem));
          AppMethodBeat.o(205502);
          return;
        }
        AppMethodBeat.o(205502);
        return;
      }
      if (paramInt == this.taQ.taK)
      {
        paramMenuItem = aj.getContext().getSystemService("clipboard");
        if (paramMenuItem == null)
        {
          paramMenuItem = new d.v("null cannot be cast to non-null type android.text.ClipboardManager");
          AppMethodBeat.o(205502);
          throw paramMenuItem;
        }
        ((ClipboardManager)paramMenuItem).setText((CharSequence)this.taT);
        Toast.makeText(this.oNd.getContext(), (CharSequence)("debug info " + this.taT), 1).show();
      }
      AppMethodBeat.o(205502);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class a
      implements MMActivity.a
    {
      a(WXMediaMessage paramWXMediaMessage, String paramString) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(205501);
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
          for (paramIntent = j.b((Iterable)paramIntent, ((ListIterator)localObject).nextIndex() + 1);; paramIntent = (List)d.a.v.MKE)
          {
            paramIntent = ((Collection)paramIntent).toArray(new String[0]);
            if (paramIntent != null) {
              break label170;
            }
            paramIntent = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(205501);
            throw paramIntent;
            paramInt1 = 0;
            break label99;
            label158:
            break;
          }
          label170:
          paramIntent = bt.U((String[])paramIntent);
          p.g(paramIntent, "toUserList");
          paramIntent = ((Iterable)paramIntent).iterator();
          while (paramIntent.hasNext())
          {
            localObject = (String)paramIntent.next();
            hn localhn = new hn();
            localhn.dtY.dtZ = this.taU;
            localhn.dtY.username = ((String)localObject);
            localhn.dtY.dua = 4;
            localhn.dtY.dub = paramMenuItem;
            a.IbL.l((b)localhn);
          }
        }
        AppMethodBeat.o(205501);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    public static final d taW;
    
    static
    {
      AppMethodBeat.i(205504);
      taW = new d();
      AppMethodBeat.o(205504);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(205503);
      paramDialogInterface = FinderDebugUIC.taP;
      ad.i(FinderDebugUIC.access$getTAG$cp(), "onClickCancel");
      AppMethodBeat.o(205503);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(Context paramContext, String paramString) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(205505);
      paramDialogInterface = FinderDebugUIC.taP;
      ad.i(FinderDebugUIC.access$getTAG$cp(), "onClick1");
      paramDialogInterface = this.cqB.getSystemService("clipboard");
      if (paramDialogInterface == null)
      {
        paramDialogInterface = new d.v("null cannot be cast to non-null type android.text.ClipboardManager");
        AppMethodBeat.o(205505);
        throw paramDialogInterface;
      }
      ((ClipboardManager)paramDialogInterface).setText((CharSequence)this.taS);
      Toast.makeText(this.cqB, (CharSequence)"copy done", 0).show();
      AppMethodBeat.o(205505);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC
 * JD-Core Version:    0.7.0.1
 */