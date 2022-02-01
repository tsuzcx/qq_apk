package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.bp;
import com.tencent.mm.plugin.game.d.bq;
import com.tencent.mm.plugin.game.d.dm;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

public class GameDetailRankLikedUI
  extends MMActivity
{
  private static final String TAG;
  private Dialog mjY;
  private a toA;
  private ListView toz;
  
  static
  {
    AppMethodBeat.i(42002);
    TAG = "MicroMsg" + GameDetailRankLikedUI.class.getSimpleName();
    AppMethodBeat.o(42002);
  }
  
  public int getLayoutId()
  {
    return 2131494288;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42001);
    setMMTitle(2131759854);
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
    this.toz = ((ListView)findViewById(2131300419));
    this.toA = new a(this);
    this.toz.setAdapter(this.toA);
    this.mjY = c.fv(getContext());
    this.mjY.show();
    AppMethodBeat.o(42001);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42000);
    super.onCreate(paramBundle);
    initView();
    paramBundle = getIntent().getStringExtra("extra_appdi");
    if (bs.isNullOrNil(paramBundle))
    {
      finish();
      AppMethodBeat.o(42000);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bp();
    ((b.a)localObject).hvu = new bq();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/getuplist";
    ((b.a)localObject).funcId = 1331;
    localObject = ((b.a)localObject).aAz();
    ((bp)((b)localObject).hvr.hvw).fZx = paramBundle;
    x.a((b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(41994);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ac.e(GameDetailRankLikedUI.TAG, "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          GameDetailRankLikedUI.this.finish();
          AppMethodBeat.o(41994);
          return 0;
        }
        paramAnonymousb = (bq)paramAnonymousb.hvs.hvw;
        paramAnonymousString = GameDetailRankLikedUI.a(GameDetailRankLikedUI.this);
        paramAnonymousb = paramAnonymousb.tkC;
        if (paramAnonymousb != null)
        {
          paramAnonymousString.bYM.clear();
          paramAnonymousString.bYM.addAll(paramAnonymousb);
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
  
  static final class a
    extends BaseAdapter
  {
    List<dm> bYM;
    private Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(41995);
      this.bYM = new LinkedList();
      this.mContext = paramContext;
      AppMethodBeat.o(41995);
    }
    
    private dm GC(int paramInt)
    {
      AppMethodBeat.i(41997);
      dm localdm = (dm)this.bYM.get(paramInt);
      AppMethodBeat.o(41997);
      return localdm;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(41996);
      int i = this.bYM.size();
      AppMethodBeat.o(41996);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(41998);
      dm localdm;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.mContext).inflate(2131494289, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.iKw = ((ImageView)paramView.findViewById(2131300416));
        paramViewGroup.tom = ((TextView)paramView.findViewById(2131300417));
        paramViewGroup.toC = ((TextView)paramView.findViewById(2131300418));
        paramView.setTag(paramViewGroup);
        localdm = GC(paramInt);
        a.b.a(paramViewGroup.iKw, localdm.tlK, 0.5F, false);
        Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(localdm.tlK);
        if (localObject == null) {
          break label196;
        }
        localObject = new SpannableString(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, ((ai)localObject).aaS(), paramViewGroup.tom.getTextSize()));
        paramViewGroup.tom.setText((CharSequence)localObject);
      }
      for (;;)
      {
        paramViewGroup.toC.setText(localdm.tlL);
        AppMethodBeat.o(41998);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label196:
        paramViewGroup.tom.setText("");
      }
    }
    
    static final class a
    {
      public ImageView iKw;
      public TextView toC;
      public TextView tom;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI
 * JD-Core Version:    0.7.0.1
 */