package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.e.e.a.a;
import com.tencent.mm.plugin.game.e.e.b;
import com.tencent.mm.plugin.game.model.s;
import java.util.HashSet;
import java.util.Set;

public final class d
  extends RecyclerView
{
  private int gwE;
  private Context mContext;
  private com.tencent.mm.b.f<String, Bitmap> xUC;
  a xYn;
  private f xYo;
  private c xYp;
  private Set<Integer> xYq;
  
  public d(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(183887);
    this.xYq = new HashSet();
    this.mContext = paramContext;
    this.gwE = paramInt;
    this.xUC = new b(30, getClass());
    this.xYo = new f(this.gwE, new f.b()
    {
      public final void dWI()
      {
        AppMethodBeat.i(183882);
        d.a(d.this);
        AppMethodBeat.o(183882);
      }
    });
    paramInt = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().Op(1);
    this.xYn = new a(paramContext, ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().On(1), paramInt);
    setLayoutManager(new LinearLayoutManager());
    setAdapter(this.xYn);
    AppMethodBeat.o(183887);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(183888);
    e.a.a locala = new e.a.a();
    locala.jbd = false;
    locala.xZw = paramFloat;
    e.dWR().a(paramImageView, paramString, locala.dWS(), new e.b()
    {
      public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(183883);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
          d.f(d.this).put(paramString, paramAnonymousBitmap);
        }
        AppMethodBeat.o(183883);
      }
    });
    AppMethodBeat.o(183888);
  }
  
  public final void setEmptyCallback(c paramc)
  {
    this.xYp = paramc;
  }
  
  final class a
    extends g<d.b>
  {
    int dCm;
    
    public a(Context paramContext, Cursor paramCursor, int paramInt)
    {
      super(paramCursor);
      this.dCm = paramInt;
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    ImageView gBZ;
    TextView pIN;
    TextView timeTv;
    View xYA;
    ViewGroup xYs;
    TextView xYt;
    TextView xYu;
    ImageView xYv;
    TextView xYw;
    TextView xYx;
    View xYy;
    View xYz;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(183886);
      this.xYs = ((ViewGroup)paramView.findViewById(2131304950));
      this.gBZ = ((ImageView)paramView.findViewById(2131302497));
      this.pIN = ((TextView)paramView.findViewById(2131305440));
      this.xYt = ((TextView)paramView.findViewById(2131304910));
      this.xYu = ((TextView)paramView.findViewById(2131307113));
      this.xYv = ((ImageView)paramView.findViewById(2131307100));
      this.xYw = ((TextView)paramView.findViewById(2131299223));
      this.timeTv = ((TextView)paramView.findViewById(2131309101));
      this.xYx = ((TextView)paramView.findViewById(2131308313));
      this.xYy = paramView.findViewById(2131302045);
      this.xYz = paramView.findViewById(2131305359);
      this.xYA = paramView.findViewById(2131303689);
      this.xYs.setOnLongClickListener(d.e(d.this));
      this.xYs.setOnClickListener(d.e(d.this));
      this.gBZ.setOnLongClickListener(d.e(d.this));
      this.gBZ.setOnClickListener(d.e(d.this));
      this.pIN.setOnLongClickListener(d.e(d.this));
      this.pIN.setOnClickListener(d.e(d.this));
      AppMethodBeat.o(183886);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.d
 * JD-Core Version:    0.7.0.1
 */