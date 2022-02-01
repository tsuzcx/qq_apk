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
import com.tencent.mm.aj.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.s;

public final class a
  extends s<n>
{
  private String jZG;
  a kco;
  private Context mContext;
  private String mFilter;
  private LayoutInflater mLayoutInflater;
  
  public a(Context paramContext, String paramString)
  {
    super(paramContext, new n());
    AppMethodBeat.i(110068);
    this.jZG = paramString;
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(110068);
  }
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(110071);
    this.mFilter = Util.escapeSqlValue(paramString);
    ebf();
    anp();
    AppMethodBeat.o(110071);
  }
  
  public final void anp()
  {
    AppMethodBeat.i(110070);
    setCursor(((o)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).bZ(this.mFilter, this.jZG));
    super.notifyDataSetChanged();
    AppMethodBeat.o(110070);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(110069);
    anp();
    AppMethodBeat.o(110069);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(110072);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = this.mLayoutInflater.inflate(2131494980, null);
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
    paramViewGroup.kcp = localn.field_googlegmail;
    switch (localn.field_status)
    {
    default: 
      if (TextUtils.isEmpty(localn.field_googlename))
      {
        paramViewGroup.gxs.setText(Util.subStringEmail(localn.field_googlegmail));
        switch (localn.field_status)
        {
        default: 
          switch (localn.field_googlecgistatus)
          {
          default: 
            paramViewGroup.kcq.setText(localn.field_googlegmail);
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
    for (Bitmap localBitmap = c.a(localn.field_username, false, -1, null);; localBitmap = null)
    {
      if (localBitmap == null)
      {
        paramViewGroup.gyr.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131690042));
        break;
      }
      paramViewGroup.gyr.setImageBitmap(localBitmap);
      break;
      localBitmap = c.LV(localn.field_googleid);
      if (localBitmap == null)
      {
        paramViewGroup.gyr.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131690042));
        break;
      }
      paramViewGroup.gyr.setImageBitmap(localBitmap);
      break;
      paramViewGroup.gxs.setText(localn.field_googlename);
      break label146;
      paramViewGroup.kcr.setClickable(true);
      paramViewGroup.kcr.setBackgroundResource(2131231429);
      paramViewGroup.gCd.setText(2131761393);
      paramViewGroup.gCd.setTextColor(this.mContext.getResources().getColor(2131101424));
      break label176;
      paramViewGroup.kcr.setClickable(true);
      paramViewGroup.kcr.setBackgroundResource(2131231431);
      paramViewGroup.gCd.setText(2131761401);
      paramViewGroup.gCd.setTextColor(this.mContext.getResources().getColor(2131100682));
      break label176;
      paramViewGroup.kcr.setClickable(false);
      paramViewGroup.kcr.setBackgroundDrawable(null);
      paramViewGroup.gCd.setText(2131761395);
      paramViewGroup.gCd.setTextColor(this.mContext.getResources().getColor(2131100682));
      break label176;
      paramViewGroup.gCd.setVisibility(4);
      paramViewGroup.kcs.setVisibility(0);
      break label208;
      paramViewGroup.kcr.setClickable(false);
      paramViewGroup.kcr.setBackgroundDrawable(null);
      paramViewGroup.gCd.setVisibility(0);
      paramViewGroup.kcs.setVisibility(8);
      paramViewGroup.gCd.setTextColor(this.mContext.getResources().getColor(2131100682));
      switch (localn.field_status)
      {
      default: 
        break;
      case 0: 
        paramViewGroup.gCd.setText(2131761394);
        break;
      case 1: 
        paramViewGroup.gCd.setText(2131761402);
        break;
        paramViewGroup.gCd.setVisibility(0);
        paramViewGroup.kcs.setVisibility(8);
        switch (localn.field_status)
        {
        default: 
          break;
        case 0: 
          paramViewGroup.gCd.setText(2131761393);
          paramViewGroup.gCd.setTextColor(this.mContext.getResources().getColor(2131101424));
          break;
        case 1: 
          paramViewGroup.gCd.setText(2131761401);
          paramViewGroup.gCd.setTextColor(this.mContext.getResources().getColor(2131100682));
          break;
        }
        break;
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void vd(int paramInt);
  }
  
  final class b
  {
    TextView gCd;
    TextView gxs;
    ImageView gyr;
    String kcp;
    TextView kcq;
    View kcr;
    ProgressBar kcs;
    int position;
    
    public b(View paramView)
    {
      AppMethodBeat.i(110067);
      this.gyr = ((ImageView)paramView.findViewById(2131302107));
      this.gxs = ((TextView)paramView.findViewById(2131302111));
      this.kcr = paramView.findViewById(2131302112);
      this.gCd = ((TextView)paramView.findViewById(2131302113));
      this.kcs = ((ProgressBar)paramView.findViewById(2131302110));
      this.kcq = ((TextView)paramView.findViewById(2131302108));
      this.kcr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110066);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/GoogleFriendAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.d("MicroMsg.GoogleContact.GoogleFriendAdapter", "onClick");
          if (a.a(a.this) != null) {
            a.a(a.this).vd(a.b.this.position);
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