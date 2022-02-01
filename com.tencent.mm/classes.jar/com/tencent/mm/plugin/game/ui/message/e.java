package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.s;
import java.util.HashSet;
import java.util.Set;

public final class e
  extends RecyclerView
{
  private com.tencent.mm.b.f<String, Bitmap> CYN;
  private f DcU;
  private c DcV;
  private Set<Integer> DcW;
  b Ddh;
  private int jaR;
  private Context mContext;
  
  public e(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(183896);
    this.DcW = new HashSet();
    this.mContext = paramContext;
    this.jaR = paramInt;
    this.CYN = new b(30, getClass());
    this.DcU = new f(this.jaR, new f.b()
    {
      public final void ezQ()
      {
        AppMethodBeat.i(183891);
        e.a(e.this);
        AppMethodBeat.o(183891);
      }
    });
    paramInt = ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().TJ(2);
    this.Ddh = new b(paramContext, ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().TG(2), paramInt);
    setLayoutManager(new LinearLayoutManager());
    setAdapter(this.Ddh);
    AppMethodBeat.o(183896);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(183897);
    e.a.a locala = new e.a.a();
    locala.lRB = false;
    locala.Ded = paramFloat;
    com.tencent.mm.plugin.game.d.e.eAa().a(paramImageView, paramString, locala.eAb(), new com.tencent.mm.plugin.game.d.e.b()
    {
      public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(183892);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
          e.f(e.this).put(paramString, paramAnonymousBitmap);
        }
        AppMethodBeat.o(183892);
      }
    });
    AppMethodBeat.o(183897);
  }
  
  public final void setEmptyCallback(c paramc)
  {
    this.DcV = paramc;
  }
  
  final class a
    extends RecyclerView.v
  {
    ViewGroup DcY;
    View Dde;
    View Ddf;
    View Ddg;
    private ViewGroup Ddj;
    ImageView Ddk;
    ImageView jmf;
    TextView kEs;
    TextView timeTv;
    TextView titleTv;
    TextView xoK;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(183893);
      this.DcY = ((ViewGroup)paramView.findViewById(g.e.CkS));
      this.jmf = ((ImageView)paramView.findViewById(g.e.icon_iv));
      this.xoK = ((TextView)paramView.findViewById(g.e.nickname_tv));
      this.Ddj = ((ViewGroup)paramView.findViewById(g.e.CkT));
      this.Ddk = ((ImageView)paramView.findViewById(g.e.Chw));
      this.titleTv = ((TextView)paramView.findViewById(g.e.Chx));
      this.kEs = ((TextView)paramView.findViewById(g.e.Chv));
      this.timeTv = ((TextView)paramView.findViewById(g.e.time_tv));
      this.Dde = paramView.findViewById(g.e.CjZ);
      this.Ddf = paramView.findViewById(g.e.Cli);
      this.Ddg = paramView.findViewById(g.e.CkH);
      this.DcY.setOnLongClickListener(e.e(e.this));
      this.DcY.setOnClickListener(e.e(e.this));
      this.jmf.setOnLongClickListener(e.e(e.this));
      this.jmf.setOnClickListener(e.e(e.this));
      this.xoK.setOnLongClickListener(e.e(e.this));
      this.xoK.setOnClickListener(e.e(e.this));
      AppMethodBeat.o(183893);
    }
  }
  
  final class b
    extends g<e.a>
  {
    int fuP;
    
    public b(Context paramContext, Cursor paramCursor, int paramInt)
    {
      super(paramCursor);
      this.fuP = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.e
 * JD-Core Version:    0.7.0.1
 */