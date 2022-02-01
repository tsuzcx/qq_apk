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
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.protobuf.ca;
import com.tencent.mm.plugin.game.protobuf.cb;
import com.tencent.mm.plugin.game.protobuf.ek;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

public class GameDetailRankLikedUI
  extends MMActivity
{
  private static final String TAG;
  private ListView CUB;
  private a CUC;
  private Dialog reo;
  
  static
  {
    AppMethodBeat.i(42002);
    TAG = "MicroMsg" + GameDetailRankLikedUI.class.getSimpleName();
    AppMethodBeat.o(42002);
  }
  
  public int getLayoutId()
  {
    return g.f.CmV;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42001);
    setMMTitle(g.i.CoK);
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
    this.CUB = ((ListView)findViewById(g.e.CiU));
    this.CUC = new a(this);
    this.CUB.setAdapter(this.CUC);
    this.reo = c.gF(getContext());
    this.reo.show();
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
    ((d.a)localObject).lBU = new ca();
    ((d.a)localObject).lBV = new cb();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/getuplist";
    ((d.a)localObject).funcId = 1331;
    localObject = ((d.a)localObject).bgN();
    ((ca)d.b.b(((d)localObject).lBR)).jUi = paramBundle;
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
        paramAnonymousd = (cb)d.c.b(paramAnonymousd.lBS);
        paramAnonymousString = GameDetailRankLikedUI.a(GameDetailRankLikedUI.this);
        paramAnonymousd = paramAnonymousd.CQp;
        if (paramAnonymousd != null)
        {
          paramAnonymousString.ctq.clear();
          paramAnonymousString.ctq.addAll(paramAnonymousd);
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
    List<ek> ctq;
    private Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(41995);
      this.ctq = new LinkedList();
      this.mContext = paramContext;
      AppMethodBeat.o(41995);
    }
    
    private ek TO(int paramInt)
    {
      AppMethodBeat.i(41997);
      ek localek = (ek)this.ctq.get(paramInt);
      AppMethodBeat.o(41997);
      return localek;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(41996);
      int i = this.ctq.size();
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
      ek localek;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.mContext).inflate(g.f.CmW, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.mWb = ((ImageView)paramView.findViewById(g.e.CiR));
        paramViewGroup.znp = ((TextView)paramView.findViewById(g.e.CiS));
        paramViewGroup.sGk = ((TextView)paramView.findViewById(g.e.CiT));
        paramView.setTag(paramViewGroup);
        localek = TO(paramInt);
        a.b.a(paramViewGroup.mWb, localek.CRR, 0.5F, false);
        Object localObject = ((n)h.ae(n.class)).bbL().RG(localek.CRR);
        if (localObject == null) {
          break label200;
        }
        localObject = new SpannableString(l.b(this.mContext, ((as)localObject).ays(), paramViewGroup.znp.getTextSize()));
        paramViewGroup.znp.setText((CharSequence)localObject);
      }
      for (;;)
      {
        paramViewGroup.sGk.setText(localek.CRS);
        AppMethodBeat.o(41998);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label200:
        paramViewGroup.znp.setText("");
      }
    }
    
    static final class a
    {
      public ImageView mWb;
      public TextView sGk;
      public TextView znp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI
 * JD-Core Version:    0.7.0.1
 */