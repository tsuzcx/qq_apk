package com.tencent.mm.plugin.account.friend.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.a.o;
import com.tencent.mm.ag.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.e;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends d
{
  private final int Th;
  private final MMActivity bER;
  private String fdR;
  private final a fhZ;
  private final c fia;
  private d.a fib;
  boolean fic = false;
  private e.a fid = new e.1(this);
  
  public e(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, new ao());
    this.bER = paramMMActivity;
    this.Th = paramInt;
    this.fic = paramMMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
    this.fhZ = new a(paramMMActivity, new e.2(this));
    this.fia = new c(paramMMActivity, new e.3(this));
  }
  
  public final void a(d.a parama)
  {
    this.fib = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ao localao = (ao)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.bER, a.e.qq_friend_item, null);
      paramViewGroup = new e.b(this, paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.fdX = paramInt;
      paramViewGroup.fig = localao.fgW;
      paramViewGroup.status = localao.fgX;
      paramViewGroup.fdY.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.bER, localao.getDisplayName(), paramViewGroup.fdY.getTextSize()));
      if (o.bS(localao.fgW) == 0) {
        break label610;
      }
    }
    label200:
    label610:
    for (Bitmap localBitmap = b.bG(localao.fgW);; localBitmap = null)
    {
      if (localBitmap == null) {
        paramViewGroup.dpY.setImageDrawable(com.tencent.mm.cb.a.g(this.bER, a.g.default_avatar));
      }
      for (;;)
      {
        if (!this.fic) {
          break label200;
        }
        paramViewGroup.fdZ.setVisibility(8);
        return paramView;
        paramViewGroup = (e.b)paramView.getTag();
        break;
        paramViewGroup.dpY.setImageBitmap(localBitmap);
      }
      switch (localao.fgX)
      {
      }
      for (;;)
      {
        switch (localao.ebQ)
        {
        default: 
          return paramView;
        case 0: 
        case 2: 
          paramViewGroup.eXu.setVisibility(0);
          paramViewGroup.fea.setVisibility(4);
          return paramView;
          if (localao.ebQ == 2)
          {
            paramViewGroup.fdZ.setClickable(false);
            paramViewGroup.fdZ.setBackgroundDrawable(null);
            paramViewGroup.eXu.setText(a.h.friend_invited);
            paramViewGroup.eXu.setTextColor(this.bER.getResources().getColor(a.b.lightgrey));
          }
          else
          {
            paramViewGroup.fdZ.setClickable(true);
            paramViewGroup.fdZ.setBackgroundResource(a.c.btn_solid_green);
            paramViewGroup.eXu.setText(a.h.friend_invite);
            paramViewGroup.eXu.setTextColor(this.bER.getResources().getColor(a.b.white));
            continue;
            if ((((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abg(localao.getUsername())) || (q.Gj().equals(localao.getUsername())))
            {
              paramViewGroup.fdZ.setClickable(false);
              paramViewGroup.fdZ.setBackgroundDrawable(null);
              paramViewGroup.eXu.setText(a.h.friend_added);
              paramViewGroup.eXu.setTextColor(this.bER.getResources().getColor(a.b.lightgrey));
            }
            else if (localao.ebQ == 2)
            {
              paramViewGroup.fdZ.setClickable(false);
              paramViewGroup.fdZ.setBackgroundDrawable(null);
              paramViewGroup.eXu.setText(a.h.friend_waiting_ask);
              paramViewGroup.eXu.setTextColor(this.bER.getResources().getColor(a.b.lightgrey));
            }
            else
            {
              paramViewGroup.fdZ.setClickable(true);
              paramViewGroup.fdZ.setBackgroundResource(a.c.btn_solid_green);
              paramViewGroup.eXu.setText(a.h.friend_add);
              paramViewGroup.eXu.setTextColor(this.bER.getResources().getColor(a.b.white));
            }
          }
          break;
        }
      }
      paramViewGroup.eXu.setVisibility(4);
      paramViewGroup.fea.setVisibility(0);
      return paramView;
    }
  }
  
  public final void kk(String paramString)
  {
    notifyDataSetChanged();
  }
  
  public final void pA(String paramString)
  {
    this.fdR = bk.pl(paramString.trim());
    bcS();
    yc();
  }
  
  public final void yc()
  {
    bcS();
    if (bk.bl(this.fdR)) {
      setCursor(((ap)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).A(this.Th, this.fic));
    }
    for (;;)
    {
      if ((this.fib != null) && (this.fdR != null)) {
        this.fib.jU(getCursor().getCount());
      }
      notifyDataSetChanged();
      return;
      setCursor(((ap)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).c(this.Th, this.fdR, this.fic));
    }
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.e
 * JD-Core Version:    0.7.0.1
 */