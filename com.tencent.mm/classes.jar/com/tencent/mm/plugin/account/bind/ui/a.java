package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.plugin.account.bind.a.d;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.h;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.model.k;
import com.tencent.mm.plugin.account.friend.model.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.x;

public final class a
  extends x<k>
{
  private Context mContext;
  private LayoutInflater mLayoutInflater;
  private String pNG;
  a pQu;
  private String pQv;
  
  public a(Context paramContext, String paramString)
  {
    super(paramContext, new k());
    AppMethodBeat.i(110068);
    this.pNG = paramString;
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(110068);
  }
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(110071);
    this.pQv = Util.escapeSqlValue(paramString);
    fSd();
    aNy();
    AppMethodBeat.o(110071);
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(110070);
    w(((l)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).ct(this.pQv, this.pNG));
    super.notifyDataSetChanged();
    AppMethodBeat.o(110070);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(110069);
    aNy();
    AppMethodBeat.o(110069);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(110072);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = this.mLayoutInflater.inflate(a.f.gcontact_friend_list_item, null);
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
    }
    k localk;
    for (;;)
    {
      localk = (k)getItem(paramInt);
      if (localk != null) {
        break;
      }
      AppMethodBeat.o(110072);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
    }
    paramViewGroup.position = paramInt;
    paramViewGroup.pQw = localk.field_googlegmail;
    switch (localk.field_status)
    {
    default: 
      if (TextUtils.isEmpty(localk.field_googlename))
      {
        paramViewGroup.lDF.setText(Util.subStringEmail(localk.field_googlegmail));
        switch (localk.field_status)
        {
        default: 
          switch (localk.field_googlecgistatus)
          {
          default: 
            paramViewGroup.pQx.setText(localk.field_googlegmail);
            AppMethodBeat.o(110072);
            return paramView;
          }
          break;
        }
      }
      break;
    case 0: 
    case 2: 
      label146:
      label176:
      label208:
      if (localk.field_small_url == null) {}
      break;
    }
    for (Bitmap localBitmap = d.a(localk.field_username, false, -1, null);; localBitmap = null)
    {
      if (localBitmap == null)
      {
        paramViewGroup.lKK.setImageDrawable(com.tencent.mm.cd.a.m(this.mContext, a.h.default_avatar));
        break;
      }
      paramViewGroup.lKK.setImageBitmap(localBitmap);
      break;
      localBitmap = d.Ls(localk.field_googleid);
      if (localBitmap == null)
      {
        paramViewGroup.lKK.setImageDrawable(com.tencent.mm.cd.a.m(this.mContext, a.h.default_avatar));
        break;
      }
      paramViewGroup.lKK.setImageBitmap(localBitmap);
      break;
      paramViewGroup.lDF.setText(localk.field_googlename);
      break label146;
      paramViewGroup.pQy.setClickable(true);
      paramViewGroup.pQy.setBackgroundResource(a.d.btn_solid_green);
      paramViewGroup.lPf.setText(a.i.gcontact_add);
      paramViewGroup.lPf.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.white));
      break label176;
      paramViewGroup.pQy.setClickable(true);
      paramViewGroup.pQy.setBackgroundResource(a.d.btn_solid_grey);
      paramViewGroup.lPf.setText(a.i.gcontact_invite);
      paramViewGroup.lPf.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
      break label176;
      paramViewGroup.pQy.setClickable(false);
      paramViewGroup.pQy.setBackgroundDrawable(null);
      paramViewGroup.lPf.setText(a.i.gcontact_added);
      paramViewGroup.lPf.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
      break label176;
      paramViewGroup.lPf.setVisibility(4);
      paramViewGroup.pQz.setVisibility(0);
      break label208;
      paramViewGroup.pQy.setClickable(false);
      paramViewGroup.pQy.setBackgroundDrawable(null);
      paramViewGroup.lPf.setVisibility(0);
      paramViewGroup.pQz.setVisibility(8);
      paramViewGroup.lPf.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
      switch (localk.field_status)
      {
      default: 
        break;
      case 0: 
        paramViewGroup.lPf.setText(a.i.gcontact_add_done);
        break;
      case 1: 
        paramViewGroup.lPf.setText(a.i.gcontact_invite_done);
        break;
        paramViewGroup.lPf.setVisibility(0);
        paramViewGroup.pQz.setVisibility(8);
        switch (localk.field_status)
        {
        default: 
          break;
        case 0: 
          paramViewGroup.lPf.setText(a.i.gcontact_add);
          paramViewGroup.lPf.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.white));
          break;
        case 1: 
          paramViewGroup.lPf.setText(a.i.gcontact_invite);
          paramViewGroup.lPf.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
          break;
        }
        break;
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void yn(int paramInt);
  }
  
  final class b
  {
    TextView lDF;
    ImageView lKK;
    TextView lPf;
    String pQw;
    TextView pQx;
    View pQy;
    ProgressBar pQz;
    int position;
    
    public b(View paramView)
    {
      AppMethodBeat.i(110067);
      this.lKK = ((ImageView)paramView.findViewById(a.e.gcontact_avatar_iv));
      this.lDF = ((TextView)paramView.findViewById(a.e.gcontact_name_tv));
      this.pQy = paramView.findViewById(a.e.gcontact_operation_view);
      this.lPf = ((TextView)paramView.findViewById(a.e.gcontact_status_tv));
      this.pQz = ((ProgressBar)paramView.findViewById(a.e.gcontact_invita_pb));
      this.pQx = ((TextView)paramView.findViewById(a.e.gcontact_email_tv));
      this.pQy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110066);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/GoogleFriendAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.d("MicroMsg.GoogleContact.GoogleFriendAdapter", "onClick");
          if (a.a(a.this) != null) {
            a.a(a.this).yn(a.b.this.position);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/GoogleFriendAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110066);
        }
      });
      AppMethodBeat.o(110067);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.a
 * JD-Core Version:    0.7.0.1
 */