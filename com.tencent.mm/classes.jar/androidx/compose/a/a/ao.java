package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/SpringSimulation;", "", "finalPosition", "", "(F)V", "dampedFreq", "", "value", "dampingRatio", "getDampingRatio", "()F", "setDampingRatio", "getFinalPosition", "setFinalPosition", "gammaMinus", "gammaPlus", "initialized", "", "naturalFreq", "stiffness", "getStiffness", "setStiffness", "getAcceleration", "lastDisplacement", "lastVelocity", "init", "", "updateValues", "Landroidx/compose/animation/core/Motion;", "timeElapsed", "", "updateValues-IJZedt4$animation_core_release", "(FFJ)J", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
{
  float UV;
  float VP;
  double VQ;
  private double VR;
  private double VS;
  private double VT;
  boolean initialized;
  
  public ao()
  {
    AppMethodBeat.i(203355);
    this.VP = 1.0F;
    this.VQ = Math.sqrt(50.0D);
    this.UV = 1.0F;
    AppMethodBeat.o(203355);
  }
  
  private final void init()
  {
    AppMethodBeat.i(203362);
    if (this.initialized)
    {
      AppMethodBeat.o(203362);
      return;
    }
    if (this.VP == ap.lQ()) {}
    for (int i = 1; i != 0; i = 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
      AppMethodBeat.o(203362);
      throw localIllegalStateException;
    }
    double d1 = this.UV * this.UV;
    double d2;
    if (this.UV > 1.0F)
    {
      d2 = -this.UV;
      double d3 = this.VQ;
      double d4 = this.VQ;
      d1 -= 1.0D;
      this.VR = (d2 * d3 + d4 * Math.sqrt(d1));
      d2 = -this.UV;
      d3 = this.VQ;
      d4 = this.VQ;
      this.VS = (d2 * d3 - Math.sqrt(d1) * d4);
    }
    for (;;)
    {
      this.initialized = true;
      AppMethodBeat.o(203362);
      return;
      if ((this.UV >= 0.0F) && (this.UV < 1.0F))
      {
        d2 = this.VQ;
        this.VT = (Math.sqrt(1.0D - d1) * d2);
      }
    }
  }
  
  public final long a(float paramFloat1, float paramFloat2, long paramLong)
  {
    AppMethodBeat.i(203383);
    init();
    paramFloat1 -= this.VP;
    double d1 = paramLong / 1000.0D;
    double d3;
    double d2;
    double d4;
    double d5;
    double d6;
    if (this.UV > 1.0F)
    {
      d3 = paramFloat1 - (this.VS * paramFloat1 - paramFloat2) / (this.VS - this.VR);
      d2 = this.VS;
      d4 = (paramFloat1 * d2 - paramFloat2) / (this.VS - this.VR);
      d2 = Math.exp(this.VS * d1) * d3 + Math.exp(this.VR * d1) * d4;
      d5 = this.VS;
      d6 = Math.exp(this.VS * d1);
      d1 = d4 * this.VR * Math.exp(d1 * this.VR) + d3 * d5 * d6;
    }
    for (;;)
    {
      paramLong = ap.t((float)(d2 + this.VP), (float)d1);
      AppMethodBeat.o(203383);
      return paramLong;
      if (this.UV == 1.0F) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label290;
        }
        d2 = paramFloat2;
        d3 = this.VQ * paramFloat1 + d2;
        d2 = (paramFloat1 + d3 * d1) * Math.exp(-this.VQ * d1);
        d1 = (paramFloat1 + d3 * d1) * Math.exp(-this.VQ * d1) * -this.VQ + Math.exp(d1 * -this.VQ) * d3;
        break;
      }
      label290:
      d2 = 1.0D / this.VT;
      d3 = (this.UV * this.VQ * paramFloat1 + paramFloat2) * d2;
      d2 = Math.exp(-this.UV * this.VQ * d1) * (paramFloat1 * Math.cos(this.VT * d1) + Math.sin(this.VT * d1) * d3);
      d4 = -this.VQ;
      d5 = this.UV;
      d6 = Math.exp(-this.UV * this.VQ * d1);
      double d7 = -this.VT;
      double d8 = paramFloat1;
      double d9 = Math.sin(this.VT * d1);
      double d10 = this.VT;
      d1 = (d8 * d7 * d9 + Math.cos(d1 * this.VT) * (d3 * d10)) * d6 + d4 * d2 * d5;
    }
  }
  
  public final float lP()
  {
    return (float)(this.VQ * this.VQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.ao
 * JD-Core Version:    0.7.0.1
 */