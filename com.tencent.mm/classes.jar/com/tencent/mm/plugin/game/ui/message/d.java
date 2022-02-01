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
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.model.s;
import java.util.HashSet;
import java.util.Set;

public final class d
  extends RecyclerView
{
  private com.tencent.mm.b.f<String, Bitmap> ITd;
  a IXl;
  private f IXm;
  private c IXn;
  private Set<Integer> IXo;
  private int lCR;
  private Context mContext;
  
  public d(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(183887);
    this.IXo = new HashSet();
    this.mContext = paramContext;
    this.lCR = paramInt;
    this.ITd = new b(30, getClass());
    this.IXm = new f(this.lCR, new f.b()
    {
      public final void fHR()
      {
        AppMethodBeat.i(183882);
        d.a(d.this);
        AppMethodBeat.o(183882);
      }
    });
    paramInt = ((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().XD(1);
    this.IXl = new a(paramContext, ((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().XA(1), paramInt);
    setLayoutManager(new LinearLayoutManager());
    setAdapter(this.IXl);
    AppMethodBeat.o(183887);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(183888);
    e.a.a locala = new e.a.a();
    locala.oKn = false;
    locala.IYu = paramFloat;
    e.fIb().a(paramImageView, paramString, locala.fIc(), new e.b()
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
    this.IXn = paramc;
  }
  
  final class a
    extends g<d.b>
  {
    int hzj;
    
    public a(Context paramContext, Cursor paramCursor, int paramInt)
    {
      super(paramCursor);
      this.hzj = paramInt;
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    ViewGroup IXq;
    TextView IXr;
    TextView IXs;
    ImageView IXt;
    TextView IXu;
    TextView IXv;
    View IXw;
    View IXx;
    View IXy;
    ImageView lPb;
    TextView nicknameTv;
    TextView timeTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(183886);
      this.IXq = ((ViewGroup)paramView.findViewById(h.e.HXa));
      this.lPb = ((ImageView)paramView.findViewById(h.e.icon_iv));
      this.nicknameTv = ((TextView)paramView.findViewById(h.e.nickname_tv));
      this.IXr = ((TextView)paramView.findViewById(h.e.HWY));
      this.IXs = ((TextView)paramView.findViewById(h.e.HXD));
      this.IXt = ((ImageView)paramView.findViewById(h.e.HXA));
      this.IXu = ((TextView)paramView.findViewById(h.e.content_tv));
      this.timeTv = ((TextView)paramView.findViewById(h.e.time_tv));
      this.IXv = ((TextView)paramView.findViewById(h.e.source_tv));
      this.IXw = paramView.findViewById(h.e.HWh);
      this.IXx = paramView.findViewById(h.e.HXq);
      this.IXy = paramView.findViewById(h.e.HWP);
      this.IXq.setOnLongClickListener(d.e(d.this));
      this.IXq.setOnClickListener(d.e(d.this));
      this.lPb.setOnLongClickListener(d.e(d.this));
      this.lPb.setOnClickListener(d.e(d.this));
      this.nicknameTv.setOnLongClickListener(d.e(d.this));
      this.nicknameTv.setOnClickListener(d.e(d.this));
      AppMethodBeat.o(183886);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.d
 * JD-Core Version:    0.7.0.1
 */