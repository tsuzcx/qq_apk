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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.f;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.model.ap;
import com.tencent.mm.plugin.account.friend.model.aq;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f
  extends d
{
  private final int kW;
  private final MMActivity lzt;
  private String pQS;
  private d.a pVj;
  boolean pVr;
  private a pVs;
  
  public f(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, new ap());
    AppMethodBeat.i(131267);
    this.pVr = false;
    this.pVs = new a()
    {
      public final void f(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131264);
        Log.d("MicroMsg.QQFriendAdapterCaseB", "[cpan] postion:%d qq:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        ap localap = (ap)f.this.getItem(paramAnonymousInt1);
        if (localap == null)
        {
          Log.e("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend is null. qq:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(131264);
          return;
        }
        Log.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", new Object[] { localap.toString() });
        if (localap.pTV == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(f.a(f.this), new com.tencent.mm.pluginsdk.ui.applet.a.a()
          {
            public final void canAddContact(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(131263);
              Log.i("MicroMsg.QQFriendAdapterCaseB", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              long l = new com.tencent.mm.b.p(com.tencent.mm.b.p.hw(paramAnonymous2String2)).longValue();
              ap localap = ((aq)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).jt(l);
              if ((paramAnonymous2Boolean1) && (localap != null)) {
                localap.username = paramAnonymous2String1;
              }
              if (localap != null)
              {
                localap.osD = 2;
                Log.d("MicroMsg.QQFriendAdapterCaseB", "f :%s", new Object[] { localap.toString() });
                ((aq)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).a(l, localap);
                f.this.aNy();
              }
              for (;;)
              {
                if ((paramAnonymous2Boolean1) && (localap != null)) {
                  f.Tj(paramAnonymous2String1);
                }
                AppMethodBeat.o(131263);
                return;
                Log.w("MicroMsg.QQFriendAdapterCaseB", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
            }
          });
          paramAnonymousString.pVP = localap.pTU;
          paramAnonymousString.hks = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(12));
          if (Util.isNullOrNil(localap.getUsername()))
          {
            Log.w("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend username is null.");
            AppMethodBeat.o(131264);
            return;
          }
          paramAnonymousString.b(localap.getUsername(), localLinkedList, true);
          localap.osD = 1;
          ((aq)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).a(localap.pTU, localap);
          f.this.aNy();
        }
        AppMethodBeat.o(131264);
      }
    };
    this.lzt = paramMMActivity;
    this.kW = paramInt;
    this.pVr = paramMMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
    Lh(true);
    AppMethodBeat.o(131267);
  }
  
  private static String b(ap paramap)
  {
    AppMethodBeat.i(131272);
    if (paramap.osC == 123)
    {
      AppMethodBeat.o(131272);
      return "#";
    }
    char c = (char)paramap.osC;
    AppMethodBeat.o(131272);
    return String.valueOf(c);
  }
  
  public final void LM(String paramString) {}
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(131268);
    this.pQS = Util.escapeSqlValue(paramString.trim());
    fSd();
    aNy();
    AppMethodBeat.o(131268);
  }
  
  public final void a(d.a parama)
  {
    this.pVj = parama;
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(131270);
    fSd();
    if (Util.isNullOrNil(this.pQS)) {
      w(((aq)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).aa(this.kW, this.pVr));
    }
    for (;;)
    {
      if ((this.pVj != null) && (this.pQS != null)) {
        this.pVj.yo(Fv().getCount());
      }
      notifyDataSetChanged();
      AppMethodBeat.o(131270);
      return;
      w(((aq)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).b(this.kW, this.pQS, this.pVr));
    }
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(131269);
    aNy();
    AppMethodBeat.o(131269);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131271);
    ap localap = (ap)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.lzt, a.d.friend_list_item, null);
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.pQY = paramInt;
      paramViewGroup.account = localap.pTU;
      paramViewGroup.status = localap.pTV;
      paramViewGroup.pRg.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.lzt, localap.getDisplayName(), paramViewGroup.pRg.getTextSize()));
      paramViewGroup.pRh.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.lzt, localap.getNickname(), paramViewGroup.pRh.getTextSize()));
      if (!this.pVr) {
        break label365;
      }
      if (com.tencent.mm.b.p.hw(paramViewGroup.account) == 0) {
        break label847;
      }
    }
    label183:
    label199:
    label847:
    for (Object localObject = com.tencent.mm.modelavatar.d.iy(localap.pTU);; localObject = null)
    {
      int i;
      if (localObject == null)
      {
        paramViewGroup.lKK.setImageDrawable(com.tencent.mm.cd.a.m(this.lzt, a.f.default_avatar));
        if (!this.pVr) {
          break label380;
        }
        paramViewGroup.pRa.setVisibility(8);
        localObject = (ap)getItem(paramInt - 1);
        if (localObject != null) {
          break label680;
        }
        i = -1;
        label219:
        if (localObject == null) {
          break label690;
        }
        localObject = ((ap)localObject).toString();
        label231:
        Log.d("MicroMsg.QQFriendAdapterCaseB", "qq friend pre:%s", new Object[] { localObject });
        if (localap == null) {
          break label698;
        }
        localObject = localap.toString();
        Log.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", new Object[] { localObject });
        if (paramInt != 0) {
          break label737;
        }
        localObject = b(localap);
        if (!Util.isNullOrNil((String)localObject)) {
          break label706;
        }
        Log.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[] { localap.getUsername(), Integer.valueOf(paramInt) });
        paramViewGroup.pRf.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(131271);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        paramViewGroup.lKK.setImageBitmap((Bitmap)localObject);
        break label183;
        label365:
        com.tencent.mm.pluginsdk.ui.a.b.g(paramViewGroup.lKK, localap.getUsername());
        break label183;
        label380:
        switch (localap.pTV)
        {
        }
        for (;;)
        {
          switch (localap.osD)
          {
          default: 
            break;
          case 0: 
          case 2: 
            paramViewGroup.lPf.setVisibility(0);
            paramViewGroup.pRi.setVisibility(4);
            break;
            if ((((n)h.ax(n.class)).bzA().bxr(localap.getUsername())) || (z.bAM().equals(localap.getUsername())))
            {
              paramViewGroup.pRa.setClickable(false);
              paramViewGroup.pRa.setBackgroundDrawable(null);
              paramViewGroup.lPf.setText(a.g.friend_added);
              paramViewGroup.lPf.setTextColor(this.lzt.getResources().getColor(com.tencent.mm.plugin.account.friend.a.a.lightgrey));
            }
            else if (localap.osD == 2)
            {
              paramViewGroup.pRa.setClickable(false);
              paramViewGroup.pRa.setBackgroundDrawable(null);
              paramViewGroup.lPf.setText(a.g.friend_waiting_ask);
              paramViewGroup.lPf.setTextColor(this.lzt.getResources().getColor(com.tencent.mm.plugin.account.friend.a.a.lightgrey));
            }
            else
            {
              paramViewGroup.pRa.setClickable(true);
              paramViewGroup.pRa.setBackgroundResource(com.tencent.mm.plugin.account.friend.a.b.btn_solid_green);
              paramViewGroup.lPf.setText(a.g.friend_add);
              paramViewGroup.lPf.setTextColor(this.lzt.getResources().getColor(com.tencent.mm.plugin.account.friend.a.a.white_text_color));
            }
            break;
          }
        }
        paramViewGroup.lPf.setVisibility(4);
        paramViewGroup.pRi.setVisibility(0);
        break label199;
        i = ((ap)localObject).osC;
        break label219;
        localObject = "";
        break label231;
        localObject = "";
        break label261;
        paramViewGroup.pRf.setVisibility(0);
        paramViewGroup.pRf.setText((CharSequence)localObject);
        paramViewGroup.pRf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        continue;
        label737:
        if (localap.osC != i) {}
        for (i = 1;; i = 0)
        {
          localObject = b(localap);
          if ((!Util.isNullOrNil((String)localObject)) && (i != 0)) {
            break label816;
          }
          Log.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[] { localap.getUsername(), Integer.valueOf(paramInt) });
          paramViewGroup.pRf.setVisibility(8);
          break;
        }
        paramViewGroup.pRf.setVisibility(0);
        paramViewGroup.pRf.setText((CharSequence)localObject);
        paramViewGroup.pRf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void f(int paramInt1, String paramString, int paramInt2);
  }
  
  final class b
  {
    String account;
    ImageView lKK;
    TextView lPf;
    int pQY;
    View pRa;
    TextView pRf;
    TextView pRg;
    TextView pRh;
    ProgressBar pRi;
    int status;
    
    public b(View paramView)
    {
      AppMethodBeat.i(131266);
      this.pRf = ((TextView)paramView.findViewById(a.c.friend_item_catalog));
      this.lKK = ((ImageView)paramView.findViewById(a.c.friend_item_avatar_iv));
      this.pRg = ((TextView)paramView.findViewById(a.c.friend_item_nickname));
      this.pRh = ((TextView)paramView.findViewById(a.c.friend_item_wx_nickname));
      this.pRa = paramView.findViewById(a.c.friend_item_action_view);
      this.lPf = ((TextView)paramView.findViewById(a.c.friend_item_status_tv));
      this.pRi = ((ProgressBar)paramView.findViewById(a.c.friend_item_status_pb));
      this.pRa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131265);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (f.b(f.this) != null) {
            f.b(f.this).f(f.b.this.pQY, f.b.this.account, f.b.this.status);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(131265);
        }
      });
      AppMethodBeat.o(131266);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.f
 * JD-Core Version:    0.7.0.1
 */