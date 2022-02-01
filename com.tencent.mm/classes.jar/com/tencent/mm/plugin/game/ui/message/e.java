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
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.model.s;
import java.util.HashSet;
import java.util.Set;

public final class e
  extends RecyclerView
{
  private com.tencent.mm.b.f<String, Bitmap> ITd;
  private f IXm;
  private c IXn;
  private Set<Integer> IXo;
  b IXz;
  private int lCR;
  private Context mContext;
  
  public e(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(183896);
    this.IXo = new HashSet();
    this.mContext = paramContext;
    this.lCR = paramInt;
    this.ITd = new b(30, getClass());
    this.IXm = new f(this.lCR, new f.b()
    {
      public final void fHR()
      {
        AppMethodBeat.i(183891);
        e.a(e.this);
        AppMethodBeat.o(183891);
      }
    });
    paramInt = ((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().XD(2);
    this.IXz = new b(paramContext, ((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().XA(2), paramInt);
    setLayoutManager(new LinearLayoutManager());
    setAdapter(this.IXz);
    AppMethodBeat.o(183896);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(183897);
    e.a.a locala = new e.a.a();
    locala.oKn = false;
    locala.IYu = paramFloat;
    com.tencent.mm.plugin.game.d.e.fIb().a(paramImageView, paramString, locala.fIc(), new com.tencent.mm.plugin.game.d.e.b()
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
    this.IXn = paramc;
  }
  
  final class a
    extends RecyclerView.v
  {
    private ViewGroup IXB;
    ImageView IXC;
    ViewGroup IXq;
    View IXw;
    View IXx;
    View IXy;
    TextView descTv;
    ImageView lPb;
    TextView nicknameTv;
    TextView timeTv;
    TextView titleTv;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(183893);
      this.IXq = ((ViewGroup)paramView.findViewById(h.e.HXa));
      this.lPb = ((ImageView)paramView.findViewById(h.e.icon_iv));
      this.nicknameTv = ((TextView)paramView.findViewById(h.e.nickname_tv));
      this.IXB = ((ViewGroup)paramView.findViewById(h.e.HXb));
      this.IXC = ((ImageView)paramView.findViewById(h.e.HTF));
      this.titleTv = ((TextView)paramView.findViewById(h.e.card_title_tv));
      this.descTv = ((TextView)paramView.findViewById(h.e.HTE));
      this.timeTv = ((TextView)paramView.findViewById(h.e.time_tv));
      this.IXw = paramView.findViewById(h.e.HWh);
      this.IXx = paramView.findViewById(h.e.HXq);
      this.IXy = paramView.findViewById(h.e.HWP);
      this.IXq.setOnLongClickListener(e.e(e.this));
      this.IXq.setOnClickListener(e.e(e.this));
      this.lPb.setOnLongClickListener(e.e(e.this));
      this.lPb.setOnClickListener(e.e(e.this));
      this.nicknameTv.setOnLongClickListener(e.e(e.this));
      this.nicknameTv.setOnClickListener(e.e(e.this));
      AppMethodBeat.o(183893);
    }
  }
  
  final class b
    extends g<e.a>
  {
    int hzj;
    
    public b(Context paramContext, Cursor paramCursor, int paramInt)
    {
      super(paramCursor);
      this.hzj = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.e
 * JD-Core Version:    0.7.0.1
 */