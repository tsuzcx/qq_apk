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
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.plugin.game.d.e.b;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.s;
import java.util.HashSet;
import java.util.Set;

public final class d
  extends RecyclerView
{
  private com.tencent.mm.b.f<String, Bitmap> CYN;
  a DcT;
  private f DcU;
  private c DcV;
  private Set<Integer> DcW;
  private int jaR;
  private Context mContext;
  
  public d(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(183887);
    this.DcW = new HashSet();
    this.mContext = paramContext;
    this.jaR = paramInt;
    this.CYN = new b(30, getClass());
    this.DcU = new f(this.jaR, new f.b()
    {
      public final void ezQ()
      {
        AppMethodBeat.i(183882);
        d.a(d.this);
        AppMethodBeat.o(183882);
      }
    });
    paramInt = ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().TJ(1);
    this.DcT = new a(paramContext, ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().TG(1), paramInt);
    setLayoutManager(new LinearLayoutManager());
    setAdapter(this.DcT);
    AppMethodBeat.o(183887);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(183888);
    e.a.a locala = new e.a.a();
    locala.lRB = false;
    locala.Ded = paramFloat;
    e.eAa().a(paramImageView, paramString, locala.eAb(), new e.b()
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
    this.DcV = paramc;
  }
  
  final class a
    extends g<d.b>
  {
    int fuP;
    
    public a(Context paramContext, Cursor paramCursor, int paramInt)
    {
      super(paramCursor);
      this.fuP = paramInt;
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    ViewGroup DcY;
    TextView DcZ;
    TextView Dda;
    ImageView Ddb;
    TextView Ddc;
    TextView Ddd;
    View Dde;
    View Ddf;
    View Ddg;
    ImageView jmf;
    TextView timeTv;
    TextView xoK;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(183886);
      this.DcY = ((ViewGroup)paramView.findViewById(g.e.CkS));
      this.jmf = ((ImageView)paramView.findViewById(g.e.icon_iv));
      this.xoK = ((TextView)paramView.findViewById(g.e.nickname_tv));
      this.DcZ = ((TextView)paramView.findViewById(g.e.CkQ));
      this.Dda = ((TextView)paramView.findViewById(g.e.Clv));
      this.Ddb = ((ImageView)paramView.findViewById(g.e.Cls));
      this.Ddc = ((TextView)paramView.findViewById(g.e.content_tv));
      this.timeTv = ((TextView)paramView.findViewById(g.e.time_tv));
      this.Ddd = ((TextView)paramView.findViewById(g.e.source_tv));
      this.Dde = paramView.findViewById(g.e.CjZ);
      this.Ddf = paramView.findViewById(g.e.Cli);
      this.Ddg = paramView.findViewById(g.e.CkH);
      this.DcY.setOnLongClickListener(d.e(d.this));
      this.DcY.setOnClickListener(d.e(d.this));
      this.jmf.setOnLongClickListener(d.e(d.this));
      this.jmf.setOnClickListener(d.e(d.this));
      this.xoK.setOnLongClickListener(d.e(d.this));
      this.xoK.setOnClickListener(d.e(d.this));
      AppMethodBeat.o(183886);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.d
 * JD-Core Version:    0.7.0.1
 */