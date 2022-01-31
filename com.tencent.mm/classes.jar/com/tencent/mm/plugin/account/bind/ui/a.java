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
import com.tencent.mm.ah.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.p;

public final class a
  extends p<n>
{
  private String gsq;
  a.a gvc;
  private Context mContext;
  private String mFilter;
  private LayoutInflater mLayoutInflater;
  
  public a(Context paramContext, String paramString)
  {
    super(paramContext, new n());
    AppMethodBeat.i(13644);
    this.gsq = paramString;
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(13644);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(13646);
    setCursor(((o)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).bl(this.mFilter, this.gsq));
    super.notifyDataSetChanged();
    AppMethodBeat.o(13646);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(13645);
    Ku();
    AppMethodBeat.o(13645);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(13648);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = this.mLayoutInflater.inflate(2130969837, null);
      paramViewGroup = new a.b(this, paramView);
      paramView.setTag(paramViewGroup);
    }
    n localn;
    for (;;)
    {
      localn = (n)getItem(paramInt);
      if (localn != null) {
        break;
      }
      AppMethodBeat.o(13648);
      return paramView;
      paramViewGroup = (a.b)paramView.getTag();
    }
    paramViewGroup.position = paramInt;
    paramViewGroup.gvd = localn.field_googlegmail;
    switch (localn.field_status)
    {
    default: 
      if (TextUtils.isEmpty(localn.field_googlename))
      {
        paramViewGroup.gve.setText(bo.aqf(localn.field_googlegmail));
        switch (localn.field_status)
        {
        default: 
          switch (localn.field_googlecgistatus)
          {
          default: 
            paramViewGroup.gvf.setText(localn.field_googlegmail);
            AppMethodBeat.o(13648);
            return paramView;
          }
          break;
        }
      }
      break;
    case 0: 
    case 2: 
      label150:
      label180:
      label212:
      if (localn.field_small_url == null) {}
      break;
    }
    for (Bitmap localBitmap = b.b(localn.field_username, false, -1);; localBitmap = null)
    {
      if (localBitmap == null)
      {
        paramViewGroup.ehv.setImageDrawable(com.tencent.mm.cb.a.k(this.mContext, 2131231207));
        break;
      }
      paramViewGroup.ehv.setImageBitmap(localBitmap);
      break;
      localBitmap = b.qK(localn.field_googleid);
      if (localBitmap == null)
      {
        paramViewGroup.ehv.setImageDrawable(com.tencent.mm.cb.a.k(this.mContext, 2131231207));
        break;
      }
      paramViewGroup.ehv.setImageBitmap(localBitmap);
      break;
      paramViewGroup.gve.setText(localn.field_googlename);
      break label150;
      paramViewGroup.gvg.setClickable(true);
      paramViewGroup.gvg.setBackgroundResource(2130838045);
      paramViewGroup.gpr.setText(2131300479);
      paramViewGroup.gpr.setTextColor(this.mContext.getResources().getColor(2131690709));
      break label180;
      paramViewGroup.gvg.setClickable(true);
      paramViewGroup.gvg.setBackgroundResource(2130838047);
      paramViewGroup.gpr.setText(2131300487);
      paramViewGroup.gpr.setTextColor(this.mContext.getResources().getColor(2131690211));
      break label180;
      paramViewGroup.gvg.setClickable(false);
      paramViewGroup.gvg.setBackgroundDrawable(null);
      paramViewGroup.gpr.setText(2131300481);
      paramViewGroup.gpr.setTextColor(this.mContext.getResources().getColor(2131690211));
      break label180;
      paramViewGroup.gpr.setVisibility(4);
      paramViewGroup.gvh.setVisibility(0);
      break label212;
      paramViewGroup.gvg.setClickable(false);
      paramViewGroup.gvg.setBackgroundDrawable(null);
      paramViewGroup.gpr.setVisibility(0);
      paramViewGroup.gvh.setVisibility(8);
      paramViewGroup.gpr.setTextColor(this.mContext.getResources().getColor(2131690211));
      switch (localn.field_status)
      {
      default: 
        break;
      case 0: 
        paramViewGroup.gpr.setText(2131300480);
        break;
      case 1: 
        paramViewGroup.gpr.setText(2131300488);
        break;
        paramViewGroup.gpr.setVisibility(0);
        paramViewGroup.gvh.setVisibility(8);
        switch (localn.field_status)
        {
        default: 
          break;
        case 0: 
          paramViewGroup.gpr.setText(2131300479);
          paramViewGroup.gpr.setTextColor(this.mContext.getResources().getColor(2131690709));
          break;
        case 1: 
          paramViewGroup.gpr.setText(2131300487);
          paramViewGroup.gpr.setTextColor(this.mContext.getResources().getColor(2131690211));
          break;
        }
        break;
      }
    }
  }
  
  public final void wQ(String paramString)
  {
    AppMethodBeat.i(13647);
    this.mFilter = bo.wC(paramString);
    bKb();
    Ku();
    AppMethodBeat.o(13647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.a
 * JD-Core Version:    0.7.0.1
 */