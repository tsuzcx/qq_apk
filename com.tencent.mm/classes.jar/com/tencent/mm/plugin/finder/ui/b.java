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
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.ui.am;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/ContactListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "Lkotlin/collections/ArrayList;", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setContactList", "", "contacts", "", "ContactViewHolder", "plugin-finder_release"})
public final class b
  extends BaseAdapter
{
  private String TAG;
  private ArrayList<f> dataList;
  private Activity dgE;
  
  public b(Activity paramActivity)
  {
    AppMethodBeat.i(167121);
    this.TAG = "Finder.ContactListAdapter";
    this.dgE = paramActivity;
    this.dataList = new ArrayList();
    AppMethodBeat.o(167121);
  }
  
  public final f Ep(int paramInt)
  {
    AppMethodBeat.i(167117);
    Object localObject = this.dataList.get(paramInt);
    d.g.b.k.g(localObject, "dataList[position]");
    localObject = (f)localObject;
    AppMethodBeat.o(167117);
    return localObject;
  }
  
  public final void dC(List<f> paramList)
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
      paramViewGroup = View.inflate((Context)this.dgE, 2131494016, null);
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
    paramView.fxQ = ((ImageView)localObject1);
    localObject1 = paramViewGroup.findViewById(2131302867);
    d.g.b.k.g(localObject1, "itemView.findViewById(R.id.nickname_tv)");
    localObject1 = (TextView)localObject1;
    d.g.b.k.h(localObject1, "<set-?>");
    paramView.nMU = ((TextView)localObject1);
    localObject1 = paramViewGroup.findViewById(2131296977);
    d.g.b.k.g(localObject1, "itemView.findViewById(R.id.auth_icon)");
    localObject1 = (ImageView)localObject1;
    d.g.b.k.h(localObject1, "<set-?>");
    paramView.rqZ = ((ImageView)localObject1);
    localObject1 = paramViewGroup.findViewById(2131296980);
    d.g.b.k.g(localObject1, "itemView.findViewById(R.id.auth_job)");
    localObject1 = (TextView)localObject1;
    d.g.b.k.h(localObject1, "<set-?>");
    paramView.rFt = ((TextView)localObject1);
    localObject1 = Ep(paramInt);
    Object localObject2 = h.rtK;
    localObject2 = h.cwo();
    a locala = new a(((f)localObject1).crZ());
    ImageView localImageView = paramView.fxQ;
    if (localImageView == null) {
      d.g.b.k.aVY("avatarIv");
    }
    h localh = h.rtK;
    ((d)localObject2).a(locala, localImageView, h.a(h.a.rtN));
    localObject2 = paramView.nMU;
    if (localObject2 == null) {
      d.g.b.k.aVY("nicknameTv");
    }
    ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this.dgE, (CharSequence)((f)localObject1).Tn()));
    localObject2 = ((f)localObject1).field_authInfo;
    if (localObject2 != null)
    {
      paramInt = ((FinderAuthInfo)localObject2).authIconType;
      paramView.cBr().setVisibility(8);
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
      paramView.cBq().setVisibility(0);
      paramView.cBr().setVisibility(0);
      paramView.cBq().setImageDrawable(am.k((Context)this.dgE, 2131690481, this.dgE.getResources().getColor(2131099777)));
      localObject2 = paramView.cBr();
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
      paramView.cBq().setVisibility(0);
      paramView.cBq().setImageDrawable(am.k((Context)this.dgE, 2131690481, this.dgE.getResources().getColor(2131099748)));
      continue;
      paramView.cBq().setVisibility(8);
      paramView.cBr().setVisibility(8);
      continue;
      label565:
      paramView.cBq().setVisibility(8);
      paramView.cBr().setVisibility(8);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/ContactListAdapter$ContactViewHolder;", "", "()V", "authIcon", "Landroid/widget/ImageView;", "getAuthIcon", "()Landroid/widget/ImageView;", "setAuthIcon", "(Landroid/widget/ImageView;)V", "authJob", "Landroid/widget/TextView;", "getAuthJob", "()Landroid/widget/TextView;", "setAuthJob", "(Landroid/widget/TextView;)V", "avatarIv", "getAvatarIv", "setAvatarIv", "nicknameTv", "getNicknameTv", "setNicknameTv", "plugin-finder_release"})
  static final class a
  {
    public ImageView fxQ;
    public TextView nMU;
    public TextView rFt;
    public ImageView rqZ;
    
    public final ImageView cBq()
    {
      AppMethodBeat.i(167114);
      ImageView localImageView = this.rqZ;
      if (localImageView == null) {
        d.g.b.k.aVY("authIcon");
      }
      AppMethodBeat.o(167114);
      return localImageView;
    }
    
    public final TextView cBr()
    {
      AppMethodBeat.i(167115);
      TextView localTextView = this.rFt;
      if (localTextView == null) {
        d.g.b.k.aVY("authJob");
      }
      AppMethodBeat.o(167115);
      return localTextView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.b
 * JD-Core Version:    0.7.0.1
 */