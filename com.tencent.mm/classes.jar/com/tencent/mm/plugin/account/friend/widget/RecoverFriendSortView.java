package com.tencent.mm.plugin.account.friend.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.uo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.model.ar;
import com.tencent.mm.plugin.account.friend.model.ar.a;
import com.tencent.mm.plugin.account.friend.model.o;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.f.e;
import java.util.LinkedList;

public class RecoverFriendSortView
  extends BaseSortView
{
  public String pUi;
  
  public RecoverFriendSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
  {
    return false;
  }
  
  public final View fF()
  {
    AppMethodBeat.i(184461);
    View localView = View.inflate(getContext(), a.d.recover_friend_sort_view, this);
    AppMethodBeat.o(184461);
    return localView;
  }
  
  public com.tencent.mm.ui.base.sortview.c.a getItemViewCreator()
  {
    AppMethodBeat.i(184465);
    com.tencent.mm.ui.base.sortview.c.a local1 = new com.tencent.mm.ui.base.sortview.c.a()
    {
      public final View createView(com.tencent.mm.ui.base.sortview.d paramAnonymousd, View paramAnonymousView, final ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(304822);
        ar.a locala;
        if (paramAnonymousView == null)
        {
          paramAnonymousView = View.inflate(RecoverFriendSortView.this.getContext(), a.d.recover_friend_item, null);
          paramAnonymousViewGroup = new RecoverFriendSortView.a(RecoverFriendSortView.this);
          paramAnonymousViewGroup.lKK = ((ImageView)paramAnonymousView.findViewById(a.c.friend_avatar));
          paramAnonymousViewGroup.pWj = ((TextView)paramAnonymousView.findViewById(a.c.friend_nickname));
          paramAnonymousViewGroup.pRf = ((TextView)paramAnonymousView.findViewById(a.c.catalogTV));
          paramAnonymousViewGroup.pWk = ((TextView)paramAnonymousView.findViewById(a.c.friend_last_msg));
          paramAnonymousViewGroup.pSI = ((TextView)paramAnonymousView.findViewById(a.c.add_state_tv));
          paramAnonymousViewGroup.pWl = ((Button)paramAnonymousView.findViewById(a.c.add_btn));
          locala = (ar.a)paramAnonymousd.cpt;
          paramAnonymousViewGroup.pWm = locala;
          com.tencent.mm.pluginsdk.ui.a.b.g(paramAnonymousViewGroup.lKK, locala.pUf.field_encryptUsername);
          paramAnonymousViewGroup.pWj.setText(p.b(paramAnonymousView.getContext(), locala.pUf.field_nickname));
          if ((locala.pUg == null) || (Util.isNullOrNil(locala.pUg.field_msgContent))) {
            break label364;
          }
          paramAnonymousViewGroup.pWk.setVisibility(0);
          paramAnonymousViewGroup.pWj.setText(p.b(paramAnonymousView.getContext(), locala.pUg.field_msgContent));
          label224:
          if ((!RecoverFriendSortView.this.aeaD) || (!paramAnonymousBoolean1)) {
            break label376;
          }
          paramAnonymousViewGroup.pRf.setText(paramAnonymousd.aeaK);
          paramAnonymousViewGroup.pRf.setVisibility(0);
          label258:
          if (((Util.isNullOrNil(locala.pUf.field_encryptUsername)) || (!ab.IR(locala.pUf.field_encryptUsername))) && ((Util.isNullOrNil(locala.pUf.field_username)) || (!ab.IR(locala.pUf.field_username)))) {
            break label388;
          }
          paramAnonymousViewGroup.pSI.setVisibility(0);
          paramAnonymousViewGroup.pSI.setText(a.g.app_added);
          paramAnonymousViewGroup.pWl.setVisibility(8);
        }
        for (;;)
        {
          paramAnonymousView.setTag(paramAnonymousViewGroup);
          AppMethodBeat.o(304822);
          return paramAnonymousView;
          paramAnonymousViewGroup = (RecoverFriendSortView.a)paramAnonymousView.getTag();
          break;
          label364:
          paramAnonymousViewGroup.pWk.setVisibility(8);
          break label224;
          label376:
          paramAnonymousViewGroup.pRf.setVisibility(8);
          break label258;
          label388:
          if (locala.pUf.field_addState == 1)
          {
            paramAnonymousViewGroup.pSI.setVisibility(0);
            paramAnonymousViewGroup.pSI.setText(a.g.friend_waiting_ask);
            paramAnonymousViewGroup.pWl.setVisibility(8);
          }
          else
          {
            paramAnonymousViewGroup.pSI.setVisibility(8);
            paramAnonymousViewGroup.pWl.setVisibility(0);
            paramAnonymousViewGroup.pWl.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymous2View)
              {
                AppMethodBeat.i(184459);
                Object localObject = new b();
                ((b)localObject).cH(paramAnonymous2View);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/widget/RecoverFriendSortView$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
                paramAnonymous2View = new uo();
                paramAnonymous2View.ipB = 4;
                paramAnonymous2View.As(z.bAP());
                paramAnonymous2View.Ar(RecoverFriendSortView.this.pUi);
                paramAnonymous2View.At(paramAnonymousViewGroup.pWm.pUf.field_encryptUsername);
                paramAnonymous2View.bMH();
                paramAnonymous2View = new com.tencent.mm.pluginsdk.ui.applet.a(RecoverFriendSortView.this.getContext(), new a.a()
                {
                  public final void canAddContact(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2, String paramAnonymous3String1, String paramAnonymous3String2)
                  {
                    AppMethodBeat.i(184457);
                    Log.i("MicroMsg.RecoverFriendSortView", "canAddContact %s,%s", new Object[] { paramAnonymous3String1, Boolean.valueOf(paramAnonymous3Boolean1) });
                    if (paramAnonymous3Boolean1)
                    {
                      paramAnonymous3String2 = ((n)h.ax(n.class)).bzA().JE(RecoverFriendSortView.1.1.this.pWg.pWm.pUf.field_encryptUsername);
                      if ((int)paramAnonymous3String2.maN != 0) {
                        break label301;
                      }
                      if (!Util.isNullOrNil(paramAnonymous3String1))
                      {
                        paramAnonymous3String2.setUsername(paramAnonymous3String1);
                        ((n)h.ax(n.class)).bzA().aB(paramAnonymous3String2);
                      }
                    }
                    label301:
                    for (paramAnonymous3String1 = ((n)h.ax(n.class)).bzA().JE(paramAnonymous3String2.field_username);; paramAnonymous3String1 = paramAnonymous3String2)
                    {
                      if ((int)paramAnonymous3String1.maN <= 0)
                      {
                        Log.e("MicroMsg.RecoverFriendSortView", "addContact : insert contact failed");
                        AppMethodBeat.o(184457);
                        return;
                        paramAnonymous3String2.setUsername(RecoverFriendSortView.1.1.this.pWg.pWm.pUf.field_encryptUsername);
                        break;
                      }
                      ab.I(paramAnonymous3String1);
                      k.cZ(RecoverFriendSortView.this.getContext(), RecoverFriendSortView.this.getContext().getString(a.g.app_added));
                      ar.br(RecoverFriendSortView.1.1.this.pWg.pWm.pUf.field_encryptUsername, 0);
                      RecoverFriendSortView.this.bDL();
                      AppMethodBeat.o(184457);
                      return;
                      if (paramAnonymous3Boolean2)
                      {
                        ar.br(RecoverFriendSortView.1.1.this.pWg.pWm.pUf.field_encryptUsername, 1);
                        RecoverFriendSortView.this.bDL();
                      }
                      AppMethodBeat.o(184457);
                      return;
                    }
                  }
                });
                paramAnonymous2View.bqM(paramAnonymousViewGroup.pWm.pUf.field_ticket);
                localObject = new LinkedList();
                ((LinkedList)localObject).add(Integer.valueOf(17));
                paramAnonymous2View.YaM = new com.tencent.mm.pluginsdk.ui.applet.a.b()
                {
                  public final boolean n(String paramAnonymous3String1, int paramAnonymous3Int, String paramAnonymous3String2)
                  {
                    AppMethodBeat.i(304821);
                    Intent localIntent = new Intent();
                    localIntent.putExtra("Contact_User", RecoverFriendSortView.1.1.this.pWg.pWm.pUf.field_encryptUsername);
                    localIntent.putExtra("Contact_Nick", RecoverFriendSortView.1.1.this.pWg.pWm.pUf.field_nickname);
                    localIntent.putExtra("Contact_Scene", 17);
                    localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
                    localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
                    localIntent.putExtra("sayhi_with_sns_perm_set_label", false);
                    localIntent.putExtra(f.e.adwe, RecoverFriendSortView.1.1.this.pWg.pWm.pUf.field_ticket);
                    localIntent.putExtra("sayhi_verify_add_errcode", paramAnonymous3Int);
                    paramAnonymous3Int = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zpi, 2);
                    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zpl, 5000);
                    paramAnonymous3String2 = ".ui.SayHiWithSnsPermissionUI";
                    if ((!au.bwO(RecoverFriendSortView.1.1.this.pWg.pWm.pUf.field_encryptUsername)) && (paramAnonymous3Int == 1)) {
                      paramAnonymous3String1 = ".ui.SayHiWithSnsPermissionUI2";
                    }
                    for (;;)
                    {
                      com.tencent.mm.br.c.b(RecoverFriendSortView.this.getContext(), "profile", paramAnonymous3String1, localIntent);
                      AppMethodBeat.o(304821);
                      return true;
                      paramAnonymous3String1 = paramAnonymous3String2;
                      if (!au.bwO(RecoverFriendSortView.1.1.this.pWg.pWm.pUf.field_encryptUsername))
                      {
                        paramAnonymous3String1 = paramAnonymous3String2;
                        if (paramAnonymous3Int == 2)
                        {
                          paramAnonymous3String1 = paramAnonymous3String2;
                          if (ab.bBW() >= i) {
                            paramAnonymous3String1 = ".ui.SayHiWithSnsPermissionUI3";
                          }
                        }
                      }
                    }
                  }
                };
                paramAnonymous2View.i(paramAnonymousViewGroup.pWm.pUf.field_encryptUsername, (LinkedList)localObject);
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
    ListView localListView = (ListView)findViewById(a.c.list_view);
    AppMethodBeat.o(184463);
    return localListView;
  }
  
  public View getNoResultView()
  {
    AppMethodBeat.i(184464);
    View localView = findViewById(a.c.no_result);
    AppMethodBeat.o(184464);
    return localView;
  }
  
  public VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(184462);
    VerticalScrollBar localVerticalScrollBar = (VerticalScrollBar)findViewById(a.c.sort_bar);
    AppMethodBeat.o(184462);
    return localVerticalScrollBar;
  }
  
  final class a
  {
    ImageView lKK;
    TextView pRf;
    TextView pSI;
    TextView pWj;
    TextView pWk;
    Button pWl;
    ar.a pWm;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView
 * JD-Core Version:    0.7.0.1
 */