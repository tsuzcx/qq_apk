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
import com.tencent.mm.g.b.a.in;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.account.friend.a.au.a;
import com.tencent.mm.plugin.account.friend.a.r;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.e.c;
import java.util.LinkedList;

public class RecoverFriendSortView
  extends BaseSortView
{
  public String iLW;
  
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
          locala.fxQ = ((ImageView)paramAnonymousView.findViewById(2131300290));
          locala.iNX = ((TextView)paramAnonymousView.findViewById(2131300300));
          locala.iIT = ((TextView)paramAnonymousView.findViewById(2131297925));
          locala.iNY = ((TextView)paramAnonymousView.findViewById(2131300299));
          locala.iKx = ((TextView)paramAnonymousView.findViewById(2131296465));
          locala.iNZ = ((Button)paramAnonymousView.findViewById(2131296456));
          locala1 = (au.a)paramAnonymousd.data;
          locala.iOa = locala1;
          com.tencent.mm.pluginsdk.ui.a.b.c(locala.fxQ, locala1.iLT.field_encryptUsername);
          locala.iNX.setText(com.tencent.mm.pluginsdk.ui.span.k.c(paramAnonymousView.getContext(), locala1.iLT.field_nickname));
          if ((locala1.iLU == null) || (bs.isNullOrNil(locala1.iLU.field_msgContent))) {
            break label375;
          }
          locala.iNY.setVisibility(0);
          locala.iNX.setText(com.tencent.mm.pluginsdk.ui.span.k.c(paramAnonymousView.getContext(), locala1.iLU.field_msgContent));
          label229:
          if ((!RecoverFriendSortView.this.HGk) || (!paramAnonymousBoolean1)) {
            break label388;
          }
          locala.iIT.setText(paramAnonymousd.HGs);
          locala.iIT.setVisibility(0);
          label265:
          if (((bs.isNullOrNil(locala1.iLT.field_encryptUsername)) || (!w.wG(locala1.iLT.field_encryptUsername))) && ((bs.isNullOrNil(locala1.iLT.field_username)) || (!w.wG(locala1.iLT.field_username)))) {
            break label401;
          }
          locala.iKx.setVisibility(0);
          locala.iKx.setText(2131755275);
          locala.iNZ.setVisibility(8);
        }
        for (;;)
        {
          paramAnonymousView.setTag(locala);
          AppMethodBeat.o(184460);
          return paramAnonymousView;
          locala = (RecoverFriendSortView.a)paramAnonymousView.getTag();
          break;
          label375:
          locala.iNY.setVisibility(8);
          break label229;
          label388:
          locala.iIT.setVisibility(8);
          break label265;
          label401:
          if (locala1.iLT.field_addState == 1)
          {
            locala.iKx.setVisibility(0);
            locala.iKx.setText(2131759667);
            locala.iNZ.setVisibility(8);
          }
          else
          {
            locala.iKx.setVisibility(8);
            locala.iNZ.setVisibility(0);
            locala.iNZ.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymous2View)
              {
                AppMethodBeat.i(184459);
                paramAnonymous2View = new in();
                paramAnonymous2View.dHA = 4;
                paramAnonymous2View.pF(u.axz());
                paramAnonymous2View.pE(RecoverFriendSortView.this.iLW);
                paramAnonymous2View.pG(locala.iOa.iLT.field_encryptUsername);
                paramAnonymous2View.aHZ();
                paramAnonymous2View = new a(RecoverFriendSortView.this.getContext(), new a.a()
                {
                  public final void a(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2, String paramAnonymous3String1, String paramAnonymous3String2)
                  {
                    AppMethodBeat.i(184457);
                    ac.i("MicroMsg.RecoverFriendSortView", "canAddContact %s,%s", new Object[] { paramAnonymous3String1, Boolean.valueOf(paramAnonymous3Boolean1) });
                    if (paramAnonymous3Boolean1)
                    {
                      paramAnonymous3String2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(RecoverFriendSortView.1.1.this.iNU.iOa.iLT.field_encryptUsername);
                      if ((int)paramAnonymous3String2.fLJ != 0) {
                        break label300;
                      }
                      if (!bs.isNullOrNil(paramAnonymous3String1))
                      {
                        paramAnonymous3String2.setUsername(paramAnonymous3String1);
                        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().ag(paramAnonymous3String2);
                      }
                    }
                    label300:
                    for (paramAnonymous3String1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramAnonymous3String2.field_username);; paramAnonymous3String1 = paramAnonymous3String2)
                    {
                      if ((int)paramAnonymous3String1.fLJ <= 0)
                      {
                        ac.e("MicroMsg.RecoverFriendSortView", "addContact : insert contact failed");
                        AppMethodBeat.o(184457);
                        return;
                        paramAnonymous3String2.setUsername(RecoverFriendSortView.1.1.this.iNU.iOa.iLT.field_encryptUsername);
                        break;
                      }
                      w.u(paramAnonymous3String1);
                      h.cg(RecoverFriendSortView.this.getContext(), RecoverFriendSortView.this.getContext().getString(2131755275));
                      au.aB(RecoverFriendSortView.1.1.this.iNU.iOa.iLT.field_encryptUsername, 0);
                      RecoverFriendSortView.this.refresh();
                      AppMethodBeat.o(184457);
                      return;
                      if (paramAnonymous3Boolean2)
                      {
                        au.aB(RecoverFriendSortView.1.1.this.iNU.iOa.iLT.field_encryptUsername, 1);
                        RecoverFriendSortView.this.refresh();
                      }
                      AppMethodBeat.o(184457);
                      return;
                    }
                  }
                });
                paramAnonymous2View.aHb(locala.iOa.iLT.field_ticket);
                LinkedList localLinkedList = new LinkedList();
                localLinkedList.add(Integer.valueOf(17));
                paramAnonymous2View.DpJ = new com.tencent.mm.pluginsdk.ui.applet.a.b()
                {
                  public final boolean ax(String paramAnonymous3String, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(184458);
                    Intent localIntent = new Intent();
                    localIntent.putExtra("Contact_User", RecoverFriendSortView.1.1.this.iNU.iOa.iLT.field_encryptUsername);
                    localIntent.putExtra("Contact_Nick", RecoverFriendSortView.1.1.this.iNU.iOa.iLT.field_nickname);
                    localIntent.putExtra("Contact_Scene", 17);
                    localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
                    localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
                    localIntent.putExtra("sayhi_with_sns_perm_set_label", false);
                    localIntent.putExtra(e.c.HgZ, RecoverFriendSortView.1.1.this.iNU.iOa.iLT.field_ticket);
                    localIntent.putExtra("sayhi_verify_add_errcode", paramAnonymous3Int);
                    paramAnonymous3Int = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbC, 0);
                    paramAnonymous3String = ".ui.SayHiWithSnsPermissionUI";
                    if (paramAnonymous3Int == 1) {
                      paramAnonymous3String = ".ui.SayHiWithSnsPermissionUI2";
                    }
                    for (;;)
                    {
                      com.tencent.mm.br.d.b(RecoverFriendSortView.this.getContext(), "profile", paramAnonymous3String, localIntent);
                      AppMethodBeat.o(184458);
                      return true;
                      if (paramAnonymous3Int == 2) {
                        paramAnonymous3String = ".ui.SayHiWithSnsPermissionUI3";
                      }
                    }
                  }
                };
                paramAnonymous2View.i(locala.iOa.iLT.field_encryptUsername, localLinkedList);
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
    ImageView fxQ;
    TextView iIT;
    TextView iKx;
    TextView iNX;
    TextView iNY;
    Button iNZ;
    au.a iOa;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView
 * JD-Core Version:    0.7.0.1
 */