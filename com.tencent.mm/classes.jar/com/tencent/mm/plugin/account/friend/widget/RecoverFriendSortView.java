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
import com.tencent.mm.g.b.a.ns;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.account.friend.a.au.a;
import com.tencent.mm.plugin.account.friend.a.r;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.ui.e.d;
import java.util.LinkedList;

public class RecoverFriendSortView
  extends BaseSortView
{
  public String kgb;
  
  public RecoverFriendSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean a(String paramString, d paramd)
  {
    return false;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(184465);
    c.a local1 = new c.a()
    {
      public final View a(d paramAnonymousd, View paramAnonymousView, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(184460);
        final RecoverFriendSortView.a locala;
        au.a locala1;
        if (paramAnonymousView == null)
        {
          paramAnonymousView = View.inflate(RecoverFriendSortView.this.getContext(), 2131496073, null);
          locala = new RecoverFriendSortView.a(RecoverFriendSortView.this);
          locala.gyr = ((ImageView)paramAnonymousView.findViewById(2131301769));
          locala.kib = ((TextView)paramAnonymousView.findViewById(2131301790));
          locala.kcY = ((TextView)paramAnonymousView.findViewById(2131298244));
          locala.kic = ((TextView)paramAnonymousView.findViewById(2131301789));
          locala.keD = ((TextView)paramAnonymousView.findViewById(2131296538));
          locala.kid = ((Button)paramAnonymousView.findViewById(2131296528));
          locala1 = (au.a)paramAnonymousd.data;
          locala.kie = locala1;
          com.tencent.mm.pluginsdk.ui.a.b.c(locala.gyr, locala1.kfY.field_encryptUsername);
          locala.kib.setText(com.tencent.mm.pluginsdk.ui.span.l.c(paramAnonymousView.getContext(), locala1.kfY.field_nickname));
          if ((locala1.kfZ == null) || (Util.isNullOrNil(locala1.kfZ.field_msgContent))) {
            break label375;
          }
          locala.kic.setVisibility(0);
          locala.kib.setText(com.tencent.mm.pluginsdk.ui.span.l.c(paramAnonymousView.getContext(), locala1.kfZ.field_msgContent));
          label229:
          if ((!RecoverFriendSortView.this.OZW) || (!paramAnonymousBoolean1)) {
            break label388;
          }
          locala.kcY.setText(paramAnonymousd.Pae);
          locala.kcY.setVisibility(0);
          label265:
          if (((Util.isNullOrNil(locala1.kfY.field_encryptUsername)) || (!ab.IS(locala1.kfY.field_encryptUsername))) && ((Util.isNullOrNil(locala1.kfY.field_username)) || (!ab.IS(locala1.kfY.field_username)))) {
            break label401;
          }
          locala.keD.setVisibility(0);
          locala.keD.setText(2131755310);
          locala.kid.setVisibility(8);
        }
        for (;;)
        {
          paramAnonymousView.setTag(locala);
          AppMethodBeat.o(184460);
          return paramAnonymousView;
          locala = (RecoverFriendSortView.a)paramAnonymousView.getTag();
          break;
          label375:
          locala.kic.setVisibility(8);
          break label229;
          label388:
          locala.kcY.setVisibility(8);
          break label265;
          label401:
          if (locala1.kfY.field_addState == 1)
          {
            locala.keD.setVisibility(0);
            locala.keD.setText(2131760988);
            locala.kid.setVisibility(8);
          }
          else
          {
            locala.keD.setVisibility(8);
            locala.kid.setVisibility(0);
            locala.kid.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymous2View)
              {
                AppMethodBeat.i(184459);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymous2View);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/widget/RecoverFriendSortView$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
                paramAnonymous2View = new ns();
                paramAnonymous2View.eqm = 4;
                paramAnonymous2View.AR(z.aUb());
                paramAnonymous2View.AQ(RecoverFriendSortView.this.kgb);
                paramAnonymous2View.AS(locala.kie.kfY.field_encryptUsername);
                paramAnonymous2View.bfK();
                paramAnonymous2View = new com.tencent.mm.pluginsdk.ui.applet.a(RecoverFriendSortView.this.getContext(), new a.a()
                {
                  public final void a(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2, String paramAnonymous3String1, String paramAnonymous3String2)
                  {
                    AppMethodBeat.i(184457);
                    Log.i("MicroMsg.RecoverFriendSortView", "canAddContact %s,%s", new Object[] { paramAnonymous3String1, Boolean.valueOf(paramAnonymous3Boolean1) });
                    if (paramAnonymous3Boolean1)
                    {
                      paramAnonymous3String2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(RecoverFriendSortView.1.1.this.khY.kie.kfY.field_encryptUsername);
                      if ((int)paramAnonymous3String2.gMZ != 0) {
                        break label300;
                      }
                      if (!Util.isNullOrNil(paramAnonymous3String1))
                      {
                        paramAnonymous3String2.setUsername(paramAnonymous3String1);
                        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().ap(paramAnonymous3String2);
                      }
                    }
                    label300:
                    for (paramAnonymous3String1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramAnonymous3String2.field_username);; paramAnonymous3String1 = paramAnonymous3String2)
                    {
                      if ((int)paramAnonymous3String1.gMZ <= 0)
                      {
                        Log.e("MicroMsg.RecoverFriendSortView", "addContact : insert contact failed");
                        AppMethodBeat.o(184457);
                        return;
                        paramAnonymous3String2.setUsername(RecoverFriendSortView.1.1.this.khY.kie.kfY.field_encryptUsername);
                        break;
                      }
                      ab.B(paramAnonymous3String1);
                      h.cD(RecoverFriendSortView.this.getContext(), RecoverFriendSortView.this.getContext().getString(2131755310));
                      au.aI(RecoverFriendSortView.1.1.this.khY.kie.kfY.field_encryptUsername, 0);
                      RecoverFriendSortView.this.refresh();
                      AppMethodBeat.o(184457);
                      return;
                      if (paramAnonymous3Boolean2)
                      {
                        au.aI(RecoverFriendSortView.1.1.this.khY.kie.kfY.field_encryptUsername, 1);
                        RecoverFriendSortView.this.refresh();
                      }
                      AppMethodBeat.o(184457);
                      return;
                    }
                  }
                });
                paramAnonymous2View.beC(locala.kie.kfY.field_ticket);
                localObject = new LinkedList();
                ((LinkedList)localObject).add(Integer.valueOf(17));
                paramAnonymous2View.Kea = new com.tencent.mm.pluginsdk.ui.applet.a.b()
                {
                  public final boolean aE(String paramAnonymous3String, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(184458);
                    Intent localIntent = new Intent();
                    localIntent.putExtra("Contact_User", RecoverFriendSortView.1.1.this.khY.kie.kfY.field_encryptUsername);
                    localIntent.putExtra("Contact_Nick", RecoverFriendSortView.1.1.this.khY.kie.kfY.field_nickname);
                    localIntent.putExtra("Contact_Scene", 17);
                    localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
                    localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
                    localIntent.putExtra("sayhi_with_sns_perm_set_label", false);
                    localIntent.putExtra(e.d.OyT, RecoverFriendSortView.1.1.this.khY.kie.kfY.field_ticket);
                    localIntent.putExtra("sayhi_verify_add_errcode", paramAnonymous3Int);
                    paramAnonymous3Int = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slQ, 2);
                    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slT, 1000);
                    String str = ".ui.SayHiWithSnsPermissionUI";
                    if ((!as.bjp(RecoverFriendSortView.1.1.this.khY.kie.kfY.field_encryptUsername)) && (paramAnonymous3Int == 1)) {
                      paramAnonymous3String = ".ui.SayHiWithSnsPermissionUI2";
                    }
                    for (;;)
                    {
                      com.tencent.mm.br.c.b(RecoverFriendSortView.this.getContext(), "profile", paramAnonymous3String, localIntent);
                      AppMethodBeat.o(184458);
                      return true;
                      paramAnonymous3String = str;
                      if (!as.bjp(RecoverFriendSortView.1.1.this.khY.kie.kfY.field_encryptUsername))
                      {
                        paramAnonymous3String = str;
                        if (paramAnonymous3Int == 2)
                        {
                          paramAnonymous3String = str;
                          if (ab.aVc() >= i) {
                            paramAnonymous3String = ".ui.SayHiWithSnsPermissionUI3";
                          }
                        }
                      }
                    }
                  }
                };
                paramAnonymous2View.h(locala.kie.kfY.field_encryptUsername, (LinkedList)localObject);
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
    ListView localListView = (ListView)findViewById(2131303237);
    AppMethodBeat.o(184463);
    return localListView;
  }
  
  public View getNoResultView()
  {
    AppMethodBeat.i(184464);
    View localView = findViewById(2131305459);
    AppMethodBeat.o(184464);
    return localView;
  }
  
  public VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(184462);
    VerticalScrollBar localVerticalScrollBar = (VerticalScrollBar)findViewById(2131308291);
    AppMethodBeat.o(184462);
    return localVerticalScrollBar;
  }
  
  public final View inflate()
  {
    AppMethodBeat.i(184461);
    View localView = View.inflate(getContext(), 2131496075, this);
    AppMethodBeat.o(184461);
    return localView;
  }
  
  final class a
  {
    ImageView gyr;
    TextView kcY;
    TextView keD;
    TextView kib;
    TextView kic;
    Button kid;
    au.a kie;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView
 * JD-Core Version:    0.7.0.1
 */