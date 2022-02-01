package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.protobuf.bz;
import com.tencent.mm.plugin.game.protobuf.ca;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public class GameDetailRankLikedUI
  extends MMActivity
{
  private static final String TAG;
  private Dialog ocE;
  private ListView xQs;
  private GameDetailRankLikedUI.a xQt;
  
  static
  {
    AppMethodBeat.i(42002);
    TAG = "MicroMsg" + GameDetailRankLikedUI.class.getSimpleName();
    AppMethodBeat.o(42002);
  }
  
  public int getLayoutId()
  {
    return 2131494850;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42001);
    setMMTitle(2131761189);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(41993);
        GameDetailRankLikedUI.this.finish();
        AppMethodBeat.o(41993);
        return true;
      }
    });
    this.xQs = ((ListView)findViewById(2131301942));
    this.xQt = new GameDetailRankLikedUI.a(this);
    this.xQs.setAdapter(this.xQt);
    this.ocE = c.gl(getContext());
    this.ocE.show();
    AppMethodBeat.o(42001);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42000);
    super.onCreate(paramBundle);
    initView();
    paramBundle = getIntent().getStringExtra("extra_appdi");
    if (Util.isNullOrNil(paramBundle))
    {
      finish();
      AppMethodBeat.o(42000);
      return;
    }
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bz();
    ((d.a)localObject).iLO = new ca();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/getuplist";
    ((d.a)localObject).funcId = 1331;
    localObject = ((d.a)localObject).aXF();
    ((bz)((d)localObject).iLK.iLR).hik = paramBundle;
    aa.a((d)localObject, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(41994);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e(GameDetailRankLikedUI.TAG, "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          GameDetailRankLikedUI.this.finish();
          AppMethodBeat.o(41994);
          return 0;
        }
        paramAnonymousd = (ca)paramAnonymousd.iLL.iLR;
        paramAnonymousString = GameDetailRankLikedUI.a(GameDetailRankLikedUI.this);
        paramAnonymousd = paramAnonymousd.xMg;
        if (paramAnonymousd != null)
        {
          paramAnonymousString.cvc.clear();
          paramAnonymousString.cvc.addAll(paramAnonymousd);
          paramAnonymousString.notifyDataSetChanged();
        }
        GameDetailRankLikedUI.b(GameDetailRankLikedUI.this).dismiss();
        AppMethodBeat.o(41994);
        return 0;
      }
    });
    AppMethodBeat.o(42000);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI
 * JD-Core Version:    0.7.0.1
 */