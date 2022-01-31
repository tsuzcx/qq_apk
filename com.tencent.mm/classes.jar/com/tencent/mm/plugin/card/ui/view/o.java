package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;

public final class o
  extends i
{
  private TextView kBA;
  private TextView kBB;
  private View kBy;
  private ImageView kBz;
  
  public final void bfq()
  {
    AppMethodBeat.i(88774);
    this.kBy.setVisibility(8);
    AppMethodBeat.o(88774);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(88772);
    this.kBy = findViewById(2131822072);
    this.kBz = ((ImageView)findViewById(2131824305));
    this.kBA = ((TextView)findViewById(2131824306));
    this.kBB = ((TextView)findViewById(2131824307));
    this.kBy.setVisibility(8);
    AppMethodBeat.o(88772);
  }
  
  public final void update()
  {
    AppMethodBeat.i(88773);
    b localb = this.kBh.bdv();
    MMActivity localMMActivity = this.kBh.bdy();
    e.a locala = this.kBh.bdC();
    this.kBy.setVisibility(0);
    this.kBA.setText(com.tencent.mm.pluginsdk.ui.d.j.b(localMMActivity, ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(locala.ktc).Oe(), this.kBA.getTextSize()));
    if ((localb.bbf() != null) && (!TextUtils.isEmpty(localb.bbf().xMB))) {
      this.kBB.setText(com.tencent.mm.pluginsdk.ui.d.j.b(localMMActivity, localb.bbf().xMB, this.kBB.getTextSize()));
    }
    for (;;)
    {
      a.b.c(this.kBz, locala.ktc);
      this.kBz.setOnClickListener(this.kBh.bdz());
      AppMethodBeat.o(88773);
      return;
      if (!TextUtils.isEmpty(localb.bbd().knv))
      {
        if (localb.baP()) {
          this.kBB.setText(localMMActivity.getString(2131297965, new Object[] { localb.bbd().knv }));
        } else {
          this.kBB.setText(localMMActivity.getString(2131297938, new Object[] { localb.bbd().knv }));
        }
      }
      else if (localb.baP()) {
        this.kBB.setText(localMMActivity.getString(2131297965, new Object[] { this.kBh.bdD().getTitle() }));
      } else {
        this.kBB.setText(localMMActivity.getString(2131297938, new Object[] { this.kBh.bdD().getTitle() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.o
 * JD-Core Version:    0.7.0.1
 */