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
import com.tencent.mm.sdk.platformtools.ap;

public class NewMyLocationButton
  extends FrameLayout
{
  private Context context;
  private b.a fFl;
  private ImageButton vbC;
  private LinearLayout vbD;
  private com.tencent.mm.plugin.k.d vbE;
  private boolean vbF;
  
  public NewMyLocationButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55847);
    this.vbF = true;
    this.fFl = new b.a()
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
        new ap(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(55844);
            com.tencent.mm.modelgeo.d.aHQ().c(NewMyLocationButton.e(NewMyLocationButton.this));
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
    this.vbF = true;
    this.fFl = new b.a()
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
        new ap(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(55844);
            com.tencent.mm.modelgeo.d.aHQ().c(NewMyLocationButton.e(NewMyLocationButton.this));
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
    this.vbC = ((ImageButton)localView.findViewById(2131302788));
    this.vbD = ((LinearLayout)localView.findViewById(2131302796));
    AppMethodBeat.o(55848);
  }
  
  public void setAnimToSelf(boolean paramBoolean)
  {
    this.vbF = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(55849);
    this.vbC.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(55849);
  }
  
  public void setProgressBar(com.tencent.mm.plugin.k.d paramd)
  {
    AppMethodBeat.i(55850);
    this.vbE = paramd;
    this.vbD.setVisibility(0);
    this.vbC.setVisibility(8);
    com.tencent.mm.modelgeo.d.aHQ().b(this.fFl, true);
    AppMethodBeat.o(55850);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(55851);
    if (paramBoolean != this.vbC.isSelected()) {
      this.vbC.setSelected(paramBoolean);
    }
    AppMethodBeat.o(55851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.NewMyLocationButton
 * JD-Core Version:    0.7.0.1
 */