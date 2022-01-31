package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.bru;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;

public final class a
  extends i
{
  private View ixH;
  
  public final void aCU()
  {
    this.ixH.setVisibility(8);
  }
  
  public final void initView()
  {
    this.ixH = findViewById(a.d.card_accept_header_layout);
  }
  
  public final void update()
  {
    Object localObject = this.iya.aBJ();
    b localb = this.iya.aBE();
    MMActivity localMMActivity = this.iya.aBH();
    e.a locala = this.iya.aBL();
    f localf = this.iya.aBM();
    if (((com.tencent.mm.plugin.card.ui.a.g)localObject).aCE())
    {
      this.ixH.setVisibility(0);
      findViewById(a.d.accept_header_from_username_container).setVisibility(0);
      localObject = (ImageView)findViewById(a.d.accept_header_from_username_avatar);
      TextView localTextView1 = (TextView)findViewById(a.d.accept_header_from_username_tv);
      TextView localTextView2 = (TextView)findViewById(a.d.accept_ui_title);
      if (locala.irV != null) {
        localTextView1.setText(com.tencent.mm.pluginsdk.ui.d.j.a(localMMActivity, ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(locala.irV).Bp(), localTextView1.getTextSize()));
      }
      if (locala.drX == 23) {
        if (!TextUtils.isEmpty(localb.azx().sIQ)) {
          localTextView2.setText(localb.azx().sIQ);
        }
      }
      for (;;)
      {
        a.b.a((ImageView)localObject, locala.irV, 0.15F, false);
        ((ImageView)localObject).setOnClickListener(this.iya.aBI());
        return;
        if (!TextUtils.isEmpty(localb.azx().imz))
        {
          localTextView2.setText(localMMActivity.getString(a.g.card_recommend_tips, new Object[] { localb.azx().imz }));
        }
        else
        {
          localTextView2.setText(localMMActivity.getString(a.g.card_recommend_tips, new Object[] { localf.getTitle() }));
          continue;
          if ((localb.azz() != null) && (!TextUtils.isEmpty(localb.azz().tIn))) {
            localTextView2.setText(localb.azz().tIn);
          } else if (!TextUtils.isEmpty(localb.azx().imz))
          {
            if (localb.azj()) {
              localTextView2.setText(localMMActivity.getString(a.g.card_invoice_tips, new Object[] { localb.azx().imz }));
            } else {
              localTextView2.setText(localMMActivity.getString(a.g.card_gift_tips, new Object[] { localb.azx().imz }));
            }
          }
          else if (localb.azj()) {
            localTextView2.setText(localMMActivity.getString(a.g.card_invoice_tips, new Object[] { localf.getTitle() }));
          } else {
            localTextView2.setText(localMMActivity.getString(a.g.card_gift_tips, new Object[] { localf.getTitle() }));
          }
        }
      }
    }
    if (((com.tencent.mm.plugin.card.ui.a.g)localObject).aCF())
    {
      if (!TextUtils.isEmpty(localb.azx().sIQ))
      {
        this.ixH.setVisibility(0);
        findViewById(a.d.accept_header_from_username_container).setVisibility(8);
        ((TextView)findViewById(a.d.accept_ui_title)).setText(localb.azx().sIQ);
        return;
      }
      this.ixH.setVisibility(8);
      return;
    }
    aCU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.a
 * JD-Core Version:    0.7.0.1
 */