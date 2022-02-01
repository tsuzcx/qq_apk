package com.tencent.mm.plugin.finder.view.snscover;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.d;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.pu;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/snscover/FinderDetailLoader;", "", "avatarView", "Landroid/widget/ImageView;", "authorNameView", "Landroid/widget/TextView;", "finderDesc", "avatarFl", "Landroid/widget/LinearLayout;", "jumpFinderViewFl", "Landroid/widget/FrameLayout;", "(Landroid/widget/ImageView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/LinearLayout;Landroid/widget/FrameLayout;)V", "getAuthorNameView", "()Landroid/widget/TextView;", "setAuthorNameView", "(Landroid/widget/TextView;)V", "getAvatarFl", "()Landroid/widget/LinearLayout;", "setAvatarFl", "(Landroid/widget/LinearLayout;)V", "getAvatarView", "()Landroid/widget/ImageView;", "setAvatarView", "(Landroid/widget/ImageView;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getFinderDesc", "setFinderDesc", "value", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "finderObject", "getFinderObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFinderObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getSourceDesc", "", "hide", "", "initFinderDetails", "jumpFinderAuthor", "jumpFinderSource", "show", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private FinderObject ABJ;
  private TextView GIH;
  private LinearLayout GII;
  private FrameLayout GIJ;
  private final Context context;
  private TextView finderDesc;
  private ImageView pKM;
  
  public a(ImageView paramImageView, TextView paramTextView1, TextView paramTextView2, LinearLayout paramLinearLayout, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(345737);
    this.pKM = paramImageView;
    this.GIH = paramTextView1;
    this.finderDesc = paramTextView2;
    this.GII = paramLinearLayout;
    this.GIJ = paramFrameLayout;
    this.context = this.pKM.getContext();
    this.GII.setOnClickListener(new a..ExternalSyntheticLambda0(this));
    this.GIJ.setOnClickListener(new a..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(345737);
  }
  
  private static final void a(a parama, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(345753);
    Object localObject2 = new Object();
    Object localObject3 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/snscover/FinderDetailLoader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, ((com.tencent.mm.hellhoundlib.b.b)localObject3).aYj());
    s.u(parama, "this$0");
    localObject2 = parama.context;
    s.s(localObject2, "context");
    if (parama.ABJ != null)
    {
      localObject3 = new Intent();
      paramView = parama.ABJ;
      if (paramView != null) {
        break label198;
      }
      paramView = null;
      boolean bool = s.p(paramView, z.bAW());
      paramView = parama.ABJ;
      if (paramView != null) {
        break label220;
      }
      paramView = localObject1;
      label120:
      ((Intent)localObject3).putExtra("finder_username", paramView);
      parama = parama.ABJ;
      if (parama != null) {
        break label242;
      }
      parama = "";
      label141:
      ((Intent)localObject3).putExtra("key_biz_username", parama);
      if (!bool) {
        break label289;
      }
      ((cn)h.az(cn.class)).enterFinderSelfProfile((Context)localObject2, (Intent)localObject3, 20, 2);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/snscover/FinderDetailLoader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(345753);
      return;
      label198:
      paramView = paramView.contact;
      if (paramView == null)
      {
        paramView = null;
        break;
      }
      paramView = paramView.username;
      break;
      label220:
      FinderContact localFinderContact = paramView.contact;
      paramView = localObject1;
      if (localFinderContact == null) {
        break label120;
      }
      paramView = localFinderContact.username;
      break label120;
      label242:
      parama = parama.contact;
      if (parama == null)
      {
        parama = "";
        break label141;
      }
      parama = c.b(parama);
      if (parama == null)
      {
        parama = "";
        break label141;
      }
      paramView = parama.ADE;
      parama = paramView;
      if (paramView != null) {
        break label141;
      }
      parama = "";
      break label141;
      label289:
      ((cn)h.az(cn.class)).fillContextIdToIntent(20, 2, 32, (Intent)localObject3);
      ((cn)h.az(cn.class)).enterFinderProfileUI((Context)localObject2, (Intent)localObject3);
    }
  }
  
  private static final void a(a parama, m paramm, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(345782);
    s.u(parama, "this$0");
    s.u(paramFinderObject, "$finderObject");
    TextView localTextView = parama.GIH;
    Context localContext = parama.GIH.getContext();
    if (paramm == null) {}
    for (parama = null;; parama = paramm.getNickname())
    {
      paramm = parama;
      if (parama == null) {
        paramm = paramFinderObject.nickname;
      }
      localTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(localContext, (CharSequence)paramm));
      AppMethodBeat.o(345782);
      return;
    }
  }
  
  private static final void a(a parama, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(345791);
    s.u(parama, "this$0");
    s.u(paramFinderObject, "$finderObject");
    TextView localTextView = parama.finderDesc;
    parama = paramFinderObject.objectDesc;
    if (parama == null) {
      parama = (CharSequence)"";
    }
    for (;;)
    {
      localTextView.setText(parama);
      AppMethodBeat.o(345791);
      return;
      parama = parama.description;
      if (parama == null) {
        parama = (CharSequence)"";
      } else {
        parama = (CharSequence)parama;
      }
    }
  }
  
  private static final void a(String paramString, a parama)
  {
    AppMethodBeat.i(345803);
    s.u(paramString, "$avatarUrl");
    s.u(parama, "this$0");
    Object localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject = com.tencent.mm.plugin.finder.loader.p.eCp();
    paramString = new com.tencent.mm.plugin.finder.loader.b(paramString);
    parama = parama.pKM;
    com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
    ((d)localObject).a(paramString, parama, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
    AppMethodBeat.o(345803);
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(345768);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/snscover/FinderDetailLoader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(parama, "this$0");
    localObject1 = parama.context;
    s.s(localObject1, "context");
    localObject2 = new Intent();
    paramView = parama.ABJ;
    if (paramView == null)
    {
      paramView = null;
      ((Intent)localObject2).putExtra("feed_object_id", (Serializable)paramView);
      paramView = parama.ABJ;
      if (paramView != null) {
        break label251;
      }
    }
    label251:
    for (paramView = null;; paramView = paramView.objectNonceId)
    {
      ((Intent)localObject2).putExtra("feed_object_nonceId", paramView);
      ((Intent)localObject2).putExtra("key_need_related_list", false);
      parama = parama.ABJ;
      if (parama != null)
      {
        paramView = an.GhR;
        paramView = FinderItem.Companion;
        parama = an.a.d(FinderItem.a.e(parama, 0), false);
        paramView = an.GhR;
        ((Intent)localObject2).putExtra("KEY_AUTHORIZATION_CONTENT", k.b.a(an.a.a(parama), null, null));
      }
      ((cn)h.az(cn.class)).fillContextIdToIntent(20, 2, 25, (Intent)localObject2);
      ((cn)h.az(cn.class)).enterFinderShareFeedUI((Context)localObject1, (Intent)localObject2);
      j.QFS.akY(4);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/snscover/FinderDetailLoader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(345768);
      return;
      paramView = Long.valueOf(paramView.id);
      break;
    }
  }
  
  public final void J(FinderObject paramFinderObject)
  {
    Object localObject = null;
    AppMethodBeat.i(345859);
    this.ABJ = paramFinderObject;
    FinderContact localFinderContact;
    if (paramFinderObject != null)
    {
      this.GIJ.setVisibility(0);
      localFinderContact = paramFinderObject.contact;
      if (localFinderContact != null) {
        break label100;
      }
      this.GIH.post(new a..ExternalSyntheticLambda2(this, (m)localObject, paramFinderObject));
      this.finderDesc.post(new a..ExternalSyntheticLambda3(this, paramFinderObject));
      if (localObject != null) {
        break label110;
      }
      paramFinderObject = "";
    }
    for (;;)
    {
      this.pKM.post(new a..ExternalSyntheticLambda4(paramFinderObject, this));
      AppMethodBeat.o(345859);
      return;
      label100:
      localObject = c.a(localFinderContact, null, false);
      break;
      label110:
      localObject = ((m)localObject).amx();
      paramFinderObject = (FinderObject)localObject;
      if (localObject == null) {
        paramFinderObject = "";
      }
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(345875);
    this.pKM.setVisibility(4);
    this.GIH.setVisibility(4);
    this.finderDesc.setVisibility(4);
    this.GII.setVisibility(4);
    AppMethodBeat.o(345875);
  }
  
  public final void show()
  {
    AppMethodBeat.i(345882);
    this.pKM.setVisibility(0);
    this.GIH.setVisibility(0);
    this.finderDesc.setVisibility(0);
    this.GII.setVisibility(0);
    AppMethodBeat.o(345882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.snscover.a
 * JD-Core Version:    0.7.0.1
 */