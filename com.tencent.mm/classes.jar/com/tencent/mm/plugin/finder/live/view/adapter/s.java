package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.contact.a.a.a;
import java.util.regex.Pattern;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "(I)V", "chatMembers", "", "getChatMembers", "()Ljava/lang/CharSequence;", "setChatMembers", "(Ljava/lang/CharSequence;)V", "chatRoomViewHolder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem$FinderLiveMultiChatRoomViewHolder;", "chatRoomViewItem", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem$FinderLiveMultiChatRoomViewItem;", "content", "getContent", "setContent", "matchInfo", "Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;", "getMatchInfo", "()Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;", "setMatchInfo", "(Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;)V", "nickname", "getNickname", "setNickname", "username", "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "createViewHolder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "fillingDataItem", "", "context", "Landroid/content/Context;", "baseViewHolder", "formatText", "match", "contact", "Lcom/tencent/mm/storage/Contact;", "getViewItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "Companion", "FinderLiveMultiChatRoomViewHolder", "FinderLiveMultiChatRoomViewItem", "plugin-finder_release"})
public final class s
  extends com.tencent.mm.ui.contact.a.a
{
  private static final Pattern yZe;
  public static final s.a yZf;
  CharSequence kLX;
  CharSequence mMY;
  m olG;
  String username;
  CharSequence yZb;
  private final c yZc;
  final b yZd;
  
  static
  {
    AppMethodBeat.i(288274);
    yZf = new s.a((byte)0);
    yZe = Pattern.compile(";");
    AppMethodBeat.o(288274);
  }
  
  public s(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(288273);
    this.yZc = new c();
    this.yZd = new b();
    AppMethodBeat.o(288273);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    as localas = null;
    AppMethodBeat.i(288272);
    p.k(paramContext, "context");
    Object localObject1;
    int i;
    if (this.olG != null)
    {
      if (fqR() != null) {
        break label781;
      }
      parama = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
      p.j(parama, "MMKernel.service(IMessengerStorage::class.java)");
      parama = ((com.tencent.mm.plugin.messenger.foundation.a.n)parama).bbL();
      localObject1 = this.olG;
      if (localObject1 == null) {
        p.iCn();
      }
      aF(parama.bwc(((m)localObject1).BHS));
      if (fqR() != null) {
        break label781;
      }
      parama = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
      p.j(parama, "MMKernel.service(IMessengerStorage::class.java)");
      parama = ((com.tencent.mm.plugin.messenger.foundation.a.n)parama).bbL();
      localObject1 = this.olG;
      if (localObject1 == null) {
        p.iCn();
      }
      aF(parama.bwh(((m)localObject1).BHS));
      i = 1;
    }
    for (;;)
    {
      if (fqR() == null)
      {
        this.mMY = ((CharSequence)"");
        AppMethodBeat.o(288272);
        return;
        i = 0;
      }
      else
      {
        parama = fqR();
        p.j(parama, "contact");
        this.username = parama.getUsername();
        if (i != 0)
        {
          m localm = this.olG;
          parama = fqR();
          p.j(parama, "contact");
          Resources localResources = paramContext.getResources();
          localObject1 = ((b)com.tencent.mm.kernel.h.ae(b.class)).b(parama, parama.getUsername());
          if (localm == null) {
            p.iCn();
          }
          boolean bool1;
          boolean bool2;
          switch (localm.BHR)
          {
          default: 
            bool1 = false;
            bool2 = false;
            i = 0;
            parama = localas;
            label323:
            if (i != 0) {
              this.mMY = ((CharSequence)y(paramContext, (String)localObject1, com.tencent.mm.ci.a.aY(paramContext, b.d.HintTextSize)));
            }
            break;
          }
          for (this.mMY = com.tencent.mm.plugin.fts.a.f.a(e.a(this.mMY, hVx(), bool2, bool1)).BIp;; this.mMY = ((CharSequence)y(paramContext, (String)localObject1, com.tencent.mm.ci.a.aY(paramContext, b.d.HintTextSize))))
          {
            this.kLX = parama;
            AppMethodBeat.o(288272);
            return;
            localResources.getString(b.j.search_contact_tag_nickname);
            bool1 = true;
            bool2 = true;
            i = 1;
            parama = localas;
            break label323;
            localResources.getString(b.j.search_contact_tag_nickname);
            bool1 = false;
            bool2 = true;
            i = 1;
            parama = localas;
            break label323;
            localResources.getString(b.j.search_contact_tag_nickname);
            bool1 = false;
            bool2 = false;
            i = 1;
            parama = localas;
            break label323;
            Object localObject2 = com.tencent.mm.kernel.h.aHG();
            p.j(localObject2, "MMKernel.storage()");
            parama = ((com.tencent.mm.kernel.f)localObject2).getDataDB().rawQuery("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { parama.getUsername() }, 2);
            if (parama.moveToFirst())
            {
              localObject2 = parama.getString(0);
              parama.close();
              if (localObject2 == null) {
                parama = null;
              }
            }
            for (;;)
            {
              if ((parama != null) && (parama.length > 0)) {
                this.yZb = ((CharSequence)("(" + parama.length + ")"));
              }
              if ((parama == null) || (localm.BJg == null)) {
                break;
              }
              parama = com.tencent.mm.plugin.fts.ui.n.a(paramContext, localm.BJg, parama, hVx(), b.c.BLX);
              parama = TextUtils.concat(new CharSequence[] { (CharSequence)localResources.getString(b.j.search_contact_tag_member), parama });
              bool1 = false;
              bool2 = false;
              i = 0;
              break label323;
              parama = yZe.split((CharSequence)localObject2);
              continue;
              parama.close();
              parama = null;
            }
          }
        }
        paramContext = (b)com.tencent.mm.kernel.h.ae(b.class);
        parama = fqR();
        localas = fqR();
        p.j(localas, "contact");
        this.mMY = ((CharSequence)paramContext.b(parama, localas.getUsername()));
        if (this.olG != null)
        {
          paramContext = new StringBuilder("(");
          parama = this.olG;
          if (parama == null) {
            p.iCn();
          }
          this.yZb = ((CharSequence)(parama.BIZ + ")"));
        }
        AppMethodBeat.o(288272);
        return;
        label781:
        i = 1;
      }
    }
  }
  
  public final com.tencent.mm.ui.contact.a.a.b bwF()
  {
    return (com.tencent.mm.ui.contact.a.a.b)this.yZc;
  }
  
  public final a.a bwG()
  {
    return (a.a)this.yZd;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem$FinderLiveMultiChatRoomViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem;)V", "avatarIV", "Landroid/widget/ImageView;", "getAvatarIV", "()Landroid/widget/ImageView;", "setAvatarIV", "(Landroid/widget/ImageView;)V", "descTV", "Landroid/widget/TextView;", "getDescTV", "()Landroid/widget/TextView;", "setDescTV", "(Landroid/widget/TextView;)V", "nicknameTV", "getNicknameTV", "setNicknameTV", "selectCB", "Landroid/widget/CheckBox;", "getSelectCB", "()Landroid/widget/CheckBox;", "setSelectCB", "(Landroid/widget/CheckBox;)V", "tipTV", "getTipTV", "setTipTV", "plugin-finder_release"})
  public final class b
    extends a.a
  {
    ImageView iZG;
    TextView iZH;
    CheckBox mNd;
    TextView mrM;
    TextView yZg;
    
    public b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem$FinderLiveMultiChatRoomViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem;)V", "fillingViewItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "data", "alwaysCheck", "", "isCheck", "inflateView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "convertView", "onItemClick", "v", "plugin-finder_release"})
  public final class c
    extends com.tencent.mm.ui.contact.a.a.b
  {
    public c()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(276126);
      p.k(paramContext, "context");
      p.k(paramViewGroup, "parent");
      paramContext = LayoutInflater.from(paramContext).inflate(b.g.finder_live_multi_chat_room_item_ui, paramViewGroup, false);
      paramViewGroup = (a.a)this.yZh.yZd;
      if (paramViewGroup == null)
      {
        paramContext = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveMultiChatRoomDataItem.FinderLiveMultiChatRoomViewHolder");
        AppMethodBeat.o(276126);
        throw paramContext;
      }
      paramViewGroup = (s.b)paramViewGroup;
      Object localObject = paramContext.findViewById(b.f.finder_live_multi_chat_room_avatar_iv);
      if (localObject == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(276126);
        throw paramContext;
      }
      paramViewGroup.iZG = ((ImageView)localObject);
      localObject = paramContext.findViewById(b.f.finder_live_multi_chat_room_title_tv);
      if (localObject == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(276126);
        throw paramContext;
      }
      paramViewGroup.iZH = ((TextView)localObject);
      localObject = paramContext.findViewById(b.f.finder_live_multi_chat_room_desc_tv);
      if (localObject == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(276126);
        throw paramContext;
      }
      paramViewGroup.mrM = ((TextView)localObject);
      localObject = paramViewGroup.mrM;
      if (localObject == null) {
        p.iCn();
      }
      ((TextView)localObject).setVisibility(8);
      localObject = paramContext.findViewById(b.f.finder_live_multi_chat_room_tip_tv);
      if (localObject == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(276126);
        throw paramContext;
      }
      paramViewGroup.yZg = ((TextView)localObject);
      localObject = paramContext.findViewById(b.f.finder_live_multi_chat_room_select_cb);
      if (localObject == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.widget.CheckBox");
        AppMethodBeat.o(276126);
        throw paramContext;
      }
      paramViewGroup.mNd = ((CheckBox)localObject);
      p.j(paramContext, "convertView");
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(276126);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(276127);
      p.k(paramContext, "context");
      p.k(parama, "holder");
      p.k(parama1, "data");
      parama = (s.b)parama;
      parama1 = (s)parama1;
      Object localObject;
      label148:
      int i;
      if (parama1.username != null)
      {
        localObject = parama1.username;
        if (localObject == null) {
          p.iCn();
        }
        if (((String)localObject).length() > 0)
        {
          com.tencent.mm.pluginsdk.ui.a.b.d(parama.iZG, parama1.username, 0.1F);
          com.tencent.mm.plugin.fts.ui.n.a(parama1.mMY, parama.iZH);
          if (!ab.PR(parama1.username)) {
            break label286;
          }
          paramContext = paramContext.getResources().getDrawable(b.i.open_im_main_logo);
          p.j(paramContext, "drawable");
          paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
          localObject = parama.iZH;
          if (localObject != null) {
            ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
          }
          com.tencent.mm.plugin.fts.ui.n.a(parama1.kLX, parama.mrM);
          com.tencent.mm.plugin.fts.ui.n.a(parama1.yZb, parama.yZg);
          if (!this.yZh.fJk()) {
            break label352;
          }
          if (!paramBoolean1) {
            break label314;
          }
          paramContext = parama.mNd;
          if (paramContext != null) {
            paramContext.setChecked(true);
          }
          paramContext = parama.mNd;
          if (paramContext != null) {
            paramContext.setEnabled(false);
          }
          paramContext = parama.mNd;
          if (paramContext != null)
          {
            if (!ar.isDarkMode()) {
              break label306;
            }
            i = b.i.checkbox_selected_grey_dark;
            label235:
            paramContext.setBackgroundResource(i);
          }
        }
      }
      for (;;)
      {
        paramContext = parama.mNd;
        if (paramContext == null) {
          break label346;
        }
        paramContext.setVisibility(0);
        AppMethodBeat.o(276127);
        return;
        localObject = parama.iZG;
        if (localObject == null) {
          p.iCn();
        }
        ((ImageView)localObject).setImageResource(b.e.default_avatar);
        break;
        label286:
        paramContext = parama.iZH;
        if (paramContext == null) {
          break label148;
        }
        paramContext.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break label148;
        label306:
        i = b.i.checkbox_selected_grey;
        break label235;
        label314:
        paramContext = parama.mNd;
        if (paramContext != null) {
          paramContext.setChecked(paramBoolean2);
        }
        paramContext = parama.mNd;
        if (paramContext != null) {
          paramContext.setEnabled(true);
        }
      }
      label346:
      AppMethodBeat.o(276127);
      return;
      label352:
      paramContext = parama.mNd;
      if (paramContext != null)
      {
        paramContext.setVisibility(8);
        AppMethodBeat.o(276127);
        return;
      }
      AppMethodBeat.o(276127);
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.ui.contact.a.a parama)
    {
      AppMethodBeat.i(276128);
      p.k(paramContext, "context");
      p.k(paramView, "v");
      p.k(parama, "data");
      AppMethodBeat.o(276128);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.s
 * JD-Core Version:    0.7.0.1
 */