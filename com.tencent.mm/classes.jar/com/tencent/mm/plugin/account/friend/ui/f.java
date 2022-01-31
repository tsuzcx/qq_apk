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
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.e;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f
  extends d
{
  private final int Th;
  private final MMActivity bER;
  private String fdR;
  private d.a fib;
  boolean fij = false;
  private f.a fik = new f.a()
  {
    public final void d(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
    {
      y.d("MicroMsg.QQFriendAdapterCaseB", "[cpan] postion:%d qq:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
      ao localao = (ao)f.this.getItem(paramAnonymousInt1);
      if (localao == null) {
        y.e("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend is null. qq:%s", new Object[] { paramAnonymousString });
      }
      do
      {
        return;
        y.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", new Object[] { localao.toString() });
      } while (localao.fgX != 1);
      paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(f.a(f.this), new f.1.1(this));
      paramAnonymousString.fiE = localao.fgW;
      paramAnonymousString.sbN = false;
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(12));
      if (bk.bl(localao.getUsername()))
      {
        y.w("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend username is null.");
        return;
      }
      paramAnonymousString.b(localao.getUsername(), localLinkedList, true);
      localao.ebQ = 1;
      ((ap)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(localao.fgW, localao);
      f.this.yc();
    }
  };
  
  public f(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, new ao());
    this.bER = paramMMActivity;
    this.Th = paramInt;
    this.fij = paramMMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
    mR(true);
  }
  
  private static String b(ao paramao)
  {
    if (paramao.ebP == 123) {
      return "#";
    }
    return String.valueOf((char)paramao.ebP);
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
      paramView = View.inflate(this.bER, a.e.friend_list_item, null);
      paramViewGroup = new f.b(this, paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.fdX = paramInt;
      paramViewGroup.account = localao.fgW;
      paramViewGroup.status = localao.fgX;
      paramViewGroup.feh.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.bER, localao.getDisplayName(), paramViewGroup.feh.getTextSize()));
      paramViewGroup.fei.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.bER, localao.vm(), paramViewGroup.fei.getTextSize()));
      if (!this.fij) {
        break label349;
      }
      if (o.bS(paramViewGroup.account) == 0) {
        break label826;
      }
    }
    label178:
    label690:
    label826:
    for (Object localObject = b.bG(localao.fgW);; localObject = null)
    {
      if (localObject == null)
      {
        paramViewGroup.dpY.setImageDrawable(com.tencent.mm.cb.a.g(this.bER, a.g.default_avatar));
        if (!this.fij) {
          break label364;
        }
        paramViewGroup.fdZ.setVisibility(8);
        label194:
        localObject = (ao)getItem(paramInt - 1);
        if (localObject != null) {
          break label664;
        }
        i = -1;
        label214:
        if (localObject == null) {
          break label674;
        }
        localObject = ((ao)localObject).toString();
        label226:
        y.d("MicroMsg.QQFriendAdapterCaseB", "qq friend pre:%s", new Object[] { localObject });
        if (localao == null) {
          break label682;
        }
      }
      for (localObject = localao.toString();; localObject = "")
      {
        y.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", new Object[] { localObject });
        if (paramInt != 0) {
          break label720;
        }
        localObject = b(localao);
        if (!bk.bl((String)localObject)) {
          break label690;
        }
        y.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[] { localao.getUsername(), Integer.valueOf(paramInt) });
        paramViewGroup.feg.setVisibility(8);
        return paramView;
        paramViewGroup = (f.b)paramView.getTag();
        break;
        paramViewGroup.dpY.setImageBitmap((Bitmap)localObject);
        break label178;
        label349:
        com.tencent.mm.pluginsdk.ui.a.b.a(paramViewGroup.dpY, localao.getUsername());
        break label178;
        label364:
        switch (localao.fgX)
        {
        }
        for (;;)
        {
          switch (localao.ebQ)
          {
          default: 
            break;
          case 0: 
          case 2: 
            paramViewGroup.eXu.setVisibility(0);
            paramViewGroup.fej.setVisibility(4);
            break;
            if ((((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abg(localao.getUsername())) || (q.Gj().equals(localao.getUsername())))
            {
              paramViewGroup.fdZ.setClickable(false);
              paramViewGroup.fdZ.setBackgroundDrawable(null);
              paramViewGroup.eXu.setText(a.h.friend_added);
              paramViewGroup.eXu.setTextColor(this.bER.getResources().getColor(com.tencent.mm.plugin.account.friend.a.b.lightgrey));
            }
            else if (localao.ebQ == 2)
            {
              paramViewGroup.fdZ.setClickable(false);
              paramViewGroup.fdZ.setBackgroundDrawable(null);
              paramViewGroup.eXu.setText(a.h.friend_waiting_ask);
              paramViewGroup.eXu.setTextColor(this.bER.getResources().getColor(com.tencent.mm.plugin.account.friend.a.b.lightgrey));
            }
            else
            {
              paramViewGroup.fdZ.setClickable(true);
              paramViewGroup.fdZ.setBackgroundResource(a.c.btn_solid_green);
              paramViewGroup.eXu.setText(a.h.friend_add);
              paramViewGroup.eXu.setTextColor(this.bER.getResources().getColor(com.tencent.mm.plugin.account.friend.a.b.white));
            }
            break;
          }
        }
        paramViewGroup.eXu.setVisibility(4);
        paramViewGroup.fej.setVisibility(0);
        break label194;
        i = ((ao)localObject).ebP;
        break label214;
        localObject = "";
        break label226;
      }
      paramViewGroup.feg.setVisibility(0);
      paramViewGroup.feg.setText((CharSequence)localObject);
      paramViewGroup.feg.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return paramView;
      label720:
      if (localao.ebP != i) {}
      for (int i = 1;; i = 0)
      {
        localObject = b(localao);
        if ((!bk.bl((String)localObject)) && (i != 0)) {
          break;
        }
        y.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[] { localao.getUsername(), Integer.valueOf(paramInt) });
        paramViewGroup.feg.setVisibility(8);
        return paramView;
      }
      paramViewGroup.feg.setVisibility(0);
      paramViewGroup.feg.setText((CharSequence)localObject);
      paramViewGroup.feg.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return paramView;
    }
  }
  
  public final void kk(String paramString) {}
  
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
      setCursor(((ap)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).A(this.Th, this.fij));
    }
    for (;;)
    {
      if ((this.fib != null) && (this.fdR != null)) {
        this.fib.jU(getCursor().getCount());
      }
      notifyDataSetChanged();
      return;
      setCursor(((ap)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).c(this.Th, this.fdR, this.fij));
    }
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.f
 * JD-Core Version:    0.7.0.1
 */