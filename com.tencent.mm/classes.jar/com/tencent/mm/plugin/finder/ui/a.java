package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.ui.am;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/ContactListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "Lkotlin/collections/ArrayList;", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setContactList", "", "contacts", "", "ContactViewHolder", "plugin-finder_release"})
public final class a
  extends BaseAdapter
{
  private String TAG;
  private ArrayList<f> dataList;
  private Activity djj;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(167121);
    this.TAG = "Finder.ContactListAdapter";
    this.djj = paramActivity;
    this.dataList = new ArrayList();
    AppMethodBeat.o(167121);
  }
  
  public final f CW(int paramInt)
  {
    AppMethodBeat.i(167117);
    Object localObject = this.dataList.get(paramInt);
    d.g.b.k.g(localObject, "dataList[position]");
    localObject = (f)localObject;
    AppMethodBeat.o(167117);
    return localObject;
  }
  
  public final void dB(List<f> paramList)
  {
    AppMethodBeat.i(167120);
    d.g.b.k.h(paramList, "contacts");
    this.dataList.clear();
    this.dataList.addAll((Collection)paramList);
    AppMethodBeat.o(167120);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(167119);
    int i = this.dataList.size();
    AppMethodBeat.o(167119);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(167116);
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = View.inflate((Context)this.djj, 2131494016, null);
      paramView = new a();
      d.g.b.k.g(paramViewGroup, "itemView");
      paramViewGroup.setTag(paramView);
    }
    paramView = paramViewGroup.getTag();
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.ContactListAdapter.ContactViewHolder");
      AppMethodBeat.o(167116);
      throw paramView;
    }
    paramView = (a)paramView;
    Object localObject1 = paramViewGroup.findViewById(2131297008);
    d.g.b.k.g(localObject1, "itemView.findViewById(R.id.avatar_iv)");
    localObject1 = (ImageView)localObject1;
    d.g.b.k.h(localObject1, "<set-?>");
    paramView.fuj = ((ImageView)localObject1);
    localObject1 = paramViewGroup.findViewById(2131302867);
    d.g.b.k.g(localObject1, "itemView.findViewById(R.id.nickname_tv)");
    localObject1 = (TextView)localObject1;
    d.g.b.k.h(localObject1, "<set-?>");
    paramView.nkb = ((TextView)localObject1);
    localObject1 = paramViewGroup.findViewById(2131296977);
    d.g.b.k.g(localObject1, "itemView.findViewById(R.id.auth_icon)");
    localObject1 = (ImageView)localObject1;
    d.g.b.k.h(localObject1, "<set-?>");
    paramView.qAi = ((ImageView)localObject1);
    localObject1 = paramViewGroup.findViewById(2131296980);
    d.g.b.k.g(localObject1, "itemView.findViewById(R.id.auth_job)");
    localObject1 = (TextView)localObject1;
    d.g.b.k.h(localObject1, "<set-?>");
    paramView.qKL = ((TextView)localObject1);
    localObject1 = CW(paramInt);
    Object localObject2 = h.qCF;
    localObject2 = h.cmV();
    com.tencent.mm.plugin.finder.loader.a locala = new com.tencent.mm.plugin.finder.loader.a(((f)localObject1).cks());
    ImageView localImageView = paramView.fuj;
    if (localImageView == null) {
      d.g.b.k.aPZ("avatarIv");
    }
    h localh = h.qCF;
    ((d)localObject2).a(locala, localImageView, h.a(h.a.qCI));
    localObject2 = paramView.nkb;
    if (localObject2 == null) {
      d.g.b.k.aPZ("nicknameTv");
    }
    ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this.djj, (CharSequence)((f)localObject1).Su()));
    localObject2 = ((f)localObject1).field_authInfo;
    if (localObject2 != null)
    {
      paramInt = ((FinderAuthInfo)localObject2).authIconType;
      paramView.cqO().setVisibility(8);
      if (paramInt <= 0) {
        break label565;
      }
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(167116);
      return paramViewGroup;
      paramInt = 0;
      break;
      paramView.cqN().setVisibility(0);
      paramView.cqO().setVisibility(0);
      paramView.cqN().setImageDrawable(am.i((Context)this.djj, 2131690481, this.djj.getResources().getColor(2131099777)));
      localObject2 = paramView.cqO();
      paramView = ((f)localObject1).field_authInfo;
      if (paramView != null)
      {
        paramView = paramView.authProfession;
        if (paramView == null) {}
      }
      for (paramView = (CharSequence)paramView;; paramView = (CharSequence)"")
      {
        ((TextView)localObject2).setText(paramView);
        break;
      }
      paramView.cqN().setVisibility(0);
      paramView.cqN().setImageDrawable(am.i((Context)this.djj, 2131690481, this.djj.getResources().getColor(2131099748)));
      continue;
      paramView.cqN().setVisibility(8);
      paramView.cqO().setVisibility(8);
      continue;
      label565:
      paramView.cqN().setVisibility(8);
      paramView.cqO().setVisibility(8);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/ContactListAdapter$ContactViewHolder;", "", "()V", "authIcon", "Landroid/widget/ImageView;", "getAuthIcon", "()Landroid/widget/ImageView;", "setAuthIcon", "(Landroid/widget/ImageView;)V", "authJob", "Landroid/widget/TextView;", "getAuthJob", "()Landroid/widget/TextView;", "setAuthJob", "(Landroid/widget/TextView;)V", "avatarIv", "getAvatarIv", "setAvatarIv", "nicknameTv", "getNicknameTv", "setNicknameTv", "plugin-finder_release"})
  static final class a
  {
    public ImageView fuj;
    public TextView nkb;
    public ImageView qAi;
    public TextView qKL;
    
    public final ImageView cqN()
    {
      AppMethodBeat.i(167114);
      ImageView localImageView = this.qAi;
      if (localImageView == null) {
        d.g.b.k.aPZ("authIcon");
      }
      AppMethodBeat.o(167114);
      return localImageView;
    }
    
    public final TextView cqO()
    {
      AppMethodBeat.i(167115);
      TextView localTextView = this.qKL;
      if (localTextView == null) {
        d.g.b.k.aPZ("authJob");
      }
      AppMethodBeat.o(167115);
      return localTextView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.a
 * JD-Core Version:    0.7.0.1
 */