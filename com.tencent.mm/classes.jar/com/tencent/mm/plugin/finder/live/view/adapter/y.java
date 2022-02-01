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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.contact.a.a.a;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "(I)V", "chatMembers", "", "getChatMembers", "()Ljava/lang/CharSequence;", "setChatMembers", "(Ljava/lang/CharSequence;)V", "chatRoomViewHolder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem$FinderLiveMultiChatRoomViewHolder;", "chatRoomViewItem", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem$FinderLiveMultiChatRoomViewItem;", "content", "getContent", "setContent", "matchInfo", "Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;", "getMatchInfo", "()Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;", "setMatchInfo", "(Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;)V", "nickname", "getNickname", "setNickname", "username", "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "createViewHolder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "fillingDataItem", "", "context", "Landroid/content/Context;", "baseViewHolder", "formatText", "match", "contact", "Lcom/tencent/mm/storage/Contact;", "getViewItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "Companion", "FinderLiveMultiChatRoomViewHolder", "FinderLiveMultiChatRoomViewItem", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  extends com.tencent.mm.ui.contact.a.a
{
  private static final Pattern DSA;
  public static final y.a DSw;
  CharSequence DSx;
  private final c DSy;
  final b DSz;
  CharSequence nnT;
  CharSequence pJG;
  com.tencent.mm.plugin.fts.a.a.o rpp;
  String username;
  
  static
  {
    AppMethodBeat.i(358742);
    DSw = new y.a((byte)0);
    DSA = Pattern.compile(";");
    AppMethodBeat.o(358742);
  }
  
  public y(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(358734);
    this.DSy = new c();
    this.DSz = new b();
    AppMethodBeat.o(358734);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    Object localObject1 = null;
    AppMethodBeat.i(358764);
    s.u(paramContext, "context");
    Object localObject2;
    int i;
    if (this.rpp != null)
    {
      if (this.contact != null) {
        break label718;
      }
      parama = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
      localObject2 = this.rpp;
      s.checkNotNull(localObject2);
      this.contact = parama.bxq(((com.tencent.mm.plugin.fts.a.a.o)localObject2).Hsz);
      if (this.contact != null) {
        break label718;
      }
      parama = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
      localObject2 = this.rpp;
      s.checkNotNull(localObject2);
      this.contact = parama.bxv(((com.tencent.mm.plugin.fts.a.a.o)localObject2).Hsz);
      i = 1;
    }
    for (;;)
    {
      if (this.contact == null)
      {
        this.pJG = ((CharSequence)"");
        AppMethodBeat.o(358764);
        return;
        i = 0;
      }
      else
      {
        this.username = this.contact.field_username;
        if (i != 0)
        {
          com.tencent.mm.plugin.fts.a.a.o localo = this.rpp;
          parama = this.contact;
          s.s(parama, "contact");
          Resources localResources = paramContext.getResources();
          localObject2 = ((b)com.tencent.mm.kernel.h.ax(b.class)).b(parama, parama.field_username);
          s.checkNotNull(localo);
          boolean bool1;
          boolean bool2;
          switch (localo.subtype)
          {
          default: 
            bool1 = false;
            bool2 = false;
            i = 0;
            parama = localObject1;
            label291:
            if (i != 0) {
              this.pJG = ((CharSequence)p.d(paramContext, (CharSequence)localObject2, com.tencent.mm.cd.a.br(paramContext, p.c.HintTextSize)));
            }
            break;
          }
          for (this.pJG = com.tencent.mm.plugin.fts.a.f.a(g.a(this.pJG, this.FWt, bool2, bool1)).HsX;; this.pJG = ((CharSequence)p.d(paramContext, (CharSequence)localObject2, com.tencent.mm.cd.a.br(paramContext, p.c.HintTextSize))))
          {
            this.nnT = parama;
            AppMethodBeat.o(358764);
            return;
            localResources.getString(p.h.search_contact_tag_nickname);
            bool1 = true;
            bool2 = true;
            i = 1;
            parama = localObject1;
            break label291;
            localResources.getString(p.h.search_contact_tag_nickname);
            bool1 = false;
            bool2 = true;
            i = 1;
            parama = localObject1;
            break label291;
            localResources.getString(p.h.search_contact_tag_nickname);
            bool1 = false;
            bool2 = false;
            i = 1;
            parama = localObject1;
            break label291;
            parama = com.tencent.mm.kernel.h.baE().mCN.rawQuery("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { parama.field_username }, 2);
            String str;
            if (parama.moveToFirst())
            {
              str = parama.getString(0);
              parama.close();
              if (str == null) {
                parama = null;
              }
            }
            for (;;)
            {
              if ((parama != null) && (parama.length > 0)) {
                this.DSx = ((CharSequence)("(" + parama.length + ')'));
              }
              if ((parama == null) || (localo.HtP == null)) {
                break;
              }
              parama = com.tencent.mm.plugin.fts.ui.o.a(paramContext, localo.HtP, parama, this.FWt, b.c.HwT);
              parama = TextUtils.concat(new CharSequence[] { (CharSequence)localResources.getString(p.h.search_contact_tag_member), parama });
              bool1 = false;
              bool2 = false;
              i = 0;
              break label291;
              parama = DSA.split((CharSequence)str);
              continue;
              parama.close();
              parama = null;
            }
          }
        }
        this.pJG = ((CharSequence)((b)com.tencent.mm.kernel.h.ax(b.class)).b(this.contact, this.contact.field_username));
        if (this.rpp != null)
        {
          paramContext = new StringBuilder("(");
          parama = this.rpp;
          s.checkNotNull(parama);
          this.DSx = ((CharSequence)(parama.HtI + ')'));
        }
        AppMethodBeat.o(358764);
        return;
        label718:
        i = 1;
      }
    }
  }
  
  public final com.tencent.mm.ui.contact.a.a.b bVv()
  {
    return (com.tencent.mm.ui.contact.a.a.b)this.DSy;
  }
  
  public final a.a bVw()
  {
    return (a.a)this.DSz;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem$FinderLiveMultiChatRoomViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem;)V", "avatarIV", "Landroid/widget/ImageView;", "getAvatarIV", "()Landroid/widget/ImageView;", "setAvatarIV", "(Landroid/widget/ImageView;)V", "descTV", "Landroid/widget/TextView;", "getDescTV", "()Landroid/widget/TextView;", "setDescTV", "(Landroid/widget/TextView;)V", "nicknameTV", "getNicknameTV", "setNicknameTV", "selectCB", "Landroid/widget/CheckBox;", "getSelectCB", "()Landroid/widget/CheckBox;", "setSelectCB", "(Landroid/widget/CheckBox;)V", "tipTV", "getTipTV", "setTipTV", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends a.a
  {
    TextView DSB;
    ImageView lBC;
    TextView lBD;
    CheckBox pJL;
    TextView plr;
    
    public b()
    {
      super();
      AppMethodBeat.i(358973);
      AppMethodBeat.o(358973);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem$FinderLiveMultiChatRoomViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem;)V", "fillingViewItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "data", "alwaysCheck", "", "isCheck", "inflateView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "convertView", "onItemClick", "v", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends com.tencent.mm.ui.contact.a.a.b
  {
    public c()
    {
      super();
      AppMethodBeat.i(358976);
      AppMethodBeat.o(358976);
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(358987);
      s.u(paramContext, "context");
      s.u(paramViewGroup, "parent");
      paramContext = LayoutInflater.from(paramContext).inflate(p.f.CeI, paramViewGroup, false);
      paramViewGroup = (y.b)this.DSC.DSz;
      Object localObject = paramContext.findViewById(p.e.BOW);
      if (localObject == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(358987);
        throw paramContext;
      }
      paramViewGroup.lBC = ((ImageView)localObject);
      localObject = paramContext.findViewById(p.e.BPa);
      if (localObject == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(358987);
        throw paramContext;
      }
      paramViewGroup.lBD = ((TextView)localObject);
      localObject = paramContext.findViewById(p.e.BOX);
      if (localObject == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(358987);
        throw paramContext;
      }
      paramViewGroup.plr = ((TextView)localObject);
      localObject = paramViewGroup.plr;
      s.checkNotNull(localObject);
      ((TextView)localObject).setVisibility(8);
      localObject = paramContext.findViewById(p.e.BOZ);
      if (localObject == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(358987);
        throw paramContext;
      }
      paramViewGroup.DSB = ((TextView)localObject);
      localObject = paramContext.findViewById(p.e.BOY);
      if (localObject == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.CheckBox");
        AppMethodBeat.o(358987);
        throw paramContext;
      }
      paramViewGroup.pJL = ((CheckBox)localObject);
      paramContext.setTag(paramViewGroup);
      s.s(paramContext, "convertView");
      AppMethodBeat.o(358987);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(359003);
      s.u(paramContext, "context");
      s.u(parama, "holder");
      s.u(parama1, "data");
      parama = (y.b)parama;
      parama1 = (y)parama1;
      Object localObject;
      label140:
      int i;
      if (parama1.username != null)
      {
        localObject = parama1.username;
        s.checkNotNull(localObject);
        if (((String)localObject).length() > 0)
        {
          com.tencent.mm.pluginsdk.ui.a.b.a(parama.lBC, parama1.username, 0.1F, false);
          com.tencent.mm.plugin.fts.ui.o.a(parama1.pJG, parama.lBD);
          if (!ab.IG(parama1.username)) {
            break label275;
          }
          paramContext = paramContext.getResources().getDrawable(p.g.open_im_main_logo);
          paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
          localObject = parama.lBD;
          if (localObject != null) {
            ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
          }
          com.tencent.mm.plugin.fts.ui.o.a(parama1.nnT, parama.plr);
          com.tencent.mm.plugin.fts.ui.o.a(parama1.DSx, parama.DSB);
          if (!this.DSC.afey) {
            break label335;
          }
          if (!paramBoolean1) {
            break label303;
          }
          paramContext = parama.pJL;
          if (paramContext != null) {
            paramContext.setChecked(true);
          }
          paramContext = parama.pJL;
          if (paramContext != null) {
            paramContext.setEnabled(false);
          }
          paramContext = parama.pJL;
          if (paramContext != null)
          {
            if (!aw.isDarkMode()) {
              break label295;
            }
            i = p.g.checkbox_selected_grey_dark;
            label227:
            paramContext.setBackgroundResource(i);
          }
        }
      }
      for (;;)
      {
        paramContext = parama.pJL;
        if (paramContext == null) {
          break label350;
        }
        paramContext.setVisibility(0);
        AppMethodBeat.o(359003);
        return;
        localObject = parama.lBC;
        s.checkNotNull(localObject);
        ((ImageView)localObject).setImageResource(p.d.default_avatar);
        break;
        label275:
        paramContext = parama.lBD;
        if (paramContext == null) {
          break label140;
        }
        paramContext.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        break label140;
        label295:
        i = p.g.checkbox_selected_grey;
        break label227;
        label303:
        paramContext = parama.pJL;
        if (paramContext != null) {
          paramContext.setChecked(paramBoolean2);
        }
        paramContext = parama.pJL;
        if (paramContext != null) {
          paramContext.setEnabled(true);
        }
      }
      label335:
      paramContext = parama.pJL;
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
      label350:
      AppMethodBeat.o(359003);
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.ui.contact.a.a parama)
    {
      AppMethodBeat.i(359008);
      s.u(paramContext, "context");
      s.u(paramView, "v");
      s.u(parama, "data");
      AppMethodBeat.o(359008);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.y
 * JD-Core Version:    0.7.0.1
 */