package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.Metrics;
import android.support.constraint.solver.SolverVariable;

public class ResolutionAnchor
  extends ResolutionNode
{
  public static final int BARRIER_CONNECTION = 5;
  public static final int CENTER_CONNECTION = 2;
  public static final int CHAIN_CONNECTION = 4;
  public static final int DIRECT_CONNECTION = 1;
  public static final int MATCH_CONNECTION = 3;
  public static final int UNCONNECTED = 0;
  float computedValue;
  private ResolutionDimension dimension = null;
  private int dimensionMultiplier = 1;
  ConstraintAnchor myAnchor;
  float offset;
  private ResolutionAnchor opposite;
  private ResolutionDimension oppositeDimension = null;
  private int oppositeDimensionMultiplier = 1;
  private float oppositeOffset;
  float resolvedOffset;
  ResolutionAnchor resolvedTarget;
  ResolutionAnchor target;
  int type = 0;
  
  public ResolutionAnchor(ConstraintAnchor paramConstraintAnchor)
  {
    this.myAnchor = paramConstraintAnchor;
  }
  
  void addResolvedValue(LinearSystem paramLinearSystem)
  {
    SolverVariable localSolverVariable = this.myAnchor.getSolverVariable();
    if (this.resolvedTarget == null)
    {
      paramLinearSystem.addEquality(localSolverVariable, (int)(this.resolvedOffset + 0.5F));
      return;
    }
    paramLinearSystem.addEquality(localSolverVariable, paramLinearSystem.createObjectVariable(this.resolvedTarget.myAnchor), (int)(this.resolvedOffset + 0.5F), 6);
  }
  
  public void dependsOn(int paramInt1, ResolutionAnchor paramResolutionAnchor, int paramInt2)
  {
    this.type = paramInt1;
    this.target = paramResolutionAnchor;
    this.offset = paramInt2;
    this.target.addDependent(this);
  }
  
  public void dependsOn(ResolutionAnchor paramResolutionAnchor, int paramInt)
  {
    this.target = paramResolutionAnchor;
    this.offset = paramInt;
    this.target.addDependent(this);
  }
  
  public void dependsOn(ResolutionAnchor paramResolutionAnchor, int paramInt, ResolutionDimension paramResolutionDimension)
  {
    this.target = paramResolutionAnchor;
    this.target.addDependent(this);
    this.dimension = paramResolutionDimension;
    this.dimensionMultiplier = paramInt;
    this.dimension.addDependent(this);
  }
  
  public float getResolvedValue()
  {
    return this.resolvedOffset;
  }
  
  public void remove(ResolutionDimension paramResolutionDimension)
  {
    if (this.dimension == paramResolutionDimension)
    {
      this.dimension = null;
      this.offset = this.dimensionMultiplier;
    }
    for (;;)
    {
      resolve();
      return;
      if (this.dimension == this.oppositeDimension)
      {
        this.oppositeDimension = null;
        this.oppositeOffset = this.oppositeDimensionMultiplier;
      }
    }
  }
  
  public void reset()
  {
    super.reset();
    this.target = null;
    this.offset = 0.0F;
    this.dimension = null;
    this.dimensionMultiplier = 1;
    this.oppositeDimension = null;
    this.oppositeDimensionMultiplier = 1;
    this.resolvedTarget = null;
    this.resolvedOffset = 0.0F;
    this.computedValue = 0.0F;
    this.opposite = null;
    this.oppositeOffset = 0.0F;
    this.type = 0;
  }
  
  public void resolve()
  {
    if (this.state == 1) {}
    label8:
    label329:
    label380:
    do
    {
      do
      {
        do
        {
          break label8;
          do
          {
            return;
          } while (this.type == 4);
          if (this.dimension == null) {
            break;
          }
        } while (this.dimension.state != 1);
        this.offset = (this.dimensionMultiplier * this.dimension.value);
        if (this.oppositeDimension == null) {
          break;
        }
      } while (this.oppositeDimension.state != 1);
      this.oppositeOffset = (this.oppositeDimensionMultiplier * this.oppositeDimension.value);
      if ((this.type == 1) && ((this.target == null) || (this.target.state == 1)))
      {
        if (this.target == null) {
          this.resolvedTarget = this;
        }
        for (this.resolvedOffset = this.offset;; this.resolvedOffset = (this.target.resolvedOffset + this.offset))
        {
          didResolve();
          return;
          this.resolvedTarget = this.target.resolvedTarget;
        }
      }
      Object localObject;
      if ((this.type == 2) && (this.target != null) && (this.target.state == 1) && (this.opposite != null) && (this.opposite.target != null) && (this.opposite.target.state == 1))
      {
        if (LinearSystem.getMetrics() != null)
        {
          localObject = LinearSystem.getMetrics();
          ((Metrics)localObject).centerConnectionResolved += 1L;
        }
        this.resolvedTarget = this.target.resolvedTarget;
        this.opposite.resolvedTarget = this.opposite.target.resolvedTarget;
        int i;
        float f1;
        float f2;
        int k;
        int j;
        if ((this.myAnchor.mType == ConstraintAnchor.Type.RIGHT) || (this.myAnchor.mType == ConstraintAnchor.Type.BOTTOM))
        {
          i = 1;
          if (i == 0) {
            break label515;
          }
          f1 = this.target.resolvedOffset - this.opposite.target.resolvedOffset;
          if ((this.myAnchor.mType != ConstraintAnchor.Type.LEFT) && (this.myAnchor.mType != ConstraintAnchor.Type.RIGHT)) {
            break label537;
          }
          f2 = f1 - this.myAnchor.mOwner.getWidth();
          f1 = this.myAnchor.mOwner.mHorizontalBiasPercent;
          k = this.myAnchor.getMargin();
          j = this.opposite.myAnchor.getMargin();
          if (this.myAnchor.getTarget() == this.opposite.myAnchor.getTarget())
          {
            f1 = 0.5F;
            j = 0;
            k = 0;
          }
          f2 = f2 - k - j;
          if (i == 0) {
            break label565;
          }
          localObject = this.opposite;
          float f3 = this.opposite.target.resolvedOffset;
          ((ResolutionAnchor)localObject).resolvedOffset = (j + f3 + f2 * f1);
        }
        for (this.resolvedOffset = (this.target.resolvedOffset - k - (1.0F - f1) * f2);; this.opposite.resolvedOffset = (this.opposite.target.resolvedOffset - j - (1.0F - f1) * f2))
        {
          didResolve();
          this.opposite.didResolve();
          return;
          i = 0;
          break;
          f1 = this.opposite.target.resolvedOffset - this.target.resolvedOffset;
          break label329;
          f2 = f1 - this.myAnchor.mOwner.getHeight();
          f1 = this.myAnchor.mOwner.mVerticalBiasPercent;
          break label380;
          this.resolvedOffset = (this.target.resolvedOffset + k + f2 * f1);
        }
      }
      if ((this.type == 3) && (this.target != null) && (this.target.state == 1) && (this.opposite != null) && (this.opposite.target != null) && (this.opposite.target.state == 1))
      {
        if (LinearSystem.getMetrics() != null)
        {
          localObject = LinearSystem.getMetrics();
          ((Metrics)localObject).matchConnectionResolved += 1L;
        }
        this.resolvedTarget = this.target.resolvedTarget;
        this.opposite.resolvedTarget = this.opposite.target.resolvedTarget;
        this.resolvedOffset = (this.target.resolvedOffset + this.offset);
        this.opposite.resolvedOffset = (this.opposite.target.resolvedOffset + this.opposite.offset);
        didResolve();
        this.opposite.didResolve();
        return;
      }
    } while (this.type != 5);
    label515:
    label537:
    label565:
    this.myAnchor.mOwner.resolve();
  }
  
  public void resolve(ResolutionAnchor paramResolutionAnchor, float paramFloat)
  {
    if ((this.state == 0) || ((this.resolvedTarget != paramResolutionAnchor) && (this.resolvedOffset != paramFloat)))
    {
      this.resolvedTarget = paramResolutionAnchor;
      this.resolvedOffset = paramFloat;
      if (this.state == 1) {
        invalidate();
      }
      didResolve();
    }
  }
  
  String sType(int paramInt)
  {
    if (paramInt == 1) {
      return "DIRECT";
    }
    if (paramInt == 2) {
      return "CENTER";
    }
    if (paramInt == 3) {
      return "MATCH";
    }
    if (paramInt == 4) {
      return "CHAIN";
    }
    if (paramInt == 5) {
      return "BARRIER";
    }
    return "UNCONNECTED";
  }
  
  public void setOpposite(ResolutionAnchor paramResolutionAnchor, float paramFloat)
  {
    this.opposite = paramResolutionAnchor;
    this.oppositeOffset = paramFloat;
  }
  
  public void setOpposite(ResolutionAnchor paramResolutionAnchor, int paramInt, ResolutionDimension paramResolutionDimension)
  {
    this.opposite = paramResolutionAnchor;
    this.oppositeDimension = paramResolutionDimension;
    this.oppositeDimensionMultiplier = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public String toString()
  {
    if (this.state == 1)
    {
      if (this.resolvedTarget == this) {
        return "[" + this.myAnchor + ", RESOLVED: " + this.resolvedOffset + "]  type: " + sType(this.type);
      }
      return "[" + this.myAnchor + ", RESOLVED: " + this.resolvedTarget + ":" + this.resolvedOffset + "] type: " + sType(this.type);
    }
    return "{ " + this.myAnchor + " UNRESOLVED} type: " + sType(this.type);
  }
  
  public void update()
  {
    ConstraintAnchor localConstraintAnchor = this.myAnchor.getTarget();
    if (localConstraintAnchor == null) {
      return;
    }
    if (localConstraintAnchor.getTarget() == this.myAnchor)
    {
      this.type = 4;
      localConstraintAnchor.getResolutionNode().type = 4;
    }
    int j = this.myAnchor.getMargin();
    int i;
    if (this.myAnchor.mType != ConstraintAnchor.Type.RIGHT)
    {
      i = j;
      if (this.myAnchor.mType != ConstraintAnchor.Type.BOTTOM) {}
    }
    else
    {
      i = -j;
    }
    dependsOn(localConstraintAnchor.getResolutionNode(), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.ResolutionAnchor
 * JD-Core Version:    0.7.0.1
 */