package com.tencent.mm.plugin.account.friend.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.b.a.ju;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.account.friend.a.au.a;
import com.tencent.mm.plugin.account.friend.a.r;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.e.c;
import java.util.LinkedList;

public class RecoverFriendSortView
  extends BaseSortView
{
  public String jhY;
  
  public RecoverFriendSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
  {
    return false;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(184465);
    c.a local1 = new c.a()
    {
      public final View a(com.tencent.mm.ui.base.sortview.d paramAnonymousd, View paramAnonymousView, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(184460);
        final RecoverFriendSortView.a locala;
        au.a locala1;
        if (paramAnonymousView == null)
        {
          paramAnonymousView = View.inflate(RecoverFriendSortView.this.getContext(), 2131495227, null);
          locala = new RecoverFriendSortView.a(RecoverFriendSortView.this);
          locala.fTj = ((ImageView)paramAnonymousView.findViewById(2131300290));
          locala.jjZ = ((TextView)paramAnonymousView.findViewById(2131300300));
          locala.jeV = ((TextView)paramAnonymousView.findViewById(2131297925));
          locala.jka = ((TextView)paramAnonymousView.findViewById(2131300299));
          locala.jgz = ((TextView)paramAnonymousView.findViewById(2131296465));
          locala.jkb = ((Button)paramAnonymousView.findViewById(2131296456));
          locala1 = (au.a)paramAnonymousd.data;
          locala.jkc = locala1;
          com.tencent.mm.pluginsdk.ui.a.b.c(locala.fTj, locala1.jhV.field_encryptUsername);
          locala.jjZ.setText(k.c(paramAnonymousView.getContext(), locala1.jhV.field_nickname));
          if ((locala1.jhW == null) || (bu.isNullOrNil(locala1.jhW.field_msgContent))) {
            break label375;
          }
          locala.jka.setVisibility(0);
          locala.jjZ.setText(k.c(paramAnonymousView.getContext(), locala1.jhW.field_msgContent));
          label229:
          if ((!RecoverFriendSortView.this.JOQ) || (!paramAnonymousBoolean1)) {
            break label388;
          }
          locala.jeV.setText(paramAnonymousd.JOY);
          locala.jeV.setVisibility(0);
          label265:
          if (((bu.isNullOrNil(locala1.jhV.field_encryptUsername)) || (!x.An(locala1.jhV.field_encryptUsername))) && ((bu.isNullOrNil(locala1.jhV.field_username)) || (!x.An(locala1.jhV.field_username)))) {
            break label401;
          }
          locala.jgz.setVisibility(0);
          locala.jgz.setText(2131755275);
          locala.jkb.setVisibility(8);
        }
        for (;;)
        {
          paramAnonymousView.setTag(locala);
          AppMethodBeat.o(184460);
          return paramAnonymousView;
          locala = (RecoverFriendSortView.a)paramAnonymousView.getTag();
          break;
          label375:
          locala.jka.setVisibility(8);
          break label229;
          label388:
          locala.jeV.setVisibility(8);
          break label265;
          label401:
          if (locala1.jhV.field_addState == 1)
          {
            locala.jgz.setVisibility(0);
            locala.jgz.setText(2131759667);
            locala.jkb.setVisibility(8);
          }
          else
          {
            locala.jgz.setVisibility(8);
            locala.jkb.setVisibility(0);
            locala.jkb.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymous2View)
              {
                AppMethodBeat.i(184459);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymous2View);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/widget/RecoverFriendSortView$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
                paramAnonymous2View = new ju();
                paramAnonymous2View.dVT = 4;
                paramAnonymous2View.sG(v.aAF());
                paramAnonymous2View.sF(RecoverFriendSortView.this.jhY);
                paramAnonymous2View.sH(locala.jkc.jhV.field_encryptUsername);
                paramAnonymous2View.aLH();
                paramAnonymous2View = new com.tencent.mm.pluginsdk.ui.applet.a(RecoverFriendSortView.this.getContext(), new a.a()
                {
                  public final void a(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2, String paramAnonymous3String1, String paramAnonymous3String2)
                  {
                    AppMethodBeat.i(184457);
                    ae.i("MicroMsg.RecoverFriendSortView", "canAddContact %s,%s", new Object[] { paramAnonymous3String1, Boolean.valueOf(paramAnonymous3Boolean1) });
                    if (paramAnonymous3Boolean1)
                    {
                      paramAnonymous3String2 = ((l)g.ab(l.class)).azF().BH(RecoverFriendSortView.1.1.this.jjW.jkc.jhV.field_encryptUsername);
                      if ((int)paramAnonymous3String2.ght != 0) {
                        break label300;
                      }
                      if (!bu.isNullOrNil(paramAnonymous3String1))
                      {
                        paramAnonymous3String2.setUsername(paramAnonymous3String1);
                        ((l)g.ab(l.class)).azF().an(paramAnonymous3String2);
                      }
                    }
                    label300:
                    for (paramAnonymous3String1 = ((l)g.ab(l.class)).azF().BH(paramAnonymous3String2.field_username);; paramAnonymous3String1 = paramAnonymous3String2)
                    {
                      if ((int)paramAnonymous3String1.ght <= 0)
                      {
                        ae.e("MicroMsg.RecoverFriendSortView", "addContact : insert contact failed");
                        AppMethodBeat.o(184457);
                        return;
                        paramAnonymous3String2.setUsername(RecoverFriendSortView.1.1.this.jjW.jkc.jhV.field_encryptUsername);
                        break;
                      }
                      x.B(paramAnonymous3String1);
                      h.cm(RecoverFriendSortView.this.getContext(), RecoverFriendSortView.this.getContext().getString(2131755275));
                      au.aE(RecoverFriendSortView.1.1.this.jjW.jkc.jhV.field_encryptUsername, 0);
                      RecoverFriendSortView.this.refresh();
                      AppMethodBeat.o(184457);
                      return;
                      if (paramAnonymous3Boolean2)
                      {
                        au.aE(RecoverFriendSortView.1.1.this.jjW.jkc.jhV.field_encryptUsername, 1);
                        RecoverFriendSortView.this.refresh();
                      }
                      AppMethodBeat.o(184457);
                      return;
                    }
                  }
                });
                paramAnonymous2View.aOa(locala.jkc.jhV.field_ticket);
                localObject = new LinkedList();
                ((LinkedList)localObject).add(Integer.valueOf(17));
                paramAnonymous2View.Fni = new com.tencent.mm.pluginsdk.ui.applet.a.b()
                {
                  public final boolean aA(String paramAnonymous3String, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(184458);
                    Intent localIntent = new Intent();
                    localIntent.putExtra("Contact_User", RecoverFriendSortView.1.1.this.jjW.jkc.jhV.field_encryptUsername);
                    localIntent.putExtra("Contact_Nick", RecoverFriendSortView.1.1.this.jjW.jkc.jhV.field_nickname);
                    localIntent.putExtra("Contact_Scene", 17);
                    localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
                    localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
                    localIntent.putExtra("sayhi_with_sns_perm_set_label", false);
                    localIntent.putExtra(e.c.JoX, RecoverFriendSortView.1.1.this.jjW.jkc.jhV.field_ticket);
                    localIntent.putExtra("sayhi_verify_add_errcode", paramAnonymous3Int);
                    paramAnonymous3Int = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOK, 0);
                    String str = ".ui.SayHiWithSnsPermissionUI";
                    if ((!an.aUq(RecoverFriendSortView.1.1.this.jjW.jkc.jhV.field_encryptUsername)) && (paramAnonymous3Int == 1)) {
                      paramAnonymous3String = ".ui.SayHiWithSnsPermissionUI2";
                    }
                    for (;;)
                    {
                      com.tencent.mm.br.d.b(RecoverFriendSortView.this.getContext(), "profile", paramAnonymous3String, localIntent);
                      AppMethodBeat.o(184458);
                      return true;
                      paramAnonymous3String = str;
                      if (!an.aUq(RecoverFriendSortView.1.1.this.jjW.jkc.jhV.field_encryptUsername))
                      {
                        paramAnonymous3String = str;
                        if (paramAnonymous3Int == 2) {
                          paramAnonymous3String = ".ui.SayHiWithSnsPermissionUI3";
                        }
                      }
                    }
                  }
                };
                paramAnonymous2View.h(locala.jkc.jhV.field_encryptUsername, (LinkedList)localObject);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/widget/RecoverFriendSortView$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(184459);
              }
            });
          }
        }
      }
    };
    AppMethodBeat.o(184465);
    return local1;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(184463);
    ListView localListView = (ListView)findViewById(2131301452);
    AppMethodBeat.o(184463);
    return localListView;
  }
  
  public View getNoResultView()
  {
    AppMethodBeat.i(184464);
    View localView = findViewById(2131302883);
    AppMethodBeat.o(184464);
    return localView;
  }
  
  public VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(184462);
    VerticalScrollBar localVerticalScrollBar = (VerticalScrollBar)findViewById(2131305114);
    AppMethodBeat.o(184462);
    return localVerticalScrollBar;
  }
  
  public final View inflate()
  {
    AppMethodBeat.i(184461);
    View localView = View.inflate(getContext(), 2131495229, this);
    AppMethodBeat.o(184461);
    return localView;
  }
  
  final class a
  {
    ImageView fTj;
    TextView jeV;
    TextView jgz;
    TextView jjZ;
    TextView jka;
    Button jkb;
    au.a jkc;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView
 * JD-Core Version:    0.7.0.1
 */