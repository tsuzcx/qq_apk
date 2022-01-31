package com.tencent.mm.plugin.card.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.b.k.a;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;

public final class i
  implements k.a
{
  MMActivity hxN;
  View ipf;
  boolean iqM = false;
  View ivW;
  TextView ivX;
  ImageView ivY;
  View ivZ;
  TextView iwa;
  ImageView iwb;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    this.hxN = paramMMActivity;
    this.ipf = paramView;
  }
  
  public final void a(com.tencent.mm.plugin.card.model.g paramg)
  {
    aCb();
  }
  
  final void aCb()
  {
    int i = am.aAw().ilg;
    if ((i > 0) && (this.iqM))
    {
      String str1 = (String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.upb, "");
      String str2 = (String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.upc, "");
      int j = this.hxN.getResources().getDimensionPixelOffset(a.b.card_index_newmsg_logo_height);
      if (!TextUtils.isEmpty(str2))
      {
        m.a(this.ivY, str2, j, a.c.card_msg_inform, true);
        if (TextUtils.isEmpty(str1)) {
          break label180;
        }
        this.ivX.setText(str1);
        label106:
        this.ivW.setVisibility(0);
        if (this.ivZ != null)
        {
          if (TextUtils.isEmpty(str2)) {
            break label211;
          }
          m.a(this.iwb, str2, j, a.c.card_msg_inform, true);
          label143:
          if (TextUtils.isEmpty(str1)) {
            break label224;
          }
          this.iwa.setText(str1);
          label158:
          this.ivZ.setVisibility(0);
        }
      }
    }
    label180:
    label211:
    label224:
    do
    {
      return;
      this.ivY.setImageResource(a.c.card_msg_inform);
      break;
      this.ivX.setText(this.hxN.getString(a.g.card_index_new_msg, new Object[] { Integer.valueOf(i) }));
      break label106;
      this.iwb.setImageResource(a.c.card_msg_inform);
      break label143;
      this.iwa.setText(this.hxN.getString(a.g.card_index_new_msg, new Object[] { Integer.valueOf(i) }));
      break label158;
      this.ivW.setVisibility(8);
    } while (this.ivZ == null);
    this.ivZ.setVisibility(8);
  }
  
  public final void axs() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.i
 * JD-Core Version:    0.7.0.1
 */