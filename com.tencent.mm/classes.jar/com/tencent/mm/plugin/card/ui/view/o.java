package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
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

public final class o
  extends i
{
  private View iyr;
  private ImageView iys;
  private TextView iyt;
  private TextView iyu;
  
  public final void aCU()
  {
    this.iyr.setVisibility(8);
  }
  
  public final void initView()
  {
    this.iyr = findViewById(a.d.from_username_layout);
    this.iys = ((ImageView)findViewById(a.d.from_username_avatar));
    this.iyt = ((TextView)findViewById(a.d.from_username_tv));
    this.iyu = ((TextView)findViewById(a.d.from_username_tips));
    this.iyr.setVisibility(8);
  }
  
  public final void update()
  {
    b localb = this.iya.aBE();
    MMActivity localMMActivity = this.iya.aBH();
    e.a locala = this.iya.aBL();
    this.iyr.setVisibility(0);
    this.iyt.setText(com.tencent.mm.pluginsdk.ui.d.j.a(localMMActivity, ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(locala.irV).Bp(), this.iyt.getTextSize()));
    if ((localb.azz() != null) && (!TextUtils.isEmpty(localb.azz().tIn))) {
      this.iyu.setText(com.tencent.mm.pluginsdk.ui.d.j.a(localMMActivity, localb.azz().tIn, this.iyu.getTextSize()));
    }
    for (;;)
    {
      a.b.a(this.iys, locala.irV);
      this.iys.setOnClickListener(this.iya.aBI());
      return;
      if (!TextUtils.isEmpty(localb.azx().imz))
      {
        if (localb.azj()) {
          this.iyu.setText(localMMActivity.getString(a.g.card_invoice_tips, new Object[] { localb.azx().imz }));
        } else {
          this.iyu.setText(localMMActivity.getString(a.g.card_gift_tips, new Object[] { localb.azx().imz }));
        }
      }
      else if (localb.azj()) {
        this.iyu.setText(localMMActivity.getString(a.g.card_invoice_tips, new Object[] { this.iya.aBM().getTitle() }));
      } else {
        this.iyu.setText(localMMActivity.getString(a.g.card_gift_tips, new Object[] { this.iya.aBM().getTitle() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.o
 * JD-Core Version:    0.7.0.1
 */