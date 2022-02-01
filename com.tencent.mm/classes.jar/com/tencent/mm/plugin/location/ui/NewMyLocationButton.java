package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.sdk.platformtools.aq;

public class NewMyLocationButton
  extends FrameLayout
{
  private Context context;
  private b.a fHp;
  private ImageButton vnN;
  private LinearLayout vnO;
  private com.tencent.mm.plugin.k.d vnP;
  private boolean vnQ;
  
  public NewMyLocationButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55847);
    this.vnQ = true;
    this.fHp = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(55845);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(55845);
          return false;
        }
        NewMyLocationButton.a(NewMyLocationButton.this).setVisibility(8);
        NewMyLocationButton.b(NewMyLocationButton.this).setVisibility(0);
        if ((NewMyLocationButton.c(NewMyLocationButton.this) != null) && (NewMyLocationButton.d(NewMyLocationButton.this)))
        {
          NewMyLocationButton.c(NewMyLocationButton.this).getIController().setCenter(paramAnonymousFloat2, paramAnonymousFloat1);
          if (NewMyLocationButton.c(NewMyLocationButton.this).getZoomLevel() < 15) {
            NewMyLocationButton.c(NewMyLocationButton.this).getIController().setZoom(15);
          }
        }
        new aq(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(55844);
            com.tencent.mm.modelgeo.d.aIh().c(NewMyLocationButton.e(NewMyLocationButton.this));
            AppMethodBeat.o(55844);
          }
        });
        AppMethodBeat.o(55845);
        return false;
      }
    };
    this.context = paramContext;
    init();
    AppMethodBeat.o(55847);
  }
  
  public NewMyLocationButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55846);
    this.vnQ = true;
    this.fHp = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(55845);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(55845);
          return false;
        }
        NewMyLocationButton.a(NewMyLocationButton.this).setVisibility(8);
        NewMyLocationButton.b(NewMyLocationButton.this).setVisibility(0);
        if ((NewMyLocationButton.c(NewMyLocationButton.this) != null) && (NewMyLocationButton.d(NewMyLocationButton.this)))
        {
          NewMyLocationButton.c(NewMyLocationButton.this).getIController().setCenter(paramAnonymousFloat2, paramAnonymousFloat1);
          if (NewMyLocationButton.c(NewMyLocationButton.this).getZoomLevel() < 15) {
            NewMyLocationButton.c(NewMyLocationButton.this).getIController().setZoom(15);
          }
        }
        new aq(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(55844);
            com.tencent.mm.modelgeo.d.aIh().c(NewMyLocationButton.e(NewMyLocationButton.this));
            AppMethodBeat.o(55844);
          }
        });
        AppMethodBeat.o(55845);
        return false;
      }
    };
    this.context = paramContext;
    init();
    AppMethodBeat.o(55846);
  }
  
  private void init()
  {
    AppMethodBeat.i(55848);
    View localView = View.inflate(this.context, 2131495016, this);
    this.vnN = ((ImageButton)localView.findViewById(2131302788));
    this.vnO = ((LinearLayout)localView.findViewById(2131302796));
    AppMethodBeat.o(55848);
  }
  
  public void setAnimToSelf(boolean paramBoolean)
  {
    this.vnQ = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(55849);
    this.vnN.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(55849);
  }
  
  public void setProgressBar(com.tencent.mm.plugin.k.d paramd)
  {
    AppMethodBeat.i(55850);
    this.vnP = paramd;
    this.vnO.setVisibility(0);
    this.vnN.setVisibility(8);
    com.tencent.mm.modelgeo.d.aIh().b(this.fHp, true);
    AppMethodBeat.o(55850);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(55851);
    if (paramBoolean != this.vnN.isSelected()) {
      this.vnN.setSelected(paramBoolean);
    }
    AppMethodBeat.o(55851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.NewMyLocationButton
 * JD-Core Version:    0.7.0.1
 */