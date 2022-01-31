package com.tencent.mm.plugin.account.friend.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ah.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f
  extends d
{
  private final int TR;
  private final MMActivity cmc;
  private String gvB;
  private d.a gzI;
  boolean gzQ;
  private f.a gzR;
  
  public f(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, new ao());
    AppMethodBeat.i(108606);
    this.gzQ = false;
    this.gzR = new f.a()
    {
      public final void d(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(108603);
        ab.d("MicroMsg.QQFriendAdapterCaseB", "[cpan] postion:%d qq:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        ao localao = (ao)f.this.getItem(paramAnonymousInt1);
        if (localao == null)
        {
          ab.e("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend is null. qq:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(108603);
          return;
        }
        ab.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", new Object[] { localao.toString() });
        if (localao.gyF == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(f.a(f.this), new f.1.1(this));
          paramAnonymousString.gAl = localao.gyE;
          paramAnonymousString.vST = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(12));
          if (bo.isNullOrNil(localao.getUsername()))
          {
            ab.w("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend username is null.");
            AppMethodBeat.o(108603);
            return;
          }
          paramAnonymousString.b(localao.getUsername(), localLinkedList, true);
          localao.fsi = 1;
          ((ap)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localao.gyE, localao);
          f.this.Ku();
        }
        AppMethodBeat.o(108603);
      }
    };
    this.cmc = paramMMActivity;
    this.TR = paramInt;
    this.gzQ = paramMMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
    qp(true);
    AppMethodBeat.o(108606);
  }
  
  private static String b(ao paramao)
  {
    AppMethodBeat.i(108611);
    if (paramao.fsh == 123)
    {
      AppMethodBeat.o(108611);
      return "#";
    }
    char c = (char)paramao.fsh;
    AppMethodBeat.o(108611);
    return String.valueOf(c);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(108609);
    bKb();
    if (bo.isNullOrNil(this.gvB)) {
      setCursor(((ap)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).E(this.TR, this.gzQ));
    }
    for (;;)
    {
      if ((this.gzI != null) && (this.gvB != null)) {
        this.gzI.mQ(getCursor().getCount());
      }
      notifyDataSetChanged();
      AppMethodBeat.o(108609);
      return;
      setCursor(((ap)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).c(this.TR, this.gvB, this.gzQ));
    }
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(108608);
    Ku();
    AppMethodBeat.o(108608);
  }
  
  public final void a(d.a parama)
  {
    this.gzI = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108610);
    ao localao = (ao)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.cmc, 2130969639, null);
      paramViewGroup = new f.b(this, paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.gvH = paramInt;
      paramViewGroup.account = localao.gyE;
      paramViewGroup.status = localao.gyF;
      paramViewGroup.gvQ.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.cmc, localao.getDisplayName(), paramViewGroup.gvQ.getTextSize()));
      paramViewGroup.gvR.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.cmc, localao.Hs(), paramViewGroup.gvR.getTextSize()));
      if (!this.gzQ) {
        break label363;
      }
      if (p.cU(paramViewGroup.account) == 0) {
        break label843;
      }
    }
    label181:
    label197:
    label843:
    for (Object localObject = b.gB(localao.gyE);; localObject = null)
    {
      int i;
      if (localObject == null)
      {
        paramViewGroup.ehv.setImageDrawable(com.tencent.mm.cb.a.k(this.cmc, 2131231207));
        if (!this.gzQ) {
          break label378;
        }
        paramViewGroup.gvJ.setVisibility(8);
        localObject = (ao)getItem(paramInt - 1);
        if (localObject != null) {
          break label676;
        }
        i = -1;
        label217:
        if (localObject == null) {
          break label686;
        }
        localObject = ((ao)localObject).toString();
        label229:
        ab.d("MicroMsg.QQFriendAdapterCaseB", "qq friend pre:%s", new Object[] { localObject });
        if (localao == null) {
          break label694;
        }
        localObject = localao.toString();
        ab.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", new Object[] { localObject });
        if (paramInt != 0) {
          break label733;
        }
        localObject = b(localao);
        if (!bo.isNullOrNil((String)localObject)) {
          break label702;
        }
        ab.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[] { localao.getUsername(), Integer.valueOf(paramInt) });
        paramViewGroup.gvP.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(108610);
        return paramView;
        paramViewGroup = (f.b)paramView.getTag();
        break;
        paramViewGroup.ehv.setImageBitmap((Bitmap)localObject);
        break label181;
        label363:
        a.b.c(paramViewGroup.ehv, localao.getUsername());
        break label181;
        label378:
        switch (localao.gyF)
        {
        }
        for (;;)
        {
          switch (localao.fsi)
          {
          default: 
            break;
          case 0: 
          case 2: 
            paramViewGroup.gpr.setVisibility(0);
            paramViewGroup.gvS.setVisibility(4);
            break;
            if ((((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arr(localao.getUsername())) || (r.Zn().equals(localao.getUsername())))
            {
              paramViewGroup.gvJ.setClickable(false);
              paramViewGroup.gvJ.setBackgroundDrawable(null);
              paramViewGroup.gpr.setText(2131300189);
              paramViewGroup.gpr.setTextColor(this.cmc.getResources().getColor(2131690211));
            }
            else if (localao.fsi == 2)
            {
              paramViewGroup.gvJ.setClickable(false);
              paramViewGroup.gvJ.setBackgroundDrawable(null);
              paramViewGroup.gpr.setText(2131300194);
              paramViewGroup.gpr.setTextColor(this.cmc.getResources().getColor(2131690211));
            }
            else
            {
              paramViewGroup.gvJ.setClickable(true);
              paramViewGroup.gvJ.setBackgroundResource(2130838045);
              paramViewGroup.gpr.setText(2131300188);
              paramViewGroup.gpr.setTextColor(this.cmc.getResources().getColor(2131690709));
            }
            break;
          }
        }
        paramViewGroup.gpr.setVisibility(4);
        paramViewGroup.gvS.setVisibility(0);
        break label197;
        i = ((ao)localObject).fsh;
        break label217;
        localObject = "";
        break label229;
        localObject = "";
        break label259;
        paramViewGroup.gvP.setVisibility(0);
        paramViewGroup.gvP.setText((CharSequence)localObject);
        paramViewGroup.gvP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        continue;
        label733:
        if (localao.fsh != i) {}
        for (i = 1;; i = 0)
        {
          localObject = b(localao);
          if ((!bo.isNullOrNil((String)localObject)) && (i != 0)) {
            break label812;
          }
          ab.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[] { localao.getUsername(), Integer.valueOf(paramInt) });
          paramViewGroup.gvP.setVisibility(8);
          break;
        }
        paramViewGroup.gvP.setVisibility(0);
        paramViewGroup.gvP.setText((CharSequence)localObject);
        paramViewGroup.gvP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
    }
  }
  
  public final void re(String paramString) {}
  
  public final void wQ(String paramString)
  {
    AppMethodBeat.i(108607);
    this.gvB = bo.wC(paramString.trim());
    bKb();
    Ku();
    AppMethodBeat.o(108607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.f
 * JD-Core Version:    0.7.0.1
 */