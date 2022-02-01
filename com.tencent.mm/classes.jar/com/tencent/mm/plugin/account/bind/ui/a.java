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
import com.tencent.mm.am.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.bind.a.d;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.h;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.v;

public final class a
  extends v<n>
{
  private Context mContext;
  private String mFilter;
  private LayoutInflater mLayoutInflater;
  private String mQZ;
  a mTN;
  
  public a(Context paramContext, String paramString)
  {
    super(paramContext, new n());
    AppMethodBeat.i(110068);
    this.mQZ = paramString;
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(110068);
  }
  
  public final void aas(String paramString)
  {
    AppMethodBeat.i(110071);
    this.mFilter = Util.escapeSqlValue(paramString);
    eKd();
    atr();
    AppMethodBeat.o(110071);
  }
  
  public final void atr()
  {
    AppMethodBeat.i(110070);
    v(((o)((com.tencent.mm.plugin.account.sdk.a.a)h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).cf(this.mFilter, this.mQZ));
    super.notifyDataSetChanged();
    AppMethodBeat.o(110070);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(110069);
    atr();
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
    n localn;
    for (;;)
    {
      localn = (n)getItem(paramInt);
      if (localn != null) {
        break;
      }
      AppMethodBeat.o(110072);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
    }
    paramViewGroup.position = paramInt;
    paramViewGroup.mTO = localn.field_googlegmail;
    switch (localn.field_status)
    {
    default: 
      if (TextUtils.isEmpty(localn.field_googlename))
      {
        paramViewGroup.jbF.setText(Util.subStringEmail(localn.field_googlegmail));
        switch (localn.field_status)
        {
        default: 
          switch (localn.field_googlecgistatus)
          {
          default: 
            paramViewGroup.mTP.setText(localn.field_googlegmail);
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
      if (localn.field_small_url == null) {}
      break;
    }
    for (Bitmap localBitmap = d.a(localn.field_username, false, -1, null);; localBitmap = null)
    {
      if (localBitmap == null)
      {
        paramViewGroup.jiu.setImageDrawable(com.tencent.mm.ci.a.m(this.mContext, a.h.default_avatar));
        break;
      }
      paramViewGroup.jiu.setImageBitmap(localBitmap);
      break;
      localBitmap = d.Tq(localn.field_googleid);
      if (localBitmap == null)
      {
        paramViewGroup.jiu.setImageDrawable(com.tencent.mm.ci.a.m(this.mContext, a.h.default_avatar));
        break;
      }
      paramViewGroup.jiu.setImageBitmap(localBitmap);
      break;
      paramViewGroup.jbF.setText(localn.field_googlename);
      break label146;
      paramViewGroup.mTQ.setClickable(true);
      paramViewGroup.mTQ.setBackgroundResource(a.d.btn_solid_green);
      paramViewGroup.jmj.setText(a.i.gcontact_add);
      paramViewGroup.jmj.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.white));
      break label176;
      paramViewGroup.mTQ.setClickable(true);
      paramViewGroup.mTQ.setBackgroundResource(a.d.btn_solid_grey);
      paramViewGroup.jmj.setText(a.i.gcontact_invite);
      paramViewGroup.jmj.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
      break label176;
      paramViewGroup.mTQ.setClickable(false);
      paramViewGroup.mTQ.setBackgroundDrawable(null);
      paramViewGroup.jmj.setText(a.i.gcontact_added);
      paramViewGroup.jmj.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
      break label176;
      paramViewGroup.jmj.setVisibility(4);
      paramViewGroup.mTR.setVisibility(0);
      break label208;
      paramViewGroup.mTQ.setClickable(false);
      paramViewGroup.mTQ.setBackgroundDrawable(null);
      paramViewGroup.jmj.setVisibility(0);
      paramViewGroup.mTR.setVisibility(8);
      paramViewGroup.jmj.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
      switch (localn.field_status)
      {
      default: 
        break;
      case 0: 
        paramViewGroup.jmj.setText(a.i.gcontact_add_done);
        break;
      case 1: 
        paramViewGroup.jmj.setText(a.i.gcontact_invite_done);
        break;
        paramViewGroup.jmj.setVisibility(0);
        paramViewGroup.mTR.setVisibility(8);
        switch (localn.field_status)
        {
        default: 
          break;
        case 0: 
          paramViewGroup.jmj.setText(a.i.gcontact_add);
          paramViewGroup.jmj.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.white));
          break;
        case 1: 
          paramViewGroup.jmj.setText(a.i.gcontact_invite);
          paramViewGroup.jmj.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
          break;
        }
        break;
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void yh(int paramInt);
  }
  
  final class b
  {
    TextView jbF;
    ImageView jiu;
    TextView jmj;
    String mTO;
    TextView mTP;
    View mTQ;
    ProgressBar mTR;
    int position;
    
    public b(View paramView)
    {
      AppMethodBeat.i(110067);
      this.jiu = ((ImageView)paramView.findViewById(a.e.gcontact_avatar_iv));
      this.jbF = ((TextView)paramView.findViewById(a.e.gcontact_name_tv));
      this.mTQ = paramView.findViewById(a.e.gcontact_operation_view);
      this.jmj = ((TextView)paramView.findViewById(a.e.gcontact_status_tv));
      this.mTR = ((ProgressBar)paramView.findViewById(a.e.gcontact_invita_pb));
      this.mTP = ((TextView)paramView.findViewById(a.e.gcontact_email_tv));
      this.mTQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110066);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/GoogleFriendAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.d("MicroMsg.GoogleContact.GoogleFriendAdapter", "onClick");
          if (a.a(a.this) != null) {
            a.a(a.this).yh(a.b.this.position);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/GoogleFriendAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110066);
        }
      });
      AppMethodBeat.o(110067);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.a
 * JD-Core Version:    0.7.0.1
 */