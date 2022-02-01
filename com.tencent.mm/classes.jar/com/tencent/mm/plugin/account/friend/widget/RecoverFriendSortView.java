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
import com.tencent.mm.by.c;
import com.tencent.mm.f.b.a.qt;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.account.friend.a.au.a;
import com.tencent.mm.plugin.account.friend.a.r;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.f.d;
import java.util.LinkedList;

public class RecoverFriendSortView
  extends BaseSortView
{
  public String mXA;
  
  public RecoverFriendSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
  {
    return false;
  }
  
  public final View eI()
  {
    AppMethodBeat.i(184461);
    View localView = View.inflate(getContext(), a.d.recover_friend_sort_view, this);
    AppMethodBeat.o(184461);
    return localView;
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
          paramAnonymousView = View.inflate(RecoverFriendSortView.this.getContext(), a.d.recover_friend_item, null);
          locala = new RecoverFriendSortView.a(RecoverFriendSortView.this);
          locala.jiu = ((ImageView)paramAnonymousView.findViewById(a.c.friend_avatar));
          locala.mZA = ((TextView)paramAnonymousView.findViewById(a.c.friend_nickname));
          locala.mUx = ((TextView)paramAnonymousView.findViewById(a.c.catalogTV));
          locala.mZB = ((TextView)paramAnonymousView.findViewById(a.c.friend_last_msg));
          locala.mWc = ((TextView)paramAnonymousView.findViewById(a.c.add_state_tv));
          locala.mZC = ((Button)paramAnonymousView.findViewById(a.c.add_btn));
          locala1 = (au.a)paramAnonymousd.bnW;
          locala.mZD = locala1;
          com.tencent.mm.pluginsdk.ui.a.b.c(locala.jiu, locala1.mXx.field_encryptUsername);
          locala.mZA.setText(l.c(paramAnonymousView.getContext(), locala1.mXx.field_nickname));
          if ((locala1.mXy == null) || (Util.isNullOrNil(locala1.mXy.field_msgContent))) {
            break label383;
          }
          locala.mZB.setVisibility(0);
          locala.mZA.setText(l.c(paramAnonymousView.getContext(), locala1.mXy.field_msgContent));
          label236:
          if ((!RecoverFriendSortView.this.Wtj) || (!paramAnonymousBoolean1)) {
            break label396;
          }
          locala.mUx.setText(paramAnonymousd.Wtr);
          locala.mUx.setVisibility(0);
          label272:
          if (((Util.isNullOrNil(locala1.mXx.field_encryptUsername)) || (!ab.Ql(locala1.mXx.field_encryptUsername))) && ((Util.isNullOrNil(locala1.mXx.field_username)) || (!ab.Ql(locala1.mXx.field_username)))) {
            break label409;
          }
          locala.mWc.setVisibility(0);
          locala.mWc.setText(a.g.app_added);
          locala.mZC.setVisibility(8);
        }
        for (;;)
        {
          paramAnonymousView.setTag(locala);
          AppMethodBeat.o(184460);
          return paramAnonymousView;
          locala = (RecoverFriendSortView.a)paramAnonymousView.getTag();
          break;
          label383:
          locala.mZB.setVisibility(8);
          break label236;
          label396:
          locala.mUx.setVisibility(8);
          break label272;
          label409:
          if (locala1.mXx.field_addState == 1)
          {
            locala.mWc.setVisibility(0);
            locala.mWc.setText(a.g.friend_waiting_ask);
            locala.mZC.setVisibility(8);
          }
          else
          {
            locala.mWc.setVisibility(8);
            locala.mZC.setVisibility(0);
            locala.mZC.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymous2View)
              {
                AppMethodBeat.i(184459);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymous2View);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/widget/RecoverFriendSortView$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
                paramAnonymous2View = new qt();
                paramAnonymous2View.gly = 4;
                paramAnonymous2View.HK(z.bdc());
                paramAnonymous2View.HJ(RecoverFriendSortView.this.mXA);
                paramAnonymous2View.HL(locala.mZD.mXx.field_encryptUsername);
                paramAnonymous2View.bpa();
                paramAnonymous2View = new com.tencent.mm.pluginsdk.ui.applet.a(RecoverFriendSortView.this.getContext(), new a.a()
                {
                  public final void a(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2, String paramAnonymous3String1, String paramAnonymous3String2)
                  {
                    AppMethodBeat.i(184457);
                    Log.i("MicroMsg.RecoverFriendSortView", "canAddContact %s,%s", new Object[] { paramAnonymous3String1, Boolean.valueOf(paramAnonymous3Boolean1) });
                    if (paramAnonymous3Boolean1)
                    {
                      paramAnonymous3String2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(RecoverFriendSortView.1.1.this.mZx.mZD.mXx.field_encryptUsername);
                      if ((int)paramAnonymous3String2.jxt != 0) {
                        break label301;
                      }
                      if (!Util.isNullOrNil(paramAnonymous3String1))
                      {
                        paramAnonymous3String2.setUsername(paramAnonymous3String1);
                        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().av(paramAnonymous3String2);
                      }
                    }
                    label301:
                    for (paramAnonymous3String1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramAnonymous3String2.field_username);; paramAnonymous3String1 = paramAnonymous3String2)
                    {
                      if ((int)paramAnonymous3String1.jxt <= 0)
                      {
                        Log.e("MicroMsg.RecoverFriendSortView", "addContact : insert contact failed");
                        AppMethodBeat.o(184457);
                        return;
                        paramAnonymous3String2.setUsername(RecoverFriendSortView.1.1.this.mZx.mZD.mXx.field_encryptUsername);
                        break;
                      }
                      ab.H(paramAnonymous3String1);
                      com.tencent.mm.ui.base.h.cO(RecoverFriendSortView.this.getContext(), RecoverFriendSortView.this.getContext().getString(a.g.app_added));
                      au.bb(RecoverFriendSortView.1.1.this.mZx.mZD.mXx.field_encryptUsername, 0);
                      RecoverFriendSortView.this.bfU();
                      AppMethodBeat.o(184457);
                      return;
                      if (paramAnonymous3Boolean2)
                      {
                        au.bb(RecoverFriendSortView.1.1.this.mZx.mZD.mXx.field_encryptUsername, 1);
                        RecoverFriendSortView.this.bfU();
                      }
                      AppMethodBeat.o(184457);
                      return;
                    }
                  }
                });
                paramAnonymous2View.bqY(locala.mZD.mXx.field_ticket);
                localObject = new LinkedList();
                ((LinkedList)localObject).add(Integer.valueOf(17));
                paramAnonymous2View.ReH = new com.tencent.mm.pluginsdk.ui.applet.a.b()
                {
                  public final boolean m(String paramAnonymous3String1, int paramAnonymous3Int, String paramAnonymous3String2)
                  {
                    AppMethodBeat.i(194136);
                    Intent localIntent = new Intent();
                    localIntent.putExtra("Contact_User", RecoverFriendSortView.1.1.this.mZx.mZD.mXx.field_encryptUsername);
                    localIntent.putExtra("Contact_Nick", RecoverFriendSortView.1.1.this.mZx.mZD.mXx.field_nickname);
                    localIntent.putExtra("Contact_Scene", 17);
                    localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
                    localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
                    localIntent.putExtra("sayhi_with_sns_perm_set_label", false);
                    localIntent.putExtra(f.d.VRW, RecoverFriendSortView.1.1.this.mZx.mZD.mXx.field_ticket);
                    localIntent.putExtra("sayhi_verify_add_errcode", paramAnonymous3Int);
                    paramAnonymous3Int = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWD, 2);
                    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWG, 5000);
                    paramAnonymous3String2 = ".ui.SayHiWithSnsPermissionUI";
                    if ((!as.bvK(RecoverFriendSortView.1.1.this.mZx.mZD.mXx.field_encryptUsername)) && (paramAnonymous3Int == 1)) {
                      paramAnonymous3String1 = ".ui.SayHiWithSnsPermissionUI2";
                    }
                    for (;;)
                    {
                      c.b(RecoverFriendSortView.this.getContext(), "profile", paramAnonymous3String1, localIntent);
                      AppMethodBeat.o(194136);
                      return true;
                      paramAnonymous3String1 = paramAnonymous3String2;
                      if (!as.bvK(RecoverFriendSortView.1.1.this.mZx.mZD.mXx.field_encryptUsername))
                      {
                        paramAnonymous3String1 = paramAnonymous3String2;
                        if (paramAnonymous3Int == 2)
                        {
                          paramAnonymous3String1 = paramAnonymous3String2;
                          if (ab.bef() >= i) {
                            paramAnonymous3String1 = ".ui.SayHiWithSnsPermissionUI3";
                          }
                        }
                      }
                    }
                  }
                };
                paramAnonymous2View.i(locala.mZD.mXx.field_encryptUsername, (LinkedList)localObject);
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
    ImageView jiu;
    TextView mUx;
    TextView mWc;
    TextView mZA;
    TextView mZB;
    Button mZC;
    au.a mZD;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView
 * JD-Core Version:    0.7.0.1
 */