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
import com.tencent.mm.plugin.game.d.bz;
import com.tencent.mm.plugin.game.d.ca;
import com.tencent.mm.plugin.game.d.ej;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

public class GameDetailRankLikedUI
  extends MMActivity
{
  private static final String TAG;
  private Dialog mPB;
  private ListView uyt;
  private a uyu;
  
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
    this.uyt = ((ListView)findViewById(2131300419));
    this.uyu = new a(this);
    this.uyt.setAdapter(this.uyu);
    this.mPB = c.fF(getContext());
    this.mPB.show();
    AppMethodBeat.o(42001);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42000);
    super.onCreate(paramBundle);
    initView();
    paramBundle = getIntent().getStringExtra("extra_appdi");
    if (bu.isNullOrNil(paramBundle))
    {
      finish();
      AppMethodBeat.o(42000);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bz();
    ((b.a)localObject).hQG = new ca();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/getuplist";
    ((b.a)localObject).funcId = 1331;
    localObject = ((b.a)localObject).aDS();
    ((bz)((b)localObject).hQD.hQJ).gvv = paramBundle;
    x.a((b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(41994);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ae.e(GameDetailRankLikedUI.TAG, "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          GameDetailRankLikedUI.this.finish();
          AppMethodBeat.o(41994);
          return 0;
        }
        paramAnonymousb = (ca)paramAnonymousb.hQE.hQJ;
        paramAnonymousString = GameDetailRankLikedUI.a(GameDetailRankLikedUI.this);
        paramAnonymousb = paramAnonymousb.uue;
        if (paramAnonymousb != null)
        {
          paramAnonymousString.cjg.clear();
          paramAnonymousString.cjg.addAll(paramAnonymousb);
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
    List<ej> cjg;
    private Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(41995);
      this.cjg = new LinkedList();
      this.mContext = paramContext;
      AppMethodBeat.o(41995);
    }
    
    private ej It(int paramInt)
    {
      AppMethodBeat.i(41997);
      ej localej = (ej)this.cjg.get(paramInt);
      AppMethodBeat.o(41997);
      return localej;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(41996);
      int i = this.cjg.size();
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
      ej localej;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.mContext).inflate(2131494289, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.jgy = ((ImageView)paramView.findViewById(2131300416));
        paramViewGroup.uyh = ((TextView)paramView.findViewById(2131300417));
        paramViewGroup.okL = ((TextView)paramView.findViewById(2131300418));
        paramView.setTag(paramViewGroup);
        localej = It(paramInt);
        a.b.a(paramViewGroup.jgy, localej.uvG, 0.5F, false);
        Object localObject = ((l)g.ab(l.class)).azF().BH(localej.uvG);
        if (localObject == null) {
          break label196;
        }
        localObject = new SpannableString(k.b(this.mContext, ((an)localObject).adG(), paramViewGroup.uyh.getTextSize()));
        paramViewGroup.uyh.setText((CharSequence)localObject);
      }
      for (;;)
      {
        paramViewGroup.okL.setText(localej.uvH);
        AppMethodBeat.o(41998);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label196:
        paramViewGroup.uyh.setText("");
      }
    }
    
    static final class a
    {
      public ImageView jgy;
      public TextView okL;
      public TextView uyh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI
 * JD-Core Version:    0.7.0.1
 */